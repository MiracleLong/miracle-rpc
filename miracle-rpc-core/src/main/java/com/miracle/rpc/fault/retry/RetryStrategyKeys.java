package com.miracle.rpc.fault.retry;

/**
 * @author dargon
 * @create 2024-03-17
 * @description 重试策略键名常量
 */
public interface RetryStrategyKeys {

    /**
     * 不重试
     */
    String NO = "no";

    /**
     * 固定时间间隔
     */
    String FIXED_INTERVAL = "fixedInterval";
}
