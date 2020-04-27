package com.example.reserve.activity.UserCenter.OrderManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.reserve.R;
import com.example.reserve.activity.UserCenter.VipActivity;
import com.example.reserve.activity.reserve.FinalPayActivity;
import com.example.reserve.adapter.OrderListAdapter;
import com.example.reserve.base.BaseActivity;


//个人中心-订单管理界面

public class OrderManageActivity extends BaseActivity {

    private RecyclerView rvOrderList;

    public static int Position;     //选定的订单位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_order_manage);

        initview();
    }
    //用于更新数据后刷新界面使用
    @Override
    protected void onRestart() {
        initview();
        super.onRestart();
    }

    void initview(){
        rvOrderList=findViewById(R.id.rv_orderlist);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        rvOrderList.setLayoutManager(manager);

        OrderListAdapter adapter = new OrderListAdapter(VipActivity.orderlist);
        rvOrderList.setAdapter(adapter);

        adapter.setmOnItemClickListener(mclick);
    }

    public OrderListAdapter.OnItemClickListener mclick=new OrderListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            switch (view.getId()){
                case R.id.con_view:
                    Position=position;
                    startActivity(OrderDetialActivity.class);
                    break;
            }
        }
    };

}
