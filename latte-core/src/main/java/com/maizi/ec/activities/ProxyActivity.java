package com.maizi.ec.activities;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.maizi.ec.R;
import com.maizi.ec.delegates.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * author: Maizi
 * date: 2020/11/5 11:55
 * description:activity架构设计
 */
public abstract class ProxyActivity extends SupportActivity {
    public abstract LatteDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        //todo ContentFragmentlayout和FragmentLayout的区别、共同之处 未解决
        final FrameLayout container = new FrameLayout(this);

        container.setId(R.id.delegate_container);
        setContentView(container);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
