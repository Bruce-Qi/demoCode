package wwtao.demo.demo_activityrouter.activities;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import wwtao.demo.demo_activityrouter.R;

/**
 * Created by wangweitao04 on 17/2/8.
 */
@Route(path = "/mall/order/list")
public class OrderList extends AppCompatActivity {

    @BindView(R.id.recyclerViewOrders)
    RecyclerView recyclerViewOrderList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_order_list);
        ButterKnife.bind(this);

        recyclerViewOrderList.setLayoutManager(new LinearLayoutManager(this));
        OrderListAdapter orderListAdapter = new OrderListAdapter();
        recyclerViewOrderList.setAdapter(orderListAdapter);
    }

    public static class OrderListAdapter extends RecyclerView.Adapter<OrderItemViewHolder> {

        @Override
        public OrderItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new OrderItemViewHolder(parent);
        }

        @Override
        public void onBindViewHolder(OrderItemViewHolder holder, int position) {
            holder.bind();
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }

    public static class OrderItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvAdapterOrderItem)
        TextView tvOrderItem;

        public OrderItemViewHolder(ViewGroup itemView) {
            super(LayoutInflater.from(itemView.getContext()).inflate(R.layout.adapter_order_item, itemView, false));
            ButterKnife.bind(this, this.itemView);
        }

        public void bind() {
            long id = 1000 + getAdapterPosition();
            tvOrderItem.setText(String.format("订单号为:%d", id));
            tvOrderItem.setOnClickListener(v -> {
                ARouter.getInstance().build("/mall/order/orderDetail")
                        .withLong("detailId", id)
                        .navigation();
            });
        }
    }
}
