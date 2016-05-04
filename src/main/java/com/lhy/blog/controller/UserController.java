package com.lhy.blog.controller;

import com.lhy.blog.domain.User;
import com.lhy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lhy on 16/5/3.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public User getUserById(@RequestParam("userId") Integer userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteUserById(@RequestParam("userId") Integer userId) {
        return userService.deleteUser(userId);
    }

}
