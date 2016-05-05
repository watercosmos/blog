package com.lhy.blog.controller;

import com.lhy.blog.constant.Message;
import com.lhy.blog.dict.ErrorCode;
import com.lhy.blog.domain.User;
import com.lhy.blog.exception.BusinessException;
import com.lhy.blog.service.UserService;
import com.lhy.blog.vo.Result;
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

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Result getUserById(@RequestParam("userId") Integer userId) {
        LOGGER.info("getUserById: userId = {}", userId);
        User user = userService.getUserById(userId);
        return Result.builder().data(user).success().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result insertUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.warn(bindingResult.toString());
            return Result.builder().failed(ErrorCode.BAD_REQUEST).build();
        }
        LOGGER.info("insertUser: user = {}", user);
        userService.insertUser(user);
        return Result.builder().data(Message.OPERATE_SUCCESS).success().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Result updateUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.warn(bindingResult.toString());
            return Result.builder().failed(ErrorCode.BAD_REQUEST).build();
        }
        LOGGER.info("updateUser: user = {}", user);
        userService.updateUser(user);
        return Result.builder().data(Message.OPERATE_SUCCESS).success().build();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Result deleteUserById(@RequestParam("userId") Integer userId) {
        LOGGER.info("deleteUserById: userId = {}", userId);
        userService.deleteUser(userId);
        return Result.builder().data(Message.OPERATE_SUCCESS).success().build();
    }

    @RequestMapping("/error")
    public Result error() {
        throw new BusinessException(Message.UNKNOWN_ERROR);
    }

}
