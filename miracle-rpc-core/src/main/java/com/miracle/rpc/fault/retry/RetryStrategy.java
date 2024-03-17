package com.miracle.rpc.fault.retry;

import com.miracle.rpc.model.RpcResponse;

import java.util.concurrent.Callable;

/**
 * @author dargon
 * @create 2024-03-15
 * @description 重试策略
 */
public interface RetryStrategy {

    /**
     * 重试
     *
     * @param callable
     * @return
     * @throws Exception
     */
    RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception;
}
