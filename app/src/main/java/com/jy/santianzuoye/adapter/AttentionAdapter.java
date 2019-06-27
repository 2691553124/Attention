package com.jy.santianzuoye.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jy.santianzuoye.R;
import com.jy.santianzuoye.Web;
import com.jy.santianzuoye.bean.AttentionBean;

import java.util.ArrayList;

public class AttentionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<AttentionBean.MsgBean.ResultBean> list;
    private Context context;

    public AttentionAdapter(ArrayList<AttentionBean.MsgBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.item_guan, null);
        return new ViewHomder1(inflate);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        AttentionBean.MsgBean.ResultBean resultBean = list.get(position);
        ViewHomder1 viewHomder1 = (ViewHomder1) holder;
        viewHomder1.mAuthor.setText(resultBean.getAuthor());
        viewHomder1.mTitlel.setText(resultBean.getTitle());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(context).load(resultBean.getAuthorImg()).apply(requestOptions).into(viewHomder1.mIvIvss);
        Glide.with(context).load(resultBean.getAuthorImg()).into(viewHomder1.mAuthorImg);
        viewHomder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemLong != null) {
                    onItemLong.onitemClick(position);
                    Intent intent = new Intent(context, Web.class);
                    context.startActivity(intent);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHomder1 extends RecyclerView.ViewHolder {
        ImageView mIvIvss;
        TextView mAuthor;
        ImageView mAuthorImg;
        TextView mTitlel;
        public ViewHomder1(View itemView) {
            super(itemView);
            this.mIvIvss = (ImageView) itemView.findViewById(R.id.iv_ivss);
            this.mAuthor = (TextView) itemView.findViewById(R.id.author);
            this.mAuthorImg = (ImageView) itemView.findViewById(R.id.authorImg);
            this.mTitlel = (TextView) itemView.findViewById(R.id.titlel);
        }
    }


    private OnItemLong onItemLong;

    public void setOnItemLong(OnItemLong onItemLong) {
        this.onItemLong = onItemLong;
    }

    public interface OnItemLong {
        void onitemClick(int position);
    }



}
