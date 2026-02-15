package id.co.practice.reactivespringboot.service.application;

import id.co.practice.reactivespringboot.dao.UserDao;
import id.co.practice.reactivespringboot.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserApplicationService {

    private final UserDao userDao;

    public Mono<UserEntity> createUser(UserEntity user) {
        user.generateId(); // Generate UUID v7
        return userDao.save(user);
    }

    public Mono<UserEntity> getUserById(UUID id) {
        return userDao.findById(id);
    }

    public Flux<UserEntity> getAllUsers() {
        return userDao.findAll();
    }

    public Flux<UserEntity> getAllUsers(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    public Mono<UserEntity> updateUser(UUID id, UserEntity user) {
        return userDao.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setDepartmentId(user.getDepartmentId());
                    existingUser.setBirthdate(user.getBirthdate());
                    existingUser.setLastLoginDate(user.getLastLoginDate());
                    existingUser.setStatus(user.getStatus());
                    // Ensure we don't treat this as a new insert
                    existingUser.setNew(false);
                    return userDao.save(existingUser);
                });
    }

    public Mono<Void> deleteUser(UUID id) {
        return userDao.deleteById(id);
    }
}
