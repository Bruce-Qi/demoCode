package wwtao.demo.demo_activityrouter.activities;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import wwtao.demo.demo_activityrouter.R;

/**
 * Created by wangweitao04 on 17/2/8.
 */
@Route(path = "/mall/orderDetail")
public class OrderDetail extends AppCompatActivity {
    @Autowired(required = true)
    long detailId;

    @BindView(R.id.tvOrderDetailOrderId)
    TextView tvOrderId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        tvOrderId.setText(String.valueOf(detailId));
    }
}
