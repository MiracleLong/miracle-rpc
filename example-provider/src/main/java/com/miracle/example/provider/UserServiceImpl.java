package com.miracle.example.provider;

import com.miracle.example.common.model.User;
import com.miracle.example.common.service.UserService;

/**
 * @author dargon
 * @create 2024-02-25
 */
public class UserServiceImpl implements UserService {
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
