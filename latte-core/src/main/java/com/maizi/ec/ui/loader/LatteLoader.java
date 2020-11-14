package com.maizi.ec.ui.loader;

import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatDialog;

import com.maizi.ec.R;
import com.maizi.ec.util.dimen.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * author: Maizi
 * date: 2020/11/7 17:30
 * description:
 */
public class LatteLoader {

    //缩放比
    private static final int LOADER_SIZE_SCALE = 8;
    //偏移量
    private static final int LOADER_OFFSET_SCALE = 10;
    //存储loader 便于管理
    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();
    //默认loader的样式,即引入github--81813780 AVLoadingIndicatorView包中的loader样式
    private static final String DEFAULT_LAODER = LoaderStyle.BallClipRotatePulseIndicator.name();

    public static void showLoading(Context context, String style) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);

        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(style, context);
        dialog.setContentView(avLoadingIndicatorView);

        int deviceWith = DimenUtil.getScareenWidth();
        int deviceHeight = DimenUtil.getScareenHeight();

        final Window dialogWindow = dialog.getWindow();

        if (dialogWindow != null) {
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWith / LOADER_SIZE_SCALE;
            lp.height = deviceHeight / LOADER_SIZE_SCALE;

            lp.height = lp.height + deviceHeight / LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    //重载1
    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LAODER);
    }

    //重载2
    public static void showLoading(Context context, Enum<LoaderStyle> type) {
        showLoading(context, type.name());
    }

    //结束loader
    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                }
            }
        }
    }
}
