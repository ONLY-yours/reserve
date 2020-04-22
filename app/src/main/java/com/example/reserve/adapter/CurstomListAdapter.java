package com.example.reserve.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reserve.R;
import com.example.reserve.activity.UserCenter.CurstomListActivity;
import com.example.reserve.bean.CurstomListBean;

import org.w3c.dom.Text;

import java.util.List;

/**
 * @auther: lijunjie
 * @createDate: 2020/4/16  21:21
 * @purpose：用于客户列表信息的recyclerview
 */
public class CurstomListAdapter extends RecyclerView.Adapter<CurstomListAdapter.ViewHolder> {

    private List<CurstomListBean.CurstomBean> curstomList;

    private CurstomListAdapter.OnItemClickListener mOnItemClickListener = null;

    public CurstomListAdapter(CurstomListBean bean){
        curstomList=bean.getResult();
    }

    public static interface OnItemClickListener {
        void onItemClick(View view,int position);
    }

    public void setmOnItemClickListener(CurstomListAdapter.OnItemClickListener onItemClickListener){
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
    public void onBindViewHolder(@NonNull CurstomListAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText(curstomList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return curstomList.size();
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
