package id.co.practice.reactivespringboot.repository;

import id.co.practice.reactivespringboot.model.DepartmentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.math.BigInteger;

@Repository
public interface DepartmentRepository extends R2dbcRepository<DepartmentEntity, BigInteger> {
    Flux<DepartmentEntity> findAllBy(Pageable pageable);
}
