package id.co.practice.reactivespringboot.dao;

import id.co.practice.reactivespringboot.model.DepartmentEntity;
import id.co.practice.reactivespringboot.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Component
@RequiredArgsConstructor
public class DepartmentDao {

    private final DepartmentRepository departmentRepository;

    public Mono<DepartmentEntity> save(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    public Mono<DepartmentEntity> findById(BigInteger id) {
        return departmentRepository.findById(id);
    }

    public Flux<DepartmentEntity> findAll() {
        return departmentRepository.findAll();
    }

    public Flux<DepartmentEntity> findAll(Pageable pageable) {
        return departmentRepository.findAllBy(pageable);
    }

    public Mono<Void> deleteById(BigInteger id) {
        return departmentRepository.deleteById(id);
    }

    public Mono<Long> count() {
        return departmentRepository.count();
    }
}
