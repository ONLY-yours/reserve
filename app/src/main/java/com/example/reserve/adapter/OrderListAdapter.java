package com.example.reserve.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reserve.R;
import com.example.reserve.bean.OrderBean;

import java.util.List;

/**
 * @auther: lijunjie
 * @createDate: 2020/4/23  20:25
 * @purpose：用于订单列表的adapter
 */
public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {

    private List<OrderBean> orderBeans;

    public OrderListAdapter(List<OrderBean>order){
        orderBeans=order;
    }

    private OrderListAdapter.OnItemClickListener mOnItemClickListener = null;


    public static interface OnItemClickListener {
        void onItemClick(View view,int position);
    }

    public void setmOnItemClickListener(OrderListAdapter.OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_curstom_item,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view,viewHolder.getAdapterPosition());
            }
        });

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull OrderListAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText(orderBeans.get(position).getTypeName());
    }

    @Override
    public int getItemCount() {
        return orderBeans.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        ConstraintLayout con;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.tv_name);
            con=itemView.findViewById(R.id.con_view);
        }
    }


}
