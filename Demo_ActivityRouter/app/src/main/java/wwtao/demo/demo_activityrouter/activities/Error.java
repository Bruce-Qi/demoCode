package wwtao.demo.demo_activityrouter.activities;


import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import wwtao.demo.demo_activityrouter.R;

/**
 * Created by wangweitao04 on 17/2/8.
 */
@Route(path = "/mall/error")
public class Error extends AppCompatActivity {
    @Autowired
    String url;

    @Autowired
    Long time;

    @BindView(R.id.tvSplashUri)
    TextView tvName;

    @BindView(R.id.tvSplashContinueTime)
    TextView tvContinueTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        if (url != null) {
            tvName.setText(url);
        }
        if (time != null) {
            tvContinueTime.setText(String.valueOf(time));
        }
    }

}
