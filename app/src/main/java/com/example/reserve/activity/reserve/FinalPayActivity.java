package com.example.reserve.activity.reserve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.reserve.MainActivity;
import com.example.reserve.R;
import com.example.reserve.base.BaseActivity;

//最后的支付界面

public class FinalPayActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvHomeDetial;
    private Button btnPayFinal;

    private Button btnPay;
    private TextView tvName;
    private TextView tvArea;
    private TextView tvPrice;
    private EditText tvPeopleNumber;
    private TextView tvFloor;
    private TextView tvBedSize;

    private View btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_final_pay);

        initview();
    }

    void initview(){
//        int position = Integer.parseInt(getTheKeyValues("position"));
        int position = ReserveActivity.Position;            //模拟器用下面的这个
        tvHomeDetial=findViewById(R.id.tv_homedetial);
        btnPayFinal=findViewById(R.id.btn_pay);

        tvHomeDetial.setOnClickListener(this);
        btnPayFinal.setOnClickListener(this);

        btnBack=findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        //房间种类名字
        tvName=findViewById(R.id.tv_name);
        tvName.setText(MainActivity.home.getResult().get(position).getName());

        //入住人数
        tvPeopleNumber=findViewById(R.id.et_mostPeopleNumber);
        tvPeopleNumber.setHint("每间最多可入住"+MainActivity.home.getResult().get(position).getPersonNum()+"人");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_homedetial:
                startActivity(RoomDetialActivity.class);
                break;
            case R.id.btn_pay:

                startActivity(MainActivity.class);
                break;
            case R.id.btn_back:
                onBackPressed();
                break;
        }
    }
}
