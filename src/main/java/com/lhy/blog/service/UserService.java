package com.lhy.blog.service;

import com.lhy.blog.domain.User;
import com.lhy.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lhy on 16/5/3.
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findUserById(Integer userId) {
        return userMapper.findById(userId);
    }
}
