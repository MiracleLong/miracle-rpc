package com.miracle.example.consumer;

import com.miracle.example.common.model.User;
import com.miracle.example.common.service.UserService;
import rpc.config.RpcConfig;
import rpc.proxy.ServiceProxyFactory;
import rpc.utils.ConfigUtils;

/**
 * @author dargon
 * @create 2024-03-06
 * @description 简易消费者实例
 */
public class ConsumerExample {
    public static void main(String[] args) {
        //RpcConfig rpcConfig = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        //System.out.println(rpcConfig);
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("miracle");
        //调用
        User newUser = userService.getUser(user);
        if (newUser != null){
            System.out.println("调用成功，返回值为：" + newUser.getName());
        } else {
            System.out.println("调用失败");
        }
        long number = userService.getNumber();
        System.out.println("number = " + number);
    }
}
