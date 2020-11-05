package com.maizi.example.icon;

import com.joanzapata.iconify.Icon;

/**
 * author: Maizi
 * date: 2020/11/5 10:47
 * description: 自定义字体
 */
public enum  EcIcons implements Icon {
    icon_scan('\ue602'),
    icon_ali_pay('\ue606');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
