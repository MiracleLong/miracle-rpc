package com.miracle.example.provider;

import com.miracle.example.common.service.UserService;
import com.miracle.rpc.RpcApplication;
import com.miracle.rpc.registry.LocalRegistry;
import com.miracle.rpc.server.HttpServer;
import com.miracle.rpc.server.VertxHttpServer;

/**
 * @author dargon
 * @create 2024-03-06
 * @description 简易提供者实例
 */
public class ProviderExample {
    public static void main(String[] args)
    {
        // 初始化配置
        RpcApplication.init();
        System.out.println("启动服务");
        //注册服务 特别注意服务注册到本地注册中心
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);
        // 启动服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
