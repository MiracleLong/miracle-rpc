package com.miracle.rpc.serializer;

import com.miracle.rpc.spi.SpiLoader;

/**
 * @author dargon
 * @create 2024-03-08
 * @description 序列化工厂
 */
public class SerializerFactory {

    static {
        SpiLoader.load(Serializer.class);
    }

    /**
     * 默认序列化器
     */
    private static  Serializer DEFAULT_SERIALIZER;

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Serializer getInstance(String key) {
        if (DEFAULT_SERIALIZER == null) {
            synchronized (SerializerFactory.class) {
                if (DEFAULT_SERIALIZER == null) {
                    SpiLoader.load(Serializer.class);
                    DEFAULT_SERIALIZER = new JdkSerializer();
                }
            }
        }
        return SpiLoader.getInstance(Serializer.class, key);
    }
}

