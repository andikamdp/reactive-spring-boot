package id.co.practice.reactivespringboot.service.orchestration;

import id.co.practice.reactivespringboot.model.DepartmentEntity;
import id.co.practice.reactivespringboot.service.application.DepartmentApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class DepartmentOrchestrationService {

    private final DepartmentApplicationService departmentApplicationService;

    public Mono<DepartmentEntity> createDepartment(DepartmentEntity department) {
        // Add business logic here if needed before saving
        return departmentApplicationService.createDepartment(department);
    }

    public Mono<DepartmentEntity> getDepartmentById(BigInteger id) {
        return departmentApplicationService.getDepartmentById(id);
    }

    public Flux<DepartmentEntity> getAllDepartments() {
        return departmentApplicationService.getAllDepartments();
    }

    public Flux<DepartmentEntity> getAllDepartments(Pageable pageable) {
        return departmentApplicationService.getAllDepartments(pageable);
    }

    public Mono<DepartmentEntity> updateDepartment(BigInteger id, DepartmentEntity department) {
        // Add business logic here if needed before updating
        return departmentApplicationService.updateDepartment(id, department);
    }

    public Mono<Void> deleteDepartment(BigInteger id) {
        return departmentApplicationService.deleteDepartment(id);
    }
}
