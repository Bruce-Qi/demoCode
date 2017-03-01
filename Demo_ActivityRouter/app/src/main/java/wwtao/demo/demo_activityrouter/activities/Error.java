package wwtao.demo.demo_activityrouter.activities;


import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
    String errorInfo;

    @Autowired
    String action;

    @BindView(R.id.tvErrorInfo)
    TextView tvInfo;

    @BindView(R.id.btnErrorAction)
    Button btnAction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_error);
        ButterKnife.bind(this);

        if (errorInfo != null && !"".equals(errorInfo)) {
            tvInfo.setText(errorInfo);
        }

        if (action != null && !"".equals(action)) {
            btnAction.setVisibility(View.VISIBLE);
            btnAction.setText(action);
        } else {
            btnAction.setVisibility(View.GONE);
        }
    }

}
