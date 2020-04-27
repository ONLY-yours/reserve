package com.example.reserve.activity.UserCenter.OrderManager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.reserve.R;
import com.example.reserve.activity.UserCenter.Custom.CurstomListActivity;
import com.example.reserve.activity.UserCenter.VipActivity;
import com.example.reserve.base.BaseActivity;
import com.example.reserve.bean.OrderBean;
import com.example.reserve.bean.TBean;
import com.example.reserve.net.AppRetrofit;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetialActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvRoomType;
    private TextView tvTime;
    private TextView tvCurstoms;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_order_detial);

        initview();
    }

    void initview(){
        tvRoomType=findViewById(R.id.tv_roomtype);
        tvCurstoms=findViewById(R.id.tv_curstoms);
        tvTime=findViewById(R.id.tv_time);
        btnDelete=findViewById(R.id.btn_delete);

        tvTime.setText(VipActivity.orderlist.get(OrderManageActivity.Position).getCheckinTime()
                +"----"+VipActivity.orderlist.get(OrderManageActivity.Position).getCheckoutTime());
        tvRoomType.setText(VipActivity.orderlist.get(OrderManageActivity.Position).getTypeName());
        String curstoms="";
//        List<OrderBean.OrderCurstomBean> or= VipActivity.orderlist.get(OrderManageActivity.Position).getOrderCustomerList();
        for (int i=0;i<VipActivity.orderlist.get(OrderManageActivity.Position).getOrderCustomerList().size();i++){
            curstoms += VipActivity.orderlist.get(OrderManageActivity.Position).getOrderCustomerList().get(i).getName()+"  ";
        }
        tvCurstoms.setText(curstoms);



        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_delete:
//                JSONObject jsonObject = new JSONObject();
//                try {
//                    jsonObject.put("id",VipActivity.orderlist.get(OrderManageActivity.Position).getId());
//                }catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                RequestBody body=RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
//                AppRetrofit.getNetApi().deleteOrder(body).enqueue(new Callback<TBean>() {
//                    @Override
//                    public void onResponse(Call<TBean> call, Response<TBean> response) {
//                        if (response.body().getResult().equals("true")){
//                            showToast("删除成功");
//                            onBackPressed();
//                        }else {
//                            showToast("删除失败");
//                            onBackPressed();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<TBean> call, Throwable t) {
//                        showToast("请检查网络后重试！");
//                        onBackPressed();
//                    }
//                });
                showToast("删除成功");
                onBackPressed();
//                startActivity(VipActivity.class);
                break;



        }
    }
}
