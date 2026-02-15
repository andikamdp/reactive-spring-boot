package id.co.practice.reactivespringboot.controller;

import id.co.practice.reactivespringboot.dto.UserRequest;
import id.co.practice.reactivespringboot.model.UserEntity;
import id.co.practice.reactivespringboot.service.orchestration.UserOrchestrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserOrchestrationService userOrchestrationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UserEntity> createUser(@RequestBody UserRequest request) {
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .departmentId(request.getDepartmentId())
                .birthdate(request.getBirthdate())
                .status(request.getStatus())
                .build();
        return userOrchestrationService.createUser(user);
    }

    @GetMapping("/{id}")
    public Mono<UserEntity> getUserById(@PathVariable UUID id) {
        return userOrchestrationService.getUserById(id);
    }

    @GetMapping
    public Flux<UserEntity> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return userOrchestrationService.getAllUsers(PageRequest.of(page, size));
    }

    @PutMapping("/{id}")
    public Mono<UserEntity> updateUser(@PathVariable UUID id, @RequestBody UserRequest request) {
        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .departmentId(request.getDepartmentId())
                .birthdate(request.getBirthdate())
                .status(request.getStatus())
                .build();
        return userOrchestrationService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUser(@PathVariable UUID id) {
        return userOrchestrationService.deleteUser(id);
    }
}
