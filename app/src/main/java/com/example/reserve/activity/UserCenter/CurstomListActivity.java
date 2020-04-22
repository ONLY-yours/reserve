package com.example.reserve.activity.UserCenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;

import com.example.reserve.R;
import com.example.reserve.adapter.CurstomListAdapter;
import com.example.reserve.base.BaseActivity;


//用户管理（客户管理）

public class CurstomListActivity extends BaseActivity {

    private RecyclerView rvCoustom;

    public static int Position;     //选定的人数位置

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
        rvCoustom=findViewById(R.id.rv_curstom);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        rvCoustom.setLayoutManager(manager);

        CurstomListAdapter adapter= new CurstomListAdapter(VipActivity.curstomListBean);
        rvCoustom.setAdapter(adapter);

        adapter.setmOnItemClickListener(myclick);
    }


    public CurstomListAdapter.OnItemClickListener myclick = new CurstomListAdapter.OnItemClickListener(){
        @Override
        public void onItemClick(View view, int position) {
            switch (view.getId()){
                case R.id.con_view:
                    Position=position;
                    startActivity(ModifyCurstomActivity.class);
                    break;
            }
        }
    };

}
