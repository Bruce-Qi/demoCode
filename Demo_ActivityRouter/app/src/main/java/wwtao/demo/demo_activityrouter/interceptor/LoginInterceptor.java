package wwtao.demo.demo_activityrouter.interceptor;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;

import android.content.Context;

import wwtao.demo.demo_activityrouter.Config;
import wwtao.demo.demo_activityrouter.activities.Home;

import static wwtao.demo.demo_activityrouter.R.string.routerPathGoodsDetail;
import static wwtao.demo.demo_activityrouter.R.string.routerPathHome;
import static wwtao.demo.demo_activityrouter.R.string.routerPathOrderDetail;
import static wwtao.demo.demo_activityrouter.R.string.routerPathOrderList;

/**
 * Created by wangweitao04 on 17/3/1.
 */
@Interceptor(priority = 1, name = "login interceptor")
public class LoginInterceptor implements IInterceptor {

    private Context context = null;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String path = postcard.getPath();

        if (context.getString(routerPathOrderList).equals(path)) {
            if (Config.isLogin) {
                callback.onContinue(postcard);
            } else {
                unLoginNotify();
            }
        } else if (context.getString(routerPathOrderDetail).equals(path)) {
            if (Config.isLogin) {
                if (postcard.getExtras().getLong("detailId") == 0) {
                    showADialog("orderId不能为空或0!", "确定");
                } else {
                    callback.onContinue(postcard);
                }
            } else {
                unLoginNotify();
            }
        } else if (context.getString(routerPathGoodsDetail).equals(path)) {
            if (Config.isLogin) {
                if (postcard.getExtras().getLong("csuId") == 0) {
                    showADialog("csuId不能为空或0", "确定");
                } else {
                    callback.onContinue(postcard);
                }
            } else {
                unLoginNotify();
            }
        } else if (context.getString(routerPathHome).equals(path)
                && postcard.getExtras().getInt("model") != Home.GOODS_LIST) {
            if (Config.isLogin) {
                callback.onContinue(postcard);
            } else {
                unLoginNotify();
            }
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        this.context = context;
        ARouter.getInstance().inject(this);
    }

    private void unLoginNotify() {
        showADialog("你需要先登录!", "确定");
    }

    private void showADialog(String message, String action) {
        ARouter.getInstance().build("/mall/ADialog").withString("message", message).withString("action", action)
                .navigation();
    }
}
