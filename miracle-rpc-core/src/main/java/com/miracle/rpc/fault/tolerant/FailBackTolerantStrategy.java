package com.miracle.rpc.fault.tolerant;

import com.miracle.rpc.model.RpcResponse;

import java.util.Map;

/**
 * @author dargon
 * @create 2024-03-17
 * @description 降级到其他服务 - 容错策略（故障恢复策略）
 */
public class FailBackTolerantStrategy implements TolerantStrategy{
    /**
     * 容错
     *
     * @param context 上下文，用于传递数据
     * @param e       异常
     * @return
     */
    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        // todo 获取降级的服务并调用
        return null;
    }
}
