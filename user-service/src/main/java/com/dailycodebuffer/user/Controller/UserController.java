package com.dailycodebuffer.user.Controller;

import com.dailycodebuffer.user.Entity.User;
import com.dailycodebuffer.user.Service.UserService;
import com.dailycodebuffer.user.ValueObjects.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        log.info("Inside addUser : UserController");
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getUserWithDepartment(@PathVariable Long id){
        log.info("Inside getUserWithDepartment : UserController");
        return userService.getUserWithDepartment(id);
    }
}
