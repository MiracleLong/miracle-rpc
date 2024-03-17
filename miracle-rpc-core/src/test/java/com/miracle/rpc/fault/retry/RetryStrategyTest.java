package com.miracle.rpc.fault.retry;

import com.miracle.rpc.model.RpcResponse;
import org.junit.Test;

/**
 * @author dargon
 * @create 2024-03-17
 */
public class RetryStrategyTest  {

    RetryStrategy retryStrategy = new NoRetryStrategy();

    @Test
    public void doRetry() {
        try {
            RpcResponse rpcResponse = retryStrategy.doRetry(() -> {
                System.out.println("测试重试");
                throw new RuntimeException("模拟重试失败");
            });
            System.out.println(rpcResponse);
        } catch (Exception e) {
            System.out.println("重试多次失败");
            e.printStackTrace();
        }
    }
}
