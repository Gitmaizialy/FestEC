package com.maizi.ec.ui.launcher;

import android.content.Context;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * author: Maizi
 * date: 2020/11/14 16:31
 * description:
 */
public class LauncherHolder implements Holder<Integer> {

    private AppCompatTextView mImageView = null;

    @Override
    public View createView(Context context) {
        mImageView = new AppCompatTextView(context);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        mImageView.setBackgroundResource(data);
    }
}
