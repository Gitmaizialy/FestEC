package com.maizi.ec.launcher;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.maizi.ec.R2;
import com.maizi.ec.R;
import com.maizi.ec.delegates.LatteDelegate;
import com.maizi.ec.util.timer.BaseTimerTask;
import com.maizi.ec.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author: Maizi
 * date: 2020/11/13 10:44
 * description:
 */
public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    private Timer mTimer = null;
    private int mCount = 5;

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    @OnClick
    void onClickTimerView() {

    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                        }
                    }
                }
            }
        });
    }
}
