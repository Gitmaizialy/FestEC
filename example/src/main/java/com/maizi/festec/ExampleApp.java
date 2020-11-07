package com.maizi.festec;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.maizi.example.app.ConfigType;
import com.maizi.example.app.Latte;
import com.maizi.example.icon.FontEcModule;

/**
 * author: Maizi
 * date: 2020/11/5 10:01
 * description:
 */
public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化设置
        Latte.init(this)
                .withIcon(new FontAwesomeModule()) // 图标
                .withIcon(new FontEcModule()) // 字体
                .withApiHost("http://127.0.0.1/") // 域名
                .configure();
    }
}
