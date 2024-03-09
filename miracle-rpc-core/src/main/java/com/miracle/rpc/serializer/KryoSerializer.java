package com.miracle.rpc.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author dargon
 * @create 2024-03-08
 * @description kryo 序列化
 *
 * Kryo 本身是线程不安全的，所以需要使用 ThreadLocal 保证每个线程有一个单独的 Kryo 对象实例
 */
public class KryoSerializer implements Serializer{

    /**
     * kryo 线程不安全，使用ThreadLocal保证每个线程只有一个Kryo
     */
    private static final ThreadLocal<Kryo> KRYO_THREAD_LOCAL = ThreadLocal.withInitial(() -> {
        Kryo kryo = new Kryo();
        // 设置动态序列化和反序列化，不能提前注册所有类（有安全风险）
        kryo.setRegistrationRequired(false);
        return kryo;
    });

    /**
     * 序列化
     *
     * @param object
     * @param <T>
     * @return
     * @throws IOException
     */
    @Override
    public <T> byte[] serialize(T object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Output output = new Output(bos);
        try {
            KRYO_THREAD_LOCAL.get().writeObject(output, object);
            output.flush();
            return bos.toByteArray();
        } finally {
            output.close();
        }
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @param  tClass
     * @param <T>
     * @return
     * @throws IOException
     */
    @Override
    public <T> T deserialize(byte[] bytes, Class<T> tClass) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Input input = new Input(bis);
        try {
            T result = KRYO_THREAD_LOCAL.get().readObject(input, tClass);
            return result;
        } finally {
            input.close();
        }
    }
}
