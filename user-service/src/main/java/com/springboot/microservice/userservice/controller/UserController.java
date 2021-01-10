package com.springboot.microservice.userservice.controller;

import com.springboot.microservice.userservice.entity.Users;
import com.springboot.microservice.userservice.service.UserService;
import com.springboot.microservice.userservice.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public Users saveUser(@RequestBody Users user) {
        log.info("inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("inside getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
