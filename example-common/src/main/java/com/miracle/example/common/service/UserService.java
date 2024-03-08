package com.miracle.example.common.service;

import com.miracle.example.common.model.User;

/**
 * @author dargon
 * @create 2024-02-25
 * @description 用户服务
 */
public interface UserService {

    /**
     * 获取用户
     *
     * @param user
     * @return
     */
    User getUser(User user);

    default Short getNumber() {
        return 1;
    }
}
