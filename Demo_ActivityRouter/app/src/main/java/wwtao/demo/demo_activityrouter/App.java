package wwtao.demo.demo_activityrouter;

import com.alibaba.android.arouter.launcher.ARouter;

import android.app.Application;

/**
 * Created by wangweitao04 on 17/2/14.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化路由
        ARouter.init(this);
    }
}
