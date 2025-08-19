package com.aiden.service.impl;

import com.aiden.mapper.UserMapper;
import com.aiden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String getUser(String userId) {
        if (userId != null && !userId.isEmpty()) {
            Long id = Long.valueOf(userId);
            return userMapper.selectById(id).toString();
        }
        return "User ID cannot be null or empty";
    }
}
