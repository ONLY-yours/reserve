package com.example.reserve.activity.reserve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.reserve.R;
import com.example.reserve.base.BaseActivity;
import com.example.reserve.MainActivity;


//房间详细细节界面

public class RoomDetialActivity extends BaseActivity  {

    private Button btnPay;
    private TextView tvName;
    private TextView tvArea;
    private TextView tvPrice;
    private TextView tvPeopleNumber;
    private TextView tvFloor;
    private TextView tvBedSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_room_detial);

        initView();

        btnPay=findViewById(R.id.btn_pay);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(FinalPayActivity.class);
            }
        });
    }

    void initView(){
//        int position = Integer.parseInt(getTheKeyValues("position"));
        int position = ReserveActivity.Position;
        //客房区域
        tvArea=findViewById(R.id.tv_area);
        tvArea.setText(MainActivity.home.getResult().get(position).getArea());
        //房间种类名字
        tvName=findViewById(R.id.tv_name);
        tvName.setText(MainActivity.home.getResult().get(position).getName());
        //价格
        tvPrice=findViewById(R.id.tv_price);
        tvPrice.setText("￥"+MainActivity.home.getResult().get(position).getPrice());
        //入住人数
        tvPeopleNumber=findViewById(R.id.tv_people_number);
        tvPeopleNumber.setText(MainActivity.home.getResult().get(position).getPersonNum()+"人间");
        //楼层
        tvFloor=findViewById(R.id.tv_floor);
        tvFloor.setText(MainActivity.home.getResult().get(position).getRoomNumber()+"楼");
        //床尺寸
        tvBedSize=findViewById(R.id.tv_bedsize);
        tvBedSize.setText(MainActivity.home.getResult().get(position).getBedInfo());



    }

}
