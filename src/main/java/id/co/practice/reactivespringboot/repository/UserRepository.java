package id.co.practice.reactivespringboot.repository;

import id.co.practice.reactivespringboot.model.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface UserRepository extends R2dbcRepository<UserEntity, UUID> {
    Flux<UserEntity> findAllBy(Pageable pageable);
}
