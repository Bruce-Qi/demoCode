package wwtao.demo.demo_activityrouter;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by wangweitao04 on 17/2/27.
 */
public class SchemeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Uri uri = getIntent().getData();
        ARouter.getInstance().build(uri).navigation(this, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {
                Toast.makeText(getApplicationContext(), String.format("由%s启动Activity成功", uri.toString())
                        , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLost(Postcard postcard) {
                Toast.makeText(getApplicationContext(), String.format("找不到%s对应的Activity", uri.toString())
                        , Toast.LENGTH_LONG).show();
            }
        });
    }
}
