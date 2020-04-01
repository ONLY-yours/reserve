package com.example.reserve;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reserve.activity.FacekeyActivity;
import com.example.reserve.activity.PositionActivity;
import com.example.reserve.activity.reserve.ReserveActivity;
import com.example.reserve.activity.VipActivity;
import com.example.reserve.base.BaseActivity;
import com.example.reserve.bean.HomeListBean;
import com.example.reserve.net.AppRetrofit;
import com.example.reserve.utils.ActivityCollector;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private View viewVip;
    private View viewFaceKey;

    private TextView tvService;
    private TextView tvReserve;

    private LinearLayout llPosition;
    private LinearLayout llPhone;

    public static HomeListBean home;

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
                getHomeList();
//                startActivity(ReserveActivity.class);
                break;
            case R.id.ll_place:
                startActivity(PositionActivity.class);
                break;
                default:
                    break;
        }
    }

    void getHomeList(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("checkinTime","2020-04-01 11:15:05");
            jsonObject.put("checkoutTime","2020-04-03 11:15:05");
        }catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body=RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
        AppRetrofit.getNetApi().getHomeList(body).enqueue(new Callback<HomeListBean>() {
            @Override
            public void onResponse(Call<HomeListBean> call, Response<HomeListBean> response) {
                home=response.body();
                startActivity(ReserveActivity.class);
            }

            @Override
            public void onFailure(Call<HomeListBean> call, Throwable t) {
            }
        });
    }

    private static final int TIME_EXIT=2000;
    private long mBackPressed;

    @Override
    public void onBackPressed(){
        if(mBackPressed+TIME_EXIT>System.currentTimeMillis()){
            super.onBackPressed();
            ActivityCollector.finishAll();
            return;
        }else{
            Toast.makeText(this,"再点击一次返回退出程序", Toast.LENGTH_SHORT).show();
            mBackPressed=System.currentTimeMillis();
        }
    }

}
