package com.example.reserve.activity.reserve;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bigkoo.pickerview.TimePickerView;
import com.example.reserve.MainActivity;
import com.example.reserve.R;
import com.example.reserve.adapter.HomeAdapter;
import com.example.reserve.base.BaseActivity;
import com.example.reserve.bean.HomeListBean;
import com.example.reserve.net.AppRetrofit;
import com.example.reserve.utils.TimePickerViewDialog;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.example.reserve.utils.TimePickerViewDialog;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//预定界面

public class ReserveActivity extends BaseActivity {

    private RecyclerView rvHomeReserve;
    private TextView tvCheckin;
    private TextView tvCheckout;

    public static int Position=0;
    public static HomeListBean newhome;
    public String checkintime;
    public String checkouttime;

    Calendar calendar= Calendar.getInstance(Locale.CHINA);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_reserve);

        initview();

        rvHomeReserve=findViewById(R.id.rv_homereserve);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvHomeReserve.setLayoutManager(manager);

        HomeAdapter adapter = new HomeAdapter(MainActivity.home);
        rvHomeReserve.setAdapter(adapter);

        adapter.setmOnItemClickListener(myOnItemClickListener);

    }

    void initview(){
        tvCheckin=findViewById(R.id.tv_checkin_time);
        tvCheckout=findViewById(R.id.tv_checkout_time);

        tvCheckin.setText(calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DAY_OF_MONTH));
        tvCheckout.setText(calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+(calendar.get(Calendar.DAY_OF_MONTH)+1));

        tvCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(ReserveActivity.this, 4, tvCheckin, calendar);
                checkintime=tvCheckin.getText()+" "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
            }
        });

        tvCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(ReserveActivity.this, 4, tvCheckout, calendar);
                checkouttime=tvCheckout.getText()+" 12:59:59";
            }
        });


    }



    private HomeAdapter.OnItemClickListener myOnItemClickListener = new HomeAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view,int viewType ,int position) {
            switch (view.getId()){
                case R.id.btn_pay:
                    startActivity(FinalPayActivity.class);
                    break;
                case R.id.view_detial:

                    Position=position;
//                    saveTheKeyValues("position",""+position);
                    startActivity(RoomDetialActivity.class);
                    break;

            }
        }
    };




    void getHomeList(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("checkinTime",checkintime);
            jsonObject.put("checkoutTime",checkouttime);
        }catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body=RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
        AppRetrofit.getNetApi().getHomeList(body).enqueue(new Callback<HomeListBean>() {
            @Override
            public void onResponse(Call<HomeListBean> call, Response<HomeListBean> response) {
                newhome=response.body();
//                startActivity(ReserveActivity.class);
            }

            @Override
            public void onFailure(Call<HomeListBean> call, Throwable t) {
            }
        });
    }





    /**
     * 日期选择
     * @param activity
     * @param themeResId
     * @param tv
     * @param calendar
     */
    public static void showDatePickerDialog(Activity activity, int themeResId, final TextView tv, Calendar calendar) {
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            // 绑定监听器(How the parent is notified that the date is set.)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 此处得到选择的时间，可以进行你想要的操作:2020-04-01
                tv.setText( year+"-"+(monthOfYear + 1) +"-"+ dayOfMonth);

            }
        }
                // 设置初始日期
                , calendar.get(Calendar.YEAR)
                , calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH)).show();
    }




}
