package wwtao.demo.demo_activityrouter.utils;

import com.alibaba.android.arouter.facade.annotation.Route;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by wangweitao04 on 17/2/27.
 */
@Route(path = "/mall/utils/toast/normal", name = "自定义样式Toast")
public class NormalToast implements CustomToast {
    private Context context = null;

    @Override
    public void showDefaultStyleToast(String content) {
        if (context != null) {
            Toast.makeText(context, content, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}
