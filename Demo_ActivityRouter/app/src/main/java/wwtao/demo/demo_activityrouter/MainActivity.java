package wwtao.demo.demo_activityrouter;

import com.google.common.base.Strings;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
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
import wwtao.demo.demo_activityrouter.activities.Home;
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
    @BindView(R.id.btnMainActivityGotoOrder)
    Button btnGotoOrder;
    @BindView(R.id.etMainActivityOrderId)
    EditText etOrderId;
    @BindView(R.id.btnMainActivityGotoOrderDetail)
    Button btnGotoOrderDetail;
    @BindView(R.id.btnMainActivityGotoHomeGoodsList)
    Button btnGotoHomeGoodsList;
    @BindView(R.id.btnMainActivityGotoHomeShoppingCart)
    Button btnGotoHomeShoppingCart;
    @BindView(R.id.btnMainActivityGotoHomeUser)
    Button btnGotoHomeUser;
    @BindView(R.id.etMainActivityCsuId)
    EditText etCsuId;
    @BindView(R.id.etMainActivityGoodsName)
    EditText etGoodsName;
    @BindView(R.id.btnMainActivityGotoGoodsDetail)
    Button btnGotoGoodsDetail;
    @BindView(R.id.btnMainActivityGotoLogin)
    Button btnGotoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
//        customToast = ((CustomToast) ARouter.getInstance().build("/mall/utils/toast/normal").navigation());

        RxTextView.textChanges(etTargetAddress).subscribe(charSequence -> {
            btnGotoCustomActivity.setText(String.format("start Activity: %s", etTargetAddress.getText()
                    .toString()));
            btnGotoCustomActivityForResult.setText(String.format("start Activity for result: %s"
                    , etTargetAddress.getText().toString()));

        });
        btnGotoCustomActivity.setOnClickListener(v -> {
            try {
                ARouter.getInstance().build(etTargetAddress.getText().toString())
                        .navigation(MainActivity.this, mRouteCallback);
            } catch (Exception e) {
                e.printStackTrace();
                customToast.showDefaultStyleToast(String.format("启动activity失败:%s", e.getMessage()));
            }
        });

        btnGotoCustomActivityForResult.setOnClickListener(v -> {
            try {
                ARouter.getInstance().build(etTargetAddress.getText().toString())
                        .navigation(MainActivity.this, Integer.valueOf(etRequestCode.getText().toString())
                                , mRouteCallback);
            } catch (Exception e) {
                customToast.showDefaultStyleToast(String.format("启动activity失败:%s", e.getMessage()));
            }
        });

        btnGotoOrder.setOnClickListener(v -> ARouter.getInstance().build(getString(R.string.routerPathOrderList))
                .navigation());

        btnGotoOrderDetail.setOnClickListener(v -> {
            Postcard postcard = ARouter.getInstance().build(getString(R.string.routerPathOrderDetail));
            if (!Strings.isNullOrEmpty(etOrderId.getText().toString())) {
                postcard.withLong("detailId", Long.valueOf(etOrderId.getText().toString()));
            }
            postcard.navigation();
        });

        btnGotoHomeGoodsList.setOnClickListener(v -> ARouter.getInstance().build(getString(R.string.routerPathHome))
                .withInt("model", Home.GOODS_LIST).navigation());
        btnGotoHomeShoppingCart.setOnClickListener(v -> ARouter.getInstance().build(getString(R.string.routerPathHome))
                .withInt("model", Home.SHOPPING_CART).navigation());
        btnGotoHomeUser.setOnClickListener(v -> ARouter.getInstance().build(getString(R.string.routerPathHome))
                .withInt("model", Home.USERS).navigation());

        btnGotoGoodsDetail.setOnClickListener(v -> {
            Postcard postcard = ARouter.getInstance().build(getString(R.string.routerPathGoodsDetail))
                    .withString("goodsName", etGoodsName.getText().toString());
            if (!Strings.isNullOrEmpty(etCsuId.getText().toString())) {
                postcard.withLong("csuId", Long.valueOf(etCsuId.getText().toString()));
            }
            postcard.navigation();
        });

        btnGotoLogin.setOnClickListener(v -> ARouter.getInstance().build(getString(R.string.routerPathLogin))
                .withString("userName", "guest").navigation());

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
            customToast.showDefaultStyleToast("MainActivity启动其他activity成功");
        }

        @Override
        public void onLost(Postcard postcard) {
            customToast.showDefaultStyleToast(String.format("通过地址或uri启动activity失败,请检查地址是否正确!"));
        }
    };
}
