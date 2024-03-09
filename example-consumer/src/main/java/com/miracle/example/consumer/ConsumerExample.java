package com.miracle.example.consumer;

import com.miracle.example.common.model.User;
import com.miracle.example.common.service.UserService;
import com.miracle.rpc.config.RpcConfig;
import com.miracle.rpc.proxy.ServiceProxyFactory;
import com.miracle.rpc.utils.ConfigUtils;

/**
 * @author dargon
 * @create 2024-03-06
 * @description 简易消费者实例
 */
public class ConsumerExample {
    public static void main(String[] args) {
        // 获取代理
        RpcConfig rpcConfig = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpcConfig);
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("测试用户");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser == null) {
            System.out.println("user is null");
        } else {
            System.out.println(user.getName());
        }
        long number = userService.getNumber();
        System.out.println(number);
    }
}
