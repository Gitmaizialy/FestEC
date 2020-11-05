package com.maizi.festec;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.maizi.example.delegates.LatteDelegate;

/**
 * author: Maizi
 * date: 2020/11/5 14:34
 * description: activity架构设计
 */
public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
