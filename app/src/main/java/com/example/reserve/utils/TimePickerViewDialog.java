package com.example.reserve.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reserve.R;


/**
 * @auther: lijunjie
 * @createDate: 2020/4/12  17:38
 * @purpose：暂时没有完成 半成品
 */
public class TimePickerViewDialog extends Dialog {

    private Context mContext;

    private RecyclerView recyclerView;

    public TimePickerViewDialog(@NonNull Context context) {
        super(context);
        this.mContext=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timepicker_layout);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.rv_daypickerview);
//        recyclerView.setAdapter(new )
    }
}
