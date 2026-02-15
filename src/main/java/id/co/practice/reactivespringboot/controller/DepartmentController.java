package id.co.practice.reactivespringboot.controller;

import id.co.practice.reactivespringboot.dto.DepartmentRequest;
import id.co.practice.reactivespringboot.model.DepartmentEntity;
import id.co.practice.reactivespringboot.service.orchestration.DepartmentOrchestrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentOrchestrationService departmentOrchestrationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<DepartmentEntity> createDepartment(@RequestBody DepartmentRequest request) {
        DepartmentEntity department = DepartmentEntity.builder()
                .name(request.getName())
                .status(request.getStatus())
                .build();
        return departmentOrchestrationService.createDepartment(department);
    }

    @GetMapping("/{id}")
    public Mono<DepartmentEntity> getDepartmentById(@PathVariable BigInteger id) {
        return departmentOrchestrationService.getDepartmentById(id);
    }

    @GetMapping
    public Flux<DepartmentEntity> getAllDepartments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return departmentOrchestrationService.getAllDepartments(PageRequest.of(page, size));
    }

    @PutMapping("/{id}")
    public Mono<DepartmentEntity> updateDepartment(@PathVariable BigInteger id, @RequestBody DepartmentRequest request) {
        DepartmentEntity department = DepartmentEntity.builder()
                .name(request.getName())
                .status(request.getStatus())
                .build();
        return departmentOrchestrationService.updateDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteDepartment(@PathVariable BigInteger id) {
        return departmentOrchestrationService.deleteDepartment(id);
    }
}
