package com.miracle.example.consumer;

import com.miracle.example.common.model.User;
import com.miracle.example.common.service.UserService;
import com.miracle.rpc.proxy.ServiceProxyFactory;

/**
 * @author dargon
 * @create 2024-02-25
 * @descpription easy-rpc 服务消费者
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
        // 静态代理
//        UserService userService = new UserServiceProxy();
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("miracle");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
