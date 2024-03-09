package com.miracle.rpc.server;

/**
 * @author dargon
 * @create 2024-02-25
 * @description HttpServer 接口
 */
public interface HttpServer {

    /**
     * 启动服务器
     *
     * @param port
     */
    void doStart(int port);
}
