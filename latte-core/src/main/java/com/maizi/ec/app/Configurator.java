package com.maizi.ec.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;

/**
 * author: Maizi
 * date: 2020/11/5 10:02
 * description:
 */
public class Configurator {

    private static final HashMap<Object, Object> LATTE_CONFIGS = new HashMap<>(); //配置封装 ，HashMap<String, Object>修改为HashMap<Object, Object>
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>(); //字体封装
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>(); //拦截器封装

    private Configurator() {
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), false);
    }

    // 单例
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    // 配置设置
    public final void configure() {
        initIcons();
        LATTE_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), true);
    }

    // 获取存储状态的hasmap
    final HashMap<Object, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    // 网络接口
    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigKeys.API_HOST.name(), host);
        return this;
    }

    //字体初始化
    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    // 字体 图标接口
    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    // 拦截器，模拟请求
    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        LATTE_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }
















    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("configuration is not ready, call configure");
        }
    }

    //region 修改
    //    final <T> T getConfiguration(Enum<ConfigKeys> key) {
    //        checkConfiguration();
    //        return (T) LATTE_CONFIGS.get(key.name());
    //    }
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = LATTE_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) LATTE_CONFIGS.get(key);
    }
    //endregion
}
