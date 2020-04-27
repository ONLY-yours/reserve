package com.example.reserve.activity.UserCenter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.reserve.R;
import com.example.reserve.activity.UserCenter.Custom.CurstomListActivity;
import com.example.reserve.activity.UserCenter.OrderManager.OrderManageActivity;
import com.example.reserve.base.BaseActivity;
import com.example.reserve.bean.CurstomListBean;
import com.example.reserve.bean.OrderBean;
import com.example.reserve.bean.OrderListBean;
import com.example.reserve.net.AppRetrofit;

import org.json.JSONObject;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VipActivity extends BaseActivity implements View.OnClickListener {

    //原定为VIP服务，现在存放为个人中心

    private TextView tvOrderManage;
    private TextView tvSelfMessage;
    private TextView tvPeopleAdd;

    public static CurstomListBean curstomListBean;

    public static List<OrderBean> orderlist;

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
                JSONObject jsonObjectempty = new JSONObject();
                RequestBody bodyempty=RequestBody.create(MediaType.parse("application/json"),jsonObjectempty.toString());
                AppRetrofit.getNetApi().getOrderList(bodyempty).enqueue(new Callback<OrderListBean>() {
                    @Override
                    public void onResponse(Call<OrderListBean> call, Response<OrderListBean> response) {
//                        showToast("true"+response.body().getResult().get(1).getCheckinTime());
                        orderlist=response.body().getResult();
                        startActivity(OrderManageActivity.class);
                    }

                    @Override
                    public void onFailure(Call<OrderListBean> call, Throwable t) {
                        showToast("网络不好请重试");
                    }
                });

                break;
            case R.id.tv_self_message:
                startActivity(PeopleAddActivity.class);
                break;
            case R.id.tv_people_add:
                String token = "iWAoOI4rrrvRISluC7I/nKmhTIvDfRACU+iaaRWsKcCUIPio58RcRZvhZKKG6TsM";
                JSONObject jsonObject = new JSONObject();
                RequestBody body=RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
                AppRetrofit.getNetApi().getCurstomList(body).enqueue(new Callback<CurstomListBean>() {
                    @Override
                    public void onResponse(Call<CurstomListBean> call, Response<CurstomListBean> response) {
//                        showToast(""+response.body().getResult().size());
                        curstomListBean=response.body();
                        startActivity(CurstomListActivity.class);
                    }
                    @Override
                    public void onFailure(Call<CurstomListBean> call, Throwable t) {
                        showToast("false");

                    }
                });
                break;

        }
    }
}
