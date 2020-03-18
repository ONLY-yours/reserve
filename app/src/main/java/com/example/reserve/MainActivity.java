package com.example.reserve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.reserve.activity.FacekeyActivity;
import com.example.reserve.activity.PositionActivity;
import com.example.reserve.activity.ReserveActivity;
import com.example.reserve.activity.VipActivity;
import com.example.reserve.base.BaseActivity;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.OnKeyboardListener;

import org.w3c.dom.Text;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private View viewVip;
    private View viewFaceKey;

    private TextView tvService;
    private TextView tvReserve;

    private LinearLayout llPosition;
    private LinearLayout llPhone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    void initview(){
        viewVip=findViewById(R.id.view_vip);
        viewFaceKey=findViewById(R.id.view_facekey);

        tvService=findViewById(R.id.tv_service);
        tvReserve=findViewById(R.id.tv_reserve);

        llPosition=findViewById(R.id.ll_place);
        llPhone=findViewById(R.id.ll_phone);

        viewVip.setOnClickListener(this);
        viewFaceKey.setOnClickListener(this);

        tvReserve.setOnClickListener(this);
        tvService.setOnClickListener(this);

        llPhone.setOnClickListener(this);
        llPosition.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.view_vip:
                startActivity(VipActivity.class);
                break;
            case R.id.view_facekey:
                startActivity(FacekeyActivity.class);
                break;
            case R.id.tv_reserve:
                startActivity(ReserveActivity.class);
                break;
            case R.id.ll_place:
                startActivity(PositionActivity.class);
                break;
                default:
                    break;
        }
    }
}
