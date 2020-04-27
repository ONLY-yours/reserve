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
    private EditText etPeople;

    private View btnBack;

    private Button btnAddCurstom;

    //用于判定选定用户的活动的时候判断是否是修改还是添加
    public static List<Integer> chooseCurstomOrNot;

    //暂存的curstom
    public static CurstomListBean curstomTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_final_pay);

        initview();
    }

    void initview(){

//        int position = Integer.parseInt(getTheKeyValues("position"));
        int position = ReserveActivity.Position;            //模拟器用下面的这个

        etPeople=findViewById(R.id.et_people);
//        etPeople.

        btnAddCurstom=findViewById(R.id.btn_custom_add);
        btnAddCurstom.setOnClickListener(this);

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
    protected void onRestart() {
        if (CurstomListActivity.amount!=0){
            etPeople=findViewById(R.id.et_people);
            etPeople.setText("你选定了"+curstomTemp.getResult().get(CurstomListActivity.count[0]).getName()+"等"+CurstomListActivity.amount+"人");
        }
        super.onRestart();
    }

    @Override
    public void onBackPressed() {
        curstomTemp=null;
        super.onBackPressed();
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
            case R.id.btn_custom_add:

                String token = "iWAoOI4rrrvRISluC7I/nKmhTIvDfRACU+iaaRWsKcCUIPio58RcRZvhZKKG6TsM";
                JSONObject jsonObject = new JSONObject();
                RequestBody body=RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
                AppRetrofit.getNetApi().getCurstomList(body).enqueue(new Callback<CurstomListBean>() {
                    @Override
                    public void onResponse(Call<CurstomListBean> call, Response<CurstomListBean> response) {
//                        showToast(""+response.body().getResult().size());
                        curstomTemp=response.body();
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
