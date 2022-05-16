package com.dailycodebuffer.user.Service;

import com.dailycodebuffer.user.Entity.User;
import com.dailycodebuffer.user.Repository.UserRepository;
import com.dailycodebuffer.user.ValueObjects.Department;
import com.dailycodebuffer.user.ValueObjects.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    public User addUser(User user) {
        log.info("Inside addUser : UserService");
        return userRepository.save(user);
    }

    public ResponseTemplate getUserWithDepartment(long id) {
        log.info("Inside getUserWithDepartment : UserService");

        ResponseTemplate res = new ResponseTemplate();
        User user = userRepository.findByUserId(id);

        //Department department= ????
        //For department call microservice: department-service
        // Use RestTemplate
        log.info("USER's Department Id " + user.getDepartmentId());
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        log.info("ms department-service worked !");
        res.setUser(user);
        res.setDepartment(department);

        return res;
    }
}
