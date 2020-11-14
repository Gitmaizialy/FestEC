package com.maizi.ec.util.timer;

import java.util.TimerTask;

/**
 * author: Maizi
 * date: 2020/11/13 10:49
 * description: 时间计时器
 */
public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener timerListener) {
        this.mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}
