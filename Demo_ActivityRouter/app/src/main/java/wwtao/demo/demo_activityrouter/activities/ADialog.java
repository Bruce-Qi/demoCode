package wwtao.demo.demo_activityrouter.activities;


import com.google.common.base.Strings;

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
@Route(path = "/mall/ADialog")
public class ADialog extends AppCompatActivity {
    @Autowired
    String message;

    @Autowired
    String action;

    @BindView(R.id.tvADialogInfo)
    TextView tvInfo;

    @BindView(R.id.btnADialogConfirm)
    Button btnAction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_error);
        ButterKnife.bind(this);

        if (!Strings.isNullOrEmpty(message)) {
            tvInfo.setText(message);
        }

        if (action != null && !"".equals(action)) {
            btnAction.setVisibility(View.VISIBLE);
            btnAction.setText(action);
        } else {
            btnAction.setVisibility(View.GONE);
        }
        btnAction.setOnClickListener(v -> finish());
    }

}
