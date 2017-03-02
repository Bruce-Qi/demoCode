package wwtao.demo.demo_activityrouter.activities;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import wwtao.demo.demo_activityrouter.R;

/**
 * Created by wangweitao04 on 17/3/2.
 */
@Route(path = "/mall/webview")
public class WebView extends AppCompatActivity {
    @Autowired
    String url;

    @BindView(R.id.wvWebView)
    android.webkit.WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);

        Log.w("webView", String.format("url:%s", url));
        webView.loadUrl(url);
    }
}
