package com.example.reserve.activity.usermanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.reserve.MainActivity;
import com.example.reserve.R;
import com.example.reserve.base.BaseActivity;
import com.example.reserve.bean.LoginBean;
import com.example.reserve.net.AppRetrofit;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistActivity extends BaseActivity implements View.OnClickListener {


    private static Handler mHandler = new Handler();
    private int trytimes=0;     //用于放置发送后时间
    private FloatingActionButton btnSeePassword;


    private MaterialEditText etPhone;
    private Button btnSend;
    private MaterialEditText etPassword;
    private MaterialEditText etCode;
    private FloatingActionButton btnRegist;

    private String phoneNumber;
    private String password;
    private String varcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_regist);

        initview();
    }

    void initview(){
        etPhone=findViewById(R.id.et_phonenumber);
        btnSend=findViewById(R.id.btn_send);
        btnSeePassword=findViewById(R.id.btn_showpassword);
        etPassword=findViewById(R.id.et_password);
        etCode=findViewById(R.id.et_code);
        btnRegist=findViewById(R.id.btn_regist);

        btnSend.setOnClickListener(this);
        btnSeePassword.setOnClickListener(this);
        btnRegist.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_send:
                if (etPhone.getText().length()>=9){
                    btnSend.setClickable(false);
                    JSONObject jsonObject = new JSONObject();
                    phoneNumber=etPhone.getText().toString();
                    try {
                        jsonObject.put("username",phoneNumber);
                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                    RequestBody body=RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
                    AppRetrofit.getNetApi().sedPhoneNumber(body).enqueue(new Callback<LoginBean>() {
                        @Override
                        public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                            if (response.body().getSuccess().equals("true")){
                                showToast("短信成功发送！");
                                trytimes=60;
                                doTimeCount();
                            }else{
                                if (response.body().getMessage().equals("该手机已注册，请勿重复注册"))
                                    showToast("该手机已注册，请勿重复注册");
                                    else
                                        showToast("请填写正确的电话号码");
                            }
                        }
                        @Override
                        public void onFailure(Call<LoginBean> call, Throwable t) {
                                showToast("请检查网络后重试");
                                 btnSend.setClickable(true);
                        }
                    });
                }else{
                    showToast("请先输入正确的手机号");
                    btnSend.setClickable(true);
                }
                break;
            case R.id.btn_showpassword:
                if (etPassword.getInputType() == 128)
                    etPassword.setInputType(129);
                else
                etPassword.setInputType(128);
                break;
            case R.id.btn_regist:
                if (etPhone.getText().length()>=9){
                    if (etPassword.getText().length()>=6){
                        if (etCode.getText().length()>=1){
                            btnRegist.setClickable(false);

                            phoneNumber=etPhone.getText().toString();
                            password=etPassword.getText().toString();
                            varcode=etCode.getText().toString();

                            JSONObject jsonObject = new JSONObject();
                            try {
                                jsonObject.put("username",etPhone.getText().toString());
                                jsonObject.put("password",etPassword.getText().toString());
                                jsonObject.put("varcode",etCode.getText().toString());
                            }catch (JSONException e) {
                                e.printStackTrace();
                            }
                            RequestBody body=RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
                            AppRetrofit.getNetApi().doRegist(body).enqueue(new Callback<LoginBean>() {
                                @Override
                                public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                                    showToast("注册成功");
                                    btnRegist.setClickable(true);
                                    onBackPressed();
                                }

                                @Override
                                public void onFailure(Call<LoginBean> call, Throwable t) {

                                    btnRegist.setClickable(true);
                                }
                            });



                        }else{
                         showToast("验证码长度不正确");
                        }
                    }else{
                        showToast("密码过短");
                    }
                }
                break;
            default:
                break;
        }
    }


    public void doTimeCount(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //do something
                //每隔1s循环执行run方法
                mHandler.postDelayed(this, 1000);
                trytimes--;
                if(trytimes>0){
                    btnSend.setText(trytimes+"");
                }else if(trytimes<=0){
                    btnSend.setText("发送验证码");
                    btnSend.setClickable(true);
                }
            }
        };
        mHandler.postDelayed(r, 1000);
    };

}
