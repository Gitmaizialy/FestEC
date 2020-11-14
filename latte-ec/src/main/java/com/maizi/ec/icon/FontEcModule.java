package com.maizi.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * author: Maizi
 * date: 2020/11/5 10:45
 * description: 自定义字体
 */
public class FontEcModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return EcIcons.values();
    }
}
