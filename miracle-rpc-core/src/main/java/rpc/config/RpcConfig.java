package rpc.config;

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
    private Integer serverPort = 8080;

}
