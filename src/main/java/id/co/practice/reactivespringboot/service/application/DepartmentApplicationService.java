package id.co.practice.reactivespringboot.service.application;

import id.co.practice.reactivespringboot.dao.DepartmentDao;
import id.co.practice.reactivespringboot.model.DepartmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class DepartmentApplicationService {

    private final DepartmentDao departmentDao;

    public Mono<DepartmentEntity> createDepartment(DepartmentEntity department) {
        return departmentDao.save(department);
    }

    public Mono<DepartmentEntity> getDepartmentById(BigInteger id) {
        return departmentDao.findById(id);
    }

    public Flux<DepartmentEntity> getAllDepartments() {
        return departmentDao.findAll();
    }

    public Flux<DepartmentEntity> getAllDepartments(Pageable pageable) {
        return departmentDao.findAll(pageable);
    }

    public Mono<DepartmentEntity> updateDepartment(BigInteger id, DepartmentEntity department) {
        return departmentDao.findById(id)
                .flatMap(existingDepartment -> {
                    existingDepartment.setName(department.getName());
                    existingDepartment.setStatus(department.getStatus());
                    return departmentDao.save(existingDepartment);
                });
    }

    public Mono<Void> deleteDepartment(BigInteger id) {
        return departmentDao.deleteById(id);
    }
}
