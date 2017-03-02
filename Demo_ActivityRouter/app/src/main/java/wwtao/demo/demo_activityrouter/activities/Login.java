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
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import wwtao.demo.demo_activityrouter.Config;
import wwtao.demo.demo_activityrouter.R;
import wwtao.demo.demo_activityrouter.utils.CustomToast;

/**
 * Created by wangweitao04 on 17/2/8.
 */
@Route(path = "/mall/login")
public class Login extends AppCompatActivity {
    //    @Autowired
//    Boolean isLogin = false;
//    @Autowired
//    String userName;
    @Autowired(name = "/mall/utils/toast/normal")
    CustomToast customToast;

    @BindView(R.id.layoutLoginState)
    View layoutLoginState;
    @BindView(R.id.tvLoginState)
    TextView tvLoginState;
    @BindView(R.id.btnLoginLogout)
    Button btnLoginLogout;
    @BindView(R.id.btnLoginReturn)
    Button btnLoginReturn;
    @BindView(R.id.layoutLoginLogin)
    View layoutLogin;
    @BindView(R.id.etLoginUserName)
    EditText etUserName;
    @BindView(R.id.etLoginUserPassword)
    EditText etUserPassword;
    @BindView(R.id.btnLoginStartLogin)
    Button btnStartLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        checkIsLogin();
        btnStartLogin.setOnClickListener(v -> {
            if (!Strings.isNullOrEmpty(etUserName.getText().toString())
                    && !Strings.isNullOrEmpty(etUserPassword.getText().toString())) {
                Config.userName = etUserName.getText().toString();
                Config.isLogin = true;
                checkIsLogin();
            } else {
                customToast.showDefaultStyleToast("用户名或密码为空!");
            }
        });
    }

    private void checkIsLogin() {
        if (Config.isLogin) {
            showLoginState();
        } else {
            showLogin();
        }
    }

    private void showLoginState() {
        layoutLoginState.setVisibility(View.VISIBLE);
        layoutLogin.setVisibility(View.GONE);

        tvLoginState.setText(String.format("你已经登录,用户名为:%s", Config.userName));
        btnLoginLogout.setOnClickListener(v -> {
            Config.isLogin = false;
            checkIsLogin();
        });
        btnLoginReturn.setOnClickListener(v -> finish());
    }

    private void showLogin() {
        layoutLogin.setVisibility(View.VISIBLE);
        layoutLoginState.setVisibility(View.GONE);

        if (!Strings.isNullOrEmpty(Config.userName)) {
            etUserName.setText(Config.userName);
        } else {
            etUserName.setHint("请输入用户名");
        }
    }
}
