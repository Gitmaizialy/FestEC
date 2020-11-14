package com.maizi.ec.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.maizi.ec.app.Latte;

/**
 * author: Maizi
 * date: 2020/11/7 17:57
 * description:
 */
public class DimenUtil {

    /**
     * @return 屏幕宽
     */
    public static int getScareenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * @return 屏幕高
     */
    public static int getScareenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }

}
