package com.miracle.example.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.miracle.example.common.model.User;
import com.miracle.example.common.service.UserService;
import com.miracle.rpc.model.RpcRequest;
import com.miracle.rpc.model.RpcResponse;
import com.miracle.rpc.serializer.JdkSerializer;
import com.miracle.rpc.serializer.Serializer;

import java.io.IOException;

/**
 * @author dargon
 * @create 2024-02-25
 */
@Deprecated
public class UserServiceProxy implements UserService {


    public User getUser(User user) {
        // 1.指定序列化器
        Serializer serializer = new JdkSerializer();
        // 2.发送请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user}).build();
        try {
            byte[] bodyBytes = serializer.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8081").body(bodyBytes).execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
