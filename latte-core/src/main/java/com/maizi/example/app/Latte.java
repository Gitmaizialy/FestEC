package com.maizi.example.app;

import android.content.Context;

import java.util.HashMap;

/**
 * author: Maizi
 * date: 2020/11/5 10:00
 * description: 全局类
 */
public final class Latte {
    // 配置初始化
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    // 获取关于配置的hasmap
    private static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    // 初始化时 获取全局context
    public static Context getApplication() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
