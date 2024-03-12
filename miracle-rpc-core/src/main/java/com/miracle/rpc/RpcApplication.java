package com.miracle.rpc;

import com.miracle.rpc.config.RegistryConfig;
import com.miracle.rpc.config.RpcConfig;
import com.miracle.rpc.constant.RpcConstant;
import com.miracle.rpc.registry.Registry;
import com.miracle.rpc.registry.RegistryFactory;
import com.miracle.rpc.utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dargon
 * @create 2024-03-06
 */
@Slf4j
public class RpcApplication {

    private static volatile RpcConfig rpcConfig;

    /**
     * 初始化
     */
    public static void init() {
        RpcConfig newRpcConfig;
        try {
            newRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            newRpcConfig = new RpcConfig();
        }
        init(newRpcConfig);
    }

    /**
     * 框架初始化，支持自定传入配置
     * @param newRpcConfig
     */
    public static void init(RpcConfig newRpcConfig){
        rpcConfig = newRpcConfig;
        log.info("rpc init, config = {}", newRpcConfig.toString());
        // 注册中心初始化
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        registry.init(registryConfig);
        log.info("registry init, config = {}", registryConfig);

    }

    /**
     * 获取配置
     * @return
     */
    public static RpcConfig getRpcConfig(){
        if (rpcConfig == null){
            synchronized (RpcApplication.class){
                if (rpcConfig == null){
                    init();
                }
            }
        }
        return rpcConfig;
    }

}
