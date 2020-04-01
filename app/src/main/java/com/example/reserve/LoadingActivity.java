package com.example.reserve;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.reserve.activity.usermanger.RegistActivity;
import com.example.reserve.base.BaseActivity;
import com.example.reserve.bean.LoginBean;
import com.example.reserve.net.AppRetrofit;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadingActivity extends BaseActivity implements View.OnClickListener {

    private Button btnRegist;
    private FloatingActionButton btnFloatLogin;

    private MaterialEditText etName;
    private MaterialEditText etPassword;


    private String username="";
    private String password="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_loading);

        initview();
    }

    void initview(){
        etPassword=findViewById(R.id.et_password);
        etName=findViewById(R.id.et_name);

        btnRegist=findViewById(R.id.btn_regist);
        btnRegist.setOnClickListener(this);

        btnFloatLogin=findViewById(R.id.btn_float_login);
        btnFloatLogin.setClickable(true);
        btnFloatLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_regist:
                startActivity(RegistActivity.class);
                break;
            case R.id.btn_float_login:
//                username=etName.getText().toString();
//                password=etPassword.getText().toString();
//                btnFloatLogin.setClickable(false);
//                JSONObject jsonObject = new JSONObject();
//                try {
//                jsonObject.put("username", username);
//                jsonObject.put("password", password);
//                }catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                showToast(password+username);
//                if (password.length()>2&&username.length()>3){
//                    RequestBody body=RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
//                    AppRetrofit.getNetApi().doLogin(body).enqueue(new Callback<LoginBean>() {
//                        @Override
//                        public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
//                            if (response.body().getSuccess().equals("true")){
//                                startActivity(MainActivity.class);
//                            }else{
//                                showToast("账号密码错误，请重试");
//                            }
//                            btnFloatLogin.setClickable(true);
//                        }
//
//                        @Override
//                        public void onFailure(Call<LoginBean> call, Throwable t) {
//                            showToast("请求失败，请检查网络后重试");
//                            btnFloatLogin.setClickable(true);
//                        }
//                    });
//                    break;
//                }else {
//                    showToast("请输入密码和账号");
//                    btnFloatLogin.setClickable(true);
//                }

                startActivity(MainActivity.class);
        }
    }
}
