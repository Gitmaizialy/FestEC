package com.maizi.festec;

import com.maizi.example.activities.ProxyActivity;
import com.maizi.example.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }

}