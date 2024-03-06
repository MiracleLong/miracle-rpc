package com.miracle.example.consumer;

import rpc.config.RpcConfig;
import rpc.utils.ConfigUtils;

/**
 * @author dargon
 * @create 2024-03-06
 * @description 简易消费者实例
 */
public class ConsumerExample {
    public static void main(String[] args) {
        RpcConfig rpcConfig = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpcConfig);
    }
}
