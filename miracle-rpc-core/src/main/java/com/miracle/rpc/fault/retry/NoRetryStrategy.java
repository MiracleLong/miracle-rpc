package com.miracle.rpc.fault.retry;

import com.miracle.rpc.model.RpcResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @author dargon
 * @create 2024-03-17
 * @description 重试策略 -- 不重试策略
 */
@Slf4j
public class NoRetryStrategy implements RetryStrategy{

    /**
     * 重试
     *
     * @param callable
     * @return
     * @throws Exception
     */
    public RpcResponse doRetry(Callable<RpcResponse> callable) throws Exception {
        return callable.call();
    }
}
