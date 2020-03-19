package com.example.reserve.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.reserve.R;
import com.example.reserve.adapter.HomeAdapter;
import com.example.reserve.base.BaseActivity;

import static com.example.reserve.adapter.HomeAdapter.*;

public class ReserveActivity extends BaseActivity {

    private RecyclerView rvHomeReserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_reserve);

        rvHomeReserve=findViewById(R.id.rv_homereserve);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvHomeReserve.setLayoutManager(manager);
        HomeAdapter adapter = new HomeAdapter();
        rvHomeReserve.setAdapter(adapter);


        adapter.setmOnItemClickListener(myOnItemClickListener);

    }

    private HomeAdapter.OnItemClickListener myOnItemClickListener = new HomeAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            switch (view.getId()){

                case R.id.btn_pay:
                    startActivity(FinalPayActivity.class);
                    break;
                case R.id.view_detial:
                    showToast("detials");
                    break;

            }
        }
    };
}
