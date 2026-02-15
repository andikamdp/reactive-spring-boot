package id.co.practice.reactivespringboot.service.orchestration;

import id.co.practice.reactivespringboot.model.UserEntity;
import id.co.practice.reactivespringboot.service.application.UserApplicationService;
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

    public Mono<UserEntity> createUser(UserEntity user) {
        // Add business logic here if needed before saving
        return userApplicationService.createUser(user);
    }

    public Mono<UserEntity> getUserById(UUID id) {
        return userApplicationService.getUserById(id);
    }

    public Flux<UserEntity> getAllUsers() {
        return userApplicationService.getAllUsers();
    }

    public Flux<UserEntity> getAllUsers(Pageable pageable) {
        return userApplicationService.getAllUsers(pageable);
    }

    public Mono<UserEntity> updateUser(UUID id, UserEntity user) {
        // Add business logic here if needed before updating
        return userApplicationService.updateUser(id, user);
    }

    public Mono<Void> deleteUser(UUID id) {
        return userApplicationService.deleteUser(id);
    }
}
