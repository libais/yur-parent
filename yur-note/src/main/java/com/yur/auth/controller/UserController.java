package com.yur.auth.controller;

import com.yur.auth.entity.User;
import com.yur.auth.service.UserService;
import com.yur.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/hello/{id}")
    public String hello( @PathVariable(value = "id") String id){
        return "hello="+ id;
    }

    @ResponseBody
    @RequestMapping("/{userId}")
    public Object getUserById(@PathVariable(value = "userId") Integer userId) {
        try {
//            return userService.getUserById(userId);
            User user = userService.getUserById(userId);
            List<User> data = new ArrayList<>();
            data.add(user);
//            return new GridResponse<User>(data, 1);
            return new CommonResponse(true, user);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResponse(false, e.getMessage());
        }
    }
}