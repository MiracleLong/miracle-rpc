package com.miracle.rpc.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dargon
 * @create 2024-03-06
 */
@Slf4j
public class MockServiceProxy implements InvocationHandler{
    /**
     *
     * @return
     * @throws Throwable
     * @description 调用代理
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> methodReturnType = method.getReturnType();
        log.info("mock invoke{}", method.getName());
        return getDefaultObject(methodReturnType);
    }

    /**
     *
     * @param type
     * @return
     */
    private Object getDefaultObject(Class<?> type) {
        // 基本类型
        if (type.isPrimitive()) {
            if (type == boolean.class) {
                return false;
            } else if (type == short.class) {
                return (short) 0;
            } else if (type == int.class) {
                return 0;
            } else if (type == long.class) {
                return 0L;
            }
        }
        // 对象类型默认返回 null
        return null;
    }
}
