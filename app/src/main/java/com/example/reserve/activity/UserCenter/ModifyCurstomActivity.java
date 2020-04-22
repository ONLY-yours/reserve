package com.example.reserve.activity.UserCenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.reserve.R;
import com.example.reserve.base.BaseActivity;
import com.example.reserve.bean.TBean;
import com.example.reserve.net.AppRetrofit;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModifyCurstomActivity extends BaseActivity implements View.OnClickListener {

    private EditText etName;
    private EditText etIdCard;
    private EditText etPhone;
    private TextView tvGender;
    private Button btnMale;
    private Button btnFeMale;
    private Button btnUpLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_modify_curstom);
        initview();

    }

    void initview(){
        etName=findViewById(R.id.et_name);
        etIdCard=findViewById(R.id.et_idcard);
        etPhone=findViewById(R.id.et_phone);
        tvGender=findViewById(R.id.tv_gender);

        btnFeMale=findViewById(R.id.btn_female);
        btnMale=findViewById(R.id.btn_male);
        btnUpLoad=findViewById(R.id.btn_upload);

        btnMale.setOnClickListener(this);
        btnFeMale.setOnClickListener(this);
        btnUpLoad.setOnClickListener(this);

        etName.setText(VipActivity.curstomListBean.getResult().get(CurstomListActivity.Position).getName());
        etIdCard.setText(VipActivity.curstomListBean.getResult().get(CurstomListActivity.Position).getIdcard());
        etPhone.setText(VipActivity.curstomListBean.getResult().get(CurstomListActivity.Position).getPhone());
        tvGender.setText(VipActivity.curstomListBean.getResult().get(CurstomListActivity.Position).getGender());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_female:
                tvGender.setText("女");
                break;
            case R.id.btn_male:
                tvGender.setText("男");
                break;
            case R.id.btn_upload:
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("gender",""+tvGender.getText());
                    jsonObject.put("idcard",""+etIdCard.getText());
                    jsonObject.put("name",""+etName.getText());
                    jsonObject.put("phone",""+etPhone.getText());
                    jsonObject.put("id",VipActivity.curstomListBean.getResult().get(CurstomListActivity.Position).getId());
                }catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestBody body=RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
                AppRetrofit.getNetApi().updateCurstomMessage(body).enqueue(new Callback<TBean>() {
                    @Override
                    public void onResponse(Call<TBean> call, Response<TBean> response) {
                        if (response.body().getSuccess().equals("true")){
                            showToast("修改成功");
                            onBackPressed();
                        }else{
                            showToast("修改失败，请填写正确的信息");
                            onBackPressed();
                        }
                    }
                    @Override
                    public void onFailure(Call<TBean> call, Throwable t) {
                        showToast("修改失败，请检查网络后重试");
                    }
                });

                onBackPressed();
                startActivity(VipActivity.class);
                break;
        }
    }

}
