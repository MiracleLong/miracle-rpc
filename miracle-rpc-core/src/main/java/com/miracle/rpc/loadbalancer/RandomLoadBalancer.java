package com.miracle.rpc.loadbalancer;

import com.miracle.rpc.model.ServiceMetaInfo;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author dargon
 * @create 2024-03-15
 * @description 随机负载均衡
 */
public class RandomLoadBalancer implements LoadBalancer{

    private final Random random = new Random();

    @Override
    public ServiceMetaInfo select(Map<String, Object> requestParams, List<ServiceMetaInfo> serviceMetaInfoList) {
        int size = serviceMetaInfoList.size();
        if (size == 0) {
            return null;
        }
        // 只有 1 个服务，不用随机
        if (size == 1) {
            return serviceMetaInfoList.get(0);
        }
        return serviceMetaInfoList.get(random.nextInt(size));
    }
}
