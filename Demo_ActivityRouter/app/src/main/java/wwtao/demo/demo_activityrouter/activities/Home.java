package wwtao.demo.demo_activityrouter.activities;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jakewharton.rxbinding.view.RxView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import wwtao.demo.demo_activityrouter.R;

/**
 * Created by wangweitao04 on 17/2/8.
 */
@Route(path = "/mall/home")
public class Home extends AppCompatActivity {
    public static final int GOODS_LIST = 101;
    public static final int SHOPPING_CART = 102;
    public static final int USERS = 103;

    @Autowired
    Integer model = GOODS_LIST;

    @BindView(R.id.tvHomeModelName)
    TextView tvModelName;
    @BindView(R.id.btnHomeGoodsList)
    Button btnHomeGoodsList;
    @BindView(R.id.btnHomeShoppingCart)
    Button btnHomeShoppingCart;
    @BindView(R.id.btnHomeUser)
    Button btnHomeUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        initUI();
        showContent();
    }

    private void initUI() {
        btnHomeGoodsList.setOnClickListener(v -> {
            model = GOODS_LIST;
            showContent();
        });
        btnHomeShoppingCart.setOnClickListener(v -> {
            model = SHOPPING_CART;
            showContent();
        });
        btnHomeUser.setOnClickListener(v -> {
            model = USERS;
            showContent();
        });
    }

    private void showContent() {
        switch (model) {
            case SHOPPING_CART:
                tvModelName.setText("购物车");
                break;
            case USERS:
                tvModelName.setText("用户中心");
                break;
            case GOODS_LIST:
            default:
                tvModelName.setText("商品列表");
        }
    }
}
