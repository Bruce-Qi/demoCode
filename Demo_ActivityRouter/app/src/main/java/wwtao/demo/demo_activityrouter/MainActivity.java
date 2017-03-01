package wwtao.demo.demo_activityrouter;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jakewharton.rxbinding.widget.RxTextView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import wwtao.demo.demo_activityrouter.activities.GoodsDetail;
import wwtao.demo.demo_activityrouter.utils.CustomToast;


public class MainActivity extends AppCompatActivity {
    //    @Autowired
    CustomToast customToast;

    @BindView(R.id.mainActivityEt)
    EditText etTargetAddress;
    @BindView(R.id.mainActivityEtRequestCode)
    EditText etRequestCode;

    @BindView(R.id.btnMainActivityGotoCustomActivity)
    Button btnGotoCustomActivity;
    @BindView(R.id.btnMainActivityGotoCustomActivityForResult)
    Button btnGotoCustomActivityForResult;
    @BindView(R.id.btnMainActivityGotoOrder)
    Button btnGotoOrder;
    @BindView(R.id.btnMainActivityGotoOrderDetail)
    Button btnGotoOrderDetail;
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
        customToast = ((CustomToast) ARouter.getInstance().build("/mall/utils/toast/normal").navigation());

        RxTextView.textChanges(etTargetAddress).subscribe(charSequence -> {
            btnGotoCustomActivity.setText(String.format("start Activity: %s", etTargetAddress.getText()
                    .toString()));
            btnGotoCustomActivityForResult.setText(String.format("start Activity for result: %s"
                    , etTargetAddress.getText().toString()));

        });
        btnGotoCustomActivity.setOnClickListener(v -> {
            try {
                ARouter.getInstance().build(etTargetAddress.getText().toString()).navigation();
            } catch (Exception e) {
                customToast.showToast(String.format("启动activity失败:%s", e.getMessage()));
            }
        });

        btnGotoCustomActivityForResult.setOnClickListener(v -> {
            try {
                ARouter.getInstance().build(etTargetAddress.getText().toString())
                        .navigation(MainActivity.this, Integer.valueOf(etRequestCode.getText().toString()));
            } catch (Exception e) {
                customToast.showToast(String.format("启动activity失败:%s", e.getMessage()));
            }
        });

        btnGotoOrder.setOnClickListener(v -> ARouter.getInstance().build("/mall/order").navigation(MainActivity.this
                , mRouteCallback));

        btnGotoOrderDetail.setOnClickListener(v -> ARouter.getInstance().build("/mall/order/orderDetail")
                .navigation(MainActivity.this, mRouteCallback));

        btnGotoHome.setOnClickListener(v -> ARouter.getInstance().build("/mall/home").withString("modelName",
                "goodsList").navigation());

        btnGotoGoodsDetail.setOnClickListener(v -> ARouter.getInstance().build("/mall/goodsDetail")
                .withString("csuId", "10001")
                .navigation(MainActivity.this, GoodsDetail.OPEN_SOURCE_MAIN/*, mRouteCallback*/));

        btnGotoLogin.setOnClickListener(v -> ARouter.getInstance().build("/mall/login")
                .withString("userName", "guest")
                .navigation());

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
//            TestInject.getInstance().customToast.showToast("MainActivity启动其他activity成功");

//            customToast.showToast("MainActivity启动其他activity成功");


            customToast.showToast("MainActivity启动其他activity成功");

//            Toast.makeText(MainActivity.this, "MainActivity启动其他activity成功", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onLost(Postcard postcard) {
            ARouter.getInstance().navigation(CustomToast.class)
                    .showToast(String.format("通过地址(%s)或uri(%s)启动activity失败"
                            , postcard.getPath(), postcard.getUri().toString()));
//            Toast.makeText(MainActivity.this, String.format("通过地址(%s)或uri(%s)启动activity失败"
//                    , postcard.getPath(), postcard.getUri().toString()), Toast.LENGTH_LONG).show();
        }
    };
}
