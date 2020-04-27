package com.example.reserve.activity.UserCenter.Custom;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.reserve.R;
import com.example.reserve.activity.UserCenter.VipActivity;
import com.example.reserve.activity.reserve.FinalPayActivity;
import com.example.reserve.adapter.CurstomListAdapter;
import com.example.reserve.base.BaseActivity;
import com.example.reserve.bean.CurstomListBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


import okhttp3.MediaType;
import okhttp3.RequestBody;


//用户管理（客户管理）

public class CurstomListActivity extends BaseActivity {

    private RecyclerView rvCoustom;

    public static int Position;     //选定的人数位置

    private int choose=0;           //1表示从FinalPay活动启动 0表示从vip启动

    //存放其中的内容(位置)
    public static int[] count=new int[100];
    //用户选定用户数量
    public static int amount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_user_message);

        initview();
    }

    //用于更新数据后刷新界面使用
    @Override
    protected void onRestart() {
        initview();
        super.onRestart();
    }

    void initview(){
        amount=0;       //数量归零

        rvCoustom=findViewById(R.id.rv_curstom);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        rvCoustom.setLayoutManager(manager);

        CurstomListAdapter adapter=null;
        if (FinalPayActivity.curstomTemp!=null){
            adapter= new CurstomListAdapter(FinalPayActivity.curstomTemp);
            choose=1;
        }else{
            adapter= new CurstomListAdapter(VipActivity.curstomListBean);
        }
        rvCoustom.setAdapter(adapter);

        adapter.setmOnItemClickListener(myclick);
    }



    public CurstomListAdapter.OnItemClickListener myclick = new CurstomListAdapter.OnItemClickListener(){
        @Override
        public void onItemClick(View view, int position) {
            switch (view.getId()){
                case R.id.con_view:
                    if (choose==1){
                        count[amount]=position;
                        amount++;
                        showToast("你添加了用户："+FinalPayActivity.curstomTemp.getResult().get(position).getName());
                    }else{
                        Position=position;
                        startActivity(ModifyCurstomActivity.class);
                    }
                    break;
            }
        }
    };

}
