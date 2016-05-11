package com.lhy.blog.service;

import com.lhy.blog.domain.User;
import com.lhy.blog.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lhy on 16/5/3.
 */
@Service
@Transactional()
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    UserMapper userMapper;

    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int deleteUser(Integer userId) {
        return userMapper.deleteUserById(userId);
    }

}
