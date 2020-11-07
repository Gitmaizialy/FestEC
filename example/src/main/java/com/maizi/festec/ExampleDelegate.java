package com.maizi.festec;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.maizi.example.delegates.LatteDelegate;
import com.maizi.example.net.RestClient;
import com.maizi.example.net.callback.IError;
import com.maizi.example.net.callback.IFailure;
import com.maizi.example.net.callback.ISuccess;

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
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("https://github.com/JakeWharton/butterknife/")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String reponse) {
                        Toast.makeText(getContext(), reponse, Toast.LENGTH_LONG).show();
                    }
                })
                .build()
                .get();


    }
}
