package com.jy.santianzuoye.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jy.santianzuoye.R;
import com.jy.santianzuoye.adapter.AttentionAdapter;
import com.jy.santianzuoye.bean.AttentionBean;
import com.jy.santianzuoye.bean.HomeBean;
import com.jy.santianzuoye.model.ImPHomeMolde;
import com.jy.santianzuoye.presenter.ImPHomePresneter;
import com.jy.santianzuoye.view.HomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttentionFragment extends Fragment implements HomeView {


    private View view;
    /**
     * Hello blank fragment
     */
    private RecyclerView mRv;
    private ArrayList<AttentionBean.MsgBean.ResultBean> list;
    private AttentionAdapter adapter;
    private ImPHomePresneter imPHomePresneter;

    public AttentionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_recycle, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new AttentionAdapter(list, getContext());
        mRv.setAdapter(adapter);
        initData();
        adapter.setOnItemLong(new AttentionAdapter.OnItemLong() {
            @Override
            public void onitemClick(int position) {

            }
        });

    }

    private void initData() {
        imPHomePresneter = new ImPHomePresneter(new ImPHomeMolde(), this);
        imPHomePresneter.initDatas();

    }

    @Override
    public void onSuccess(HomeBean homeBean) {

    }

    @Override
    public void onFild(String onfild) {

    }

    @Override
    public void AttOnSuccess(final AttentionBean attentionBean) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    List<AttentionBean.MsgBean.ResultBean> result = attentionBean.getMsg().getResult();
                    list.addAll(result);
                    adapter.notifyDataSetChanged();
                }
            });
    }

    @Override
    public void AttonFild(String onfild) {
        Log.e("e", "AttonFild: "+onfild );
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
