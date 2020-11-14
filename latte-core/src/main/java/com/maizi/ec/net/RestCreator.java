package com.maizi.ec.net;

import com.maizi.ec.app.ConfigKeys;
import com.maizi.ec.app.Latte;

import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * author: Maizi
 * date: 2020/11/5 17:29
 * description:
 */
public class RestCreator {

    private static final class ParamsHolder {
        public static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }


    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE = RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }

    private static final class RetrofitHolder {
        //todo BASE_URL 报空值！！！
        //todo 已经解决：get传值为：ConfigType.API_HOST.name(),而非ConfigType.API_HOST
        // private static final String BASE_URL = (String) Latte.getConfigurations().get(ConfigKeys.API_HOST.name());
        private static final String BASE_URL = (String) Latte.getConfiguration(ConfigKeys.API_HOST.name());
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OKHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static final class OKHttpHolder {

        private static final int TIME_OUT = 60;

        //region 拦截器，接收

        private static final OkHttpClient.Builder BUILDER = new OkHttpClient.Builder();
        private static final ArrayList<Interceptor> INTERCEPTORS = Latte.getConfiguration(ConfigKeys.INTERCEPTOR);

        private static OkHttpClient.Builder addInterceptor() {
            if (INTERCEPTORS != null && !INTERCEPTORS.isEmpty()) {
                for (Interceptor interceptor : INTERCEPTORS) {
                    BUILDER.addInterceptor(interceptor);
                }
            }
            return BUILDER;
        }

        //endregion

        //new OkHttpClient.Builder() 修改为 addInterceptor()
        private static final OkHttpClient OK_HTTP_CLIENT = addInterceptor()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

}
