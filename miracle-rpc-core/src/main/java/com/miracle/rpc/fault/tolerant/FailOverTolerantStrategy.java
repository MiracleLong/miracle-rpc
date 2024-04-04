package com.miracle.rpc.fault.tolerant;

import com.miracle.rpc.model.RpcResponse;

import java.util.Map;

/**
 * @author dargon
 * @create 2024-03-17
 * @description 转移到其他服务节点 - 容错策略（故障转移策略）
 */
public class FailOverTolerantStrategy implements TolerantStrategy{
    /**
     * 容错
     *
     * @param context 上下文，用于传递数据
     * @param e       异常
     * @return
     */
    @Override
    public RpcResponse doTolerant(Map<String, Object> context, Exception e) {
        // todo ...获取其他服务节点并调用
        return null;
    }
}
