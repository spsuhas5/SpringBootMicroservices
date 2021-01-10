package com.springboot.microservice.departmentservice.controller;

import com.springboot.microservice.departmentservice.entity.Department;
import com.springboot.microservice.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("inside saveDepartment method of department controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Optional<Department> findByDepartmentId(@PathVariable("id") Long departmentId) {
        log.info("inside findDepartmentById method of department controller");
        return departmentService.findByDepartmentId(departmentId);
    }
}
