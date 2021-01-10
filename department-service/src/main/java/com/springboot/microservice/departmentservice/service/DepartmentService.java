package com.springboot.microservice.departmentservice.service;

import com.springboot.microservice.departmentservice.entity.Department;
import com.springboot.microservice.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("inside save method of Department service");
        return departmentRepository.save(department);
    }

    public Optional<Department> findByDepartmentId(Long departmentId) {
        log.info("inside findDepartmentById method of Department service");
        return departmentRepository.findById(departmentId);
    }
}
