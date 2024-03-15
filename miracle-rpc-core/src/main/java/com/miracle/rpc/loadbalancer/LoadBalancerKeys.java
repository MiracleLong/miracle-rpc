package com.miracle.rpc.loadbalancer;

/**
 * @author dargon
 * @create 2024-03-15
 * @description 负载均衡器键名常量
 */
public interface LoadBalancerKeys {
    /**
     * 轮询
     */
    String ROUND_ROBIN = "roundRobin";

    String RANDOM = "random";

    String CONSISTENT_HASH = "consistentHash";
}
