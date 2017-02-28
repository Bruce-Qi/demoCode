package wwtao.demo.demo_activityrouter;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jakewharton.rxbinding.widget.RxTextView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;
import wwtao.demo.demo_activityrouter.activities.GoodsDetail;
import wwtao.demo.demo_activityrouter.activities.Orders;
import wwtao.demo.demo_activityrouter.utils.CustomToast;


public class MainActivity extends AppCompatActivity {
    @Autowired(name = "/mall/utils/toast/normal")
    CustomToast customToast;

    @BindView(R.id.mainActivityEt)
    EditText etTargetAddress;
    @BindView(R.id.mainActivityEtRequestCode)
    EditText etRequestCode;

    @BindView(R.id.btnMainActivityGotoCustomActivity)
    Button btnGotoCustomActivity;
    @BindView(R.id.btnMainActivityGotoCustomActivityForResult)
    Button btnGotoCustomActivityForResult;
    @BindView(R.id.btnMainActivityGotoBaiDu)
    Button btnGotoBaiDu;
    @BindView(R.id.btnMainActivityGotoHome)
    Button btnGotoHome;
    @BindView(R.id.btnMainActivityGotoGoodsDetail)
    Button btnGotoGoodsDetail;
    @BindView(R.id.btnMainActivityGotoLogin)
    Button btnGotoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        RxTextView.textChanges(etTargetAddress).subscribe(new Action1<CharSequence>() {
            @Override
            public void call(CharSequence charSequence) {
                btnGotoCustomActivity.setText(String.format("start Activity: %s", etTargetAddress.getText()
                        .toString()));
                btnGotoCustomActivityForResult.setText(String.format("start Activity for result: %s"
                        , etTargetAddress.getText().toString()));

            }
        });
        btnGotoCustomActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build(etTargetAddress.getText().toString()).navigation();
            }
        });

        btnGotoCustomActivityForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(etTargetAddress.getText().toString())
                        .navigation(MainActivity.this, Integer.valueOf(etRequestCode.getText().toString()),
                                mRouteCallback);
            }
        });

        btnGotoBaiDu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("http://www.baidu.com").navigation();
            }
        });

        btnGotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/mall/home").withString("modelName", "goodsList").navigation();
            }
        });

        btnGotoGoodsDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/mall/goodsDetail")
                        .navigation(MainActivity.this, GoodsDetail.OPEN_SOURCE_MAIN, mRouteCallback);
            }
        });

        btnGotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/mall/login")
                        .withString("userName", "guest")
                        .navigation();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "activity set result canceled", Toast.LENGTH_LONG).show();
        } else if (resultCode == RESULT_OK) {
            Toast.makeText(this, "activity set result OK with requestCode:" + requestCode, Toast.LENGTH_LONG).show();
        }
    }

    NavigationCallback mRouteCallback = new NavigationCallback() {
        @Override
        public void onFound(Postcard postcard) {
            customToast.showToast(getApplicationContext(), "MainActivity启动其他activity成功");
        }

        @Override
        public void onLost(Postcard postcard) {
            customToast.showToast(getApplicationContext(), String.format("通过地址(%s)启动activity失败"
                    , postcard.getPath()));
        }
    };
}
