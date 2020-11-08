package com.maizi.example.app;

import android.content.Context;

/**
 * author: Maizi
 * date: 2020/11/5 10:00
 * description: 全局类
 */
public final class Latte {
    // 配置初始化
    public static Configurator init(Context context) {

        //region 修改

        // getConfigurations().put(ConfigKeys.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        Configurator.getInstance()
                .getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());

        //endregion

        return Configurator.getInstance();
    }

    //region修改

    //    // 获取关于配置的hasmap
    //    public static HashMap<Object, Object> getConfigurations() {
    //        return Configurator.getInstance().getLatteConfigs();
    //    }
    //
    //    // 初始化时 获取全局context
    //    public static Context getApplicationContext() {
    //        return (Context) getConfigurations().get(ConfigKeys.APPLICATION_CONTEXT.name());
    //    }
    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

    //endregion

}
