package com.yur.auth.service.impl;

import com.yur.auth.dao.UserMapper;
import com.yur.auth.entity.User;
import com.yur.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer userId) throws Exception{
        return userMapper.getUserById(userId);
    }
}
