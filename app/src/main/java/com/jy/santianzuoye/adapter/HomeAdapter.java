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
import com.jy.santianzuoye.R;
import com.jy.santianzuoye.Web;
import com.jy.santianzuoye.bean.HomeBean;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<HomeBean.DataBean> list;
    private Context context;

    public HomeAdapter(ArrayList<HomeBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_one, null);
            return new ViewHomder1(inflate);
        }
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_tow, null);
            return new ViewHomder2(inflate);
        }
        if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_san, null);
            return new ViewHomder3(inflate);
        }
        if (viewType == 3) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_si, null);
            return new ViewHomder4(inflate);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        HomeBean.DataBean dataBean = list.get(position);
        if (itemViewType == 0) {
            ViewHomder1 viewHomder1 = (ViewHomder1) holder;
            viewHomder1.mTvs.setText(dataBean.getText());
            Glide.with(context).load(dataBean.getProfile_image()).into(viewHomder1.mItemOneiv);
            viewHomder1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemLong != null) {
                        onItemLong.onitemClick(position);
                    }
                }
            });
        }
        if (itemViewType == 1) {
            ViewHomder2 viewHomder2 = (ViewHomder2) holder;
            viewHomder2.mTitle.setText(dataBean.getText());
            Glide.with(context).load(dataBean.getProfile_image()).into(viewHomder2.mIv);
            Glide.with(context).load(dataBean.getProfile_image()).into(viewHomder2.mIvS);
            viewHomder2.mTvTitles.setText(dataBean.getText());
            viewHomder2.itemView.setOnClickListener(new View.OnClickListener() {
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
        if (itemViewType == 2) {
            ViewHomder3 viewHomder3 = (ViewHomder3) holder;
            viewHomder3.mTvShow.setText(dataBean.getText());
            Glide.with(context).load(dataBean.getProfile_image()).into(viewHomder3.mSvIv);
            viewHomder3.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemLong != null) {
                        onItemLong.onitemClick(position);
                    }
                }
            });
        }
        if (itemViewType == 3) {
            ViewHomder4 viewHomder4 = (ViewHomder4) holder;
            viewHomder4.mTvShow.setText(dataBean.getText());
            Glide.with(context).load(dataBean.getProfile_image()).into(viewHomder4.mSvIv);
            viewHomder4.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemLong != null) {
                        onItemLong.onitemClick(position);
                    }
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 3) {
            return 2;
        } else {
            return 3;
        }

    }

    class ViewHomder1 extends RecyclerView.ViewHolder {
        TextView mTvs;
        ImageView mItemOneiv;

        public ViewHomder1(View itemView) {
            super(itemView);
            this.mTvs = (TextView) itemView.findViewById(R.id.tvs);
            this.mItemOneiv = (ImageView) itemView.findViewById(R.id.item_oneiv);
        }
    }

    class ViewHomder2 extends RecyclerView.ViewHolder {
        ImageView mIvS;
        TextView mTvTitles;
        ImageView mIv;
        TextView mTitle;

        public ViewHomder2(View itemView) {
            super(itemView);

            this.mIvS = (ImageView) itemView.findViewById(R.id.iv_s);
            this.mTvTitles = (TextView) itemView.findViewById(R.id.tv_titles);
            this.mIv = (ImageView) itemView.findViewById(R.id.iv);
            this.mTitle = (TextView) itemView.findViewById(R.id.title);
        }
    }

    class ViewHomder3 extends RecyclerView.ViewHolder {
        TextView mTvShow;
        ImageView mSvIv;

        public ViewHomder3(View itemView) {
            super(itemView);
            this.mTvShow = (TextView) itemView.findViewById(R.id.tv_show);
            this.mSvIv = (ImageView) itemView.findViewById(R.id.sv_iv);
        }
    }

    class ViewHomder4 extends RecyclerView.ViewHolder {
        ImageView mSvIv;
        TextView mTvShow;

        public ViewHomder4(View itemView) {
            super(itemView);
            this.mSvIv = (ImageView) itemView.findViewById(R.id.sv_iv);
            this.mTvShow = (TextView) itemView.findViewById(R.id.tv_show);
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
