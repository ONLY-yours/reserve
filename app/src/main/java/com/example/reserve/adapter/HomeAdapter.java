package com.example.reserve.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reserve.R;
import com.example.reserve.bean.HomeListBean;

import java.util.List;

/**
 * @auther: lijunjie
 * @createDate: 2020/3/19  20:14
 * @purpose：
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<HomeListBean.homelistBean> smalldetial;

    public HomeAdapter(HomeListBean home){
        smalldetial=home.getResult();
    }

    private OnItemClickListener mOnItemClickListener = null;

    public static interface OnItemClickListener {
        void onItemClick(View view,int position);
    }

    public void setmOnItemClickListener(HomeAdapter.OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_home_reserve,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view,viewType);
            }
        });
        viewHolder.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view,viewType);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvPrice.setText("¥ "+smalldetial.get(position).getPrice());
        holder.tvDescribe1.setText(smalldetial.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return smalldetial.size();
    }



    static class ViewHolder extends RecyclerView.ViewHolder{
        //这些控件都可以设置监听事件
        View view;
        ImageView iv_img;
        TextView tvDescribe1;
        TextView tvDescribe2;
        TextView tvDescribe3;
        TextView tvPrice;
        Button btnPay;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView.findViewById(R.id.view_detial);
            iv_img=itemView.findViewById(R.id.iv_img);
            tvDescribe1=itemView.findViewById(R.id.tvdescribe1);
            tvDescribe2=itemView.findViewById(R.id.tvdescribe2);
            tvDescribe3=itemView.findViewById(R.id.tvdescribe3);
            tvPrice=itemView.findViewById(R.id.tv_price);
            btnPay=itemView.findViewById(R.id.btn_pay);
        }
    }


}
