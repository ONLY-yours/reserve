package com.example.reserve.activity.UserCenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.reserve.R;
import com.example.reserve.base.BaseActivity;

public class VipActivity extends BaseActivity implements View.OnClickListener {

    //原定为VIP服务，现在存放为个人中心

    private TextView tvOrderManage;
    private TextView tvSelfMessage;
    private TextView tvPeopleAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_vip);

        initview();
    }

    void initview(){
        tvOrderManage=findViewById(R.id.tv_order_manager);
        tvSelfMessage=findViewById(R.id.tv_self_message);
        tvPeopleAdd=findViewById(R.id.tv_people_add);

        tvPeopleAdd.setOnClickListener(this);
        tvOrderManage.setOnClickListener(this);
        tvSelfMessage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_order_manager:

            case R.id.tv_self_message:

            case R.id.tv_people_add:
                startActivity(CurstomListActivity.class);
                break;

        }
    }
}
