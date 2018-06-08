package com.yur.auth.service;

import com.yur.auth.entity.User;

public interface UserService {

    User getUserById(Integer userId) throws Exception;

}
