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
@Route(path = "/mall/order")
public class Orders extends AppCompatActivity {
    @Autowired
    String startTime;
    @Autowired
    String endTime;

    @BindView(R.id.tvOrdersStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvOrdersEndTime)
    TextView tvEndTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        ButterKnife.bind(this);
        tvStartTime.setText(startTime);
        tvEndTime.setText(endTime);
    }
}
