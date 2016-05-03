package com.lhy.blog.controller;

import com.lhy.blog.domain.User;
import com.lhy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lhy on 16/5/3.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public User getUser() {
        return userService.findUserById(1);
    }

}
