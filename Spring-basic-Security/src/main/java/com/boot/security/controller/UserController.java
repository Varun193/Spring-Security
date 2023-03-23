package com.boot.security.controller;

import com.boot.security.entity.UserInfo;
import com.boot.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/new")
    public void addUser(@RequestBody UserInfo userInfo) {

        userService.addUser(userInfo);
    }
}
