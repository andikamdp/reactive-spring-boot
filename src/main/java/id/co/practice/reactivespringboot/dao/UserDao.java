package id.co.practice.reactivespringboot.dao;

import id.co.practice.reactivespringboot.model.UserEntity;
import id.co.practice.reactivespringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final UserRepository userRepository;

    public Mono<UserEntity> save(UserEntity user) {
        return userRepository.save(user);
    }

    public Mono<UserEntity> findById(UUID id) {
        return userRepository.findById(id);
    }

    public Flux<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Flux<UserEntity> findAll(Pageable pageable) {
        return userRepository.findAllBy(pageable);
    }

    public Mono<Void> deleteById(UUID id) {
        return userRepository.deleteById(id);
    }
    
    public Mono<Long> count() {
        return userRepository.count();
    }
}
