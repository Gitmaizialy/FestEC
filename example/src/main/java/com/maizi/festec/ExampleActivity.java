package com.maizi.festec;

import com.maizi.ec.activities.ProxyActivity;
import com.maizi.ec.delegates.LatteDelegate;
import com.maizi.ec.launcher.LauncherDelegate;
import com.maizi.ec.launcher.LauncherScrollDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
//        return new ExampleDelegate();
//        return new LauncherDelegate();
        return new LauncherScrollDelegate();
    }

}