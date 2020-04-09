package com.example.reserve.activity.reserve;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.reserve.MainActivity;
import com.example.reserve.R;
import com.example.reserve.adapter.HomeAdapter;
import com.example.reserve.base.BaseActivity;

public class ReserveActivity extends BaseActivity {

    private RecyclerView rvHomeReserve;

    public static int Position=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_reserve);

        rvHomeReserve=findViewById(R.id.rv_homereserve);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvHomeReserve.setLayoutManager(manager);

        HomeAdapter adapter = new HomeAdapter(MainActivity.home);
        rvHomeReserve.setAdapter(adapter);

        adapter.setmOnItemClickListener(myOnItemClickListener);

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
                    saveTheKeyValues("position",""+position);
                    startActivity(RoomDetialActivity.class);
                    break;

            }
        }
    };
}
