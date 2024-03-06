package com.miracle.example.provider;

import com.miracle.example.common.service.UserService;
import rpc.registry.LocalRegistry;
import rpc.server.HttpServer;
import rpc.server.VertxHttpServer;


/**
 * @author dargon
 * @create 2024-02-25
 * @description easy provider example
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
