package wwtao.demo.demo_activityrouter.activities;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import wwtao.demo.demo_activityrouter.R;

/**
 * Created by wangweitao04 on 17/2/8.
 */
@Route(path = "/mall/goodsDetail")
public class GoodsDetail extends AppCompatActivity {
    @Autowired(name = "csuId")
    Long csuId;

    @Autowired(name = "goodsName")
    String goodsName;

    @BindView(R.id.tvGoodsDetailCsuId)
    TextView tvCusId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        tvCusId.setText(String.format("商品名称:%s\nID:%d", goodsName, csuId));
    }
}
