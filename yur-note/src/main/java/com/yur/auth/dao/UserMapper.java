package com.yur.auth.dao;

import com.yur.auth.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getUserById(Integer userId);

}
