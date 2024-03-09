package com.miracle.rpc.config;

import com.miracle.rpc.serializer.SerializerKeys;
import lombok.Data;

/**
 * @author dargon
 * @create 2024-03-04
 * @description rpc配置
 */
@Data
public class RpcConfig {

    /**
     * 服务名
     */
    private String name = "miracle-rpc";
    /**
     * 版本
     */
    private String version = "1.0.0";
    /**
     * 服务端host
     */
    private String serverHost = "localhost";
    /**
     * 服务端端口
     */
    private Integer serverPort = 8081;
    /**
     * 模拟服务
     */
    private boolean mock = false;
    /**
     * 序列化方式
     */
    private String serializer = SerializerKeys.JDK;

}