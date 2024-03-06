package rpc.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

/**
 * @author dargon
 * @create 2024-03-04
 * @description 配置工具类
 */
public class ConfigUtils {

    /**
     * 加载配置
     *
     * @param tClass 类
     * @param prefix 前缀
     * @return 配置
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix) {
        return loadConfig(tClass, prefix,"");
    }

    /**
     *
     * @param tClass
     * @param prefix
     * @param environment
     * @return
     * @param <T>
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix, String environment){
        StringBuilder configTileBuilder = new StringBuilder("application");
        if(StrUtil.isNotBlank(environment)){
            configTileBuilder.append("-").append(environment);
        }
        //configTileBuilder.append(".yml");
        configTileBuilder.append(".properties");
        Props props = new Props(configTileBuilder.toString());
        return props.toBean(tClass, prefix);
    }
}
