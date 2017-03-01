package wwtao.demo.demo_activityrouter.utils;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by wangweitao04 on 17/3/1.
 */

public class TestInject {
    @Autowired
    public CustomToast customToast;

    public TestInject() {
        ARouter.getInstance().inject(this);
    }

    public static TestInject getInstance() {
        return new TestInject();
    }
}
