package wwtao.demo.demo_activityrouter.utils;

import com.alibaba.android.arouter.facade.annotation.Route;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by wangweitao04 on 17/2/27.
 */
@Route(path = "/mall/utils/toast/normal")
public class NormalToast implements CustomToast {
    @Override
    public void showToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_LONG).show();
    }
}
