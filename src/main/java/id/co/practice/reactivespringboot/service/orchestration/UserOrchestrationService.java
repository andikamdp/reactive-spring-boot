package id.co.practice.reactivespringboot.service.orchestration;

import id.co.practice.reactivespringboot.model.UserEntity;
import id.co.practice.reactivespringboot.service.application.DepartmentApplicationService;
import id.co.practice.reactivespringboot.service.application.UserApplicationService;
import id.co.practice.reactivespringboot.utils.DepartmentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserOrchestrationService {

    private final UserApplicationService userApplicationService;
    private final DepartmentApplicationService departmentApplicationService;

    public Mono<UserEntity> createUser(UserEntity user) {
        if (user.getDepartmentId() == null) {
            return Mono.error(new IllegalArgumentException("Department ID is required"));
        }
        return this.departmentApplicationService.getDepartmentById(user.getDepartmentId())
                .switchIfEmpty(Mono.error(new DepartmentNotFoundException("Department ID " + user.getDepartmentId() + " not found")))
                .flatMap(department -> this.userApplicationService.createUser(user));
    }

    public Mono<UserEntity> getUserById(UUID id) {
        return this.userApplicationService.getUserById(id);
    }

    public Flux<UserEntity> getAllUsers() {
        return this.userApplicationService.getAllUsers();
    }

    public Flux<UserEntity> getAllUsers(Pageable pageable) {
        return this.userApplicationService.getAllUsers(pageable);
    }

    public Mono<UserEntity> updateUser(UUID id, UserEntity user) {
        if (user.getDepartmentId() == null) {
            return Mono.error(new IllegalArgumentException("Department ID is required"));
        }
        return this.departmentApplicationService.getDepartmentById(user.getDepartmentId())
                .switchIfEmpty(Mono.error(new DepartmentNotFoundException("Department ID " + user.getDepartmentId() + " not found")))
                .flatMap(department -> this.userApplicationService.updateUser(id, user));
    }

    public Mono<Void> deleteUser(UUID id) {
        return this.userApplicationService.deleteUser(id);
    }
}
