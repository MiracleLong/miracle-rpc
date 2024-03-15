package com.miracle.rpc.loadbalancer;

import com.miracle.rpc.model.ServiceMetaInfo;

import java.util.List;
import java.util.Map;

/**
 * @author dargon
 * @create 2024-03-14
 * @description 负载均衡（消费端）
 */
public interface LoadBalancer {

    /**
     * 选择服务调用
     *
     * @param requestParams       请求参数
     * @param serviceMetaInfoList 可用服务列表
     * @return
     */
    ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList);
}
