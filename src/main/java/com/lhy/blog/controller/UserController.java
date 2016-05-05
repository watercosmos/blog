package com.lhy.blog.controller;

import com.lhy.blog.domain.User;
import com.lhy.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by lhy on 16/5/3.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public User getUserById(@RequestParam("userId") Integer userId) {
        LOGGER.info("getUserById: userId = {}", userId);
        return userService.getUserById(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int insertUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.warn(bindingResult.toString());
            return 0;
        }
        LOGGER.info("insertUser: user = {}", user);
        return userService.insertUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public int updateUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.warn(bindingResult.toString());
            return 0;
        }
        LOGGER.info("updateUser: user = {}", user);
        return userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteUserById(@RequestParam("userId") Integer userId) {
        LOGGER.info("deleteUserById: userId = {}", userId);
        return userService.deleteUser(userId);
    }

}
