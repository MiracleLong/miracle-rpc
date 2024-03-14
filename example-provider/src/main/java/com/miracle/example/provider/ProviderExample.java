package com.miracle.example.provider;

import com.miracle.example.common.service.UserService;
import com.miracle.rpc.RpcApplication;
import com.miracle.rpc.config.RegistryConfig;
import com.miracle.rpc.config.RpcConfig;
import com.miracle.rpc.model.ServiceMetaInfo;
import com.miracle.rpc.registry.LocalRegistry;
import com.miracle.rpc.registry.Registry;
import com.miracle.rpc.registry.RegistryFactory;
import com.miracle.rpc.server.tcp.VertxTcpServer;

/**
 * @author dargon
 * @create 2024-03-06
 * @description 简易提供者实例
 */
public class ProviderExample {
    public static void main(String[] args)
    {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 TCP 服务
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(8080);
    }
}
