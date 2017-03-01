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
@Route(path = "/mall/goodsDetail")
public class GoodsDetail extends AppCompatActivity {
    public static final int OPEN_SOURCE_MAIN=1;
    public static final int OPEN_SOURCE_GOODS_LIST=2;
    public static final int OPEN_SOURCE_SHOPPING_CART=3;

    @Autowired(required = true)
    long csuId;

    @BindView(R.id.tvGoodsDetailCsuId)
    TextView tvCusId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        tvCusId.setText(String.valueOf(csuId));
    }
}
