package com.springboot.microservice.userservice.service;

import com.springboot.microservice.userservice.entity.Users;
import com.springboot.microservice.userservice.repository.UserRepository;
import com.springboot.microservice.userservice.vo.Department;
import com.springboot.microservice.userservice.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public Users saveUser(Users user) {
        log.info("inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("inside getUserWithDepartment method of UserService");
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();

        Users user = userRepository.findById(userId).get();

        Department department = restTemplate.getForObject("http://department-service/department/" + user.getDepartmentId(),
                Department.class);

        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
