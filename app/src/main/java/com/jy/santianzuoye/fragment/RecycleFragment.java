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
import com.jy.santianzuoye.adapter.HomeAdapter;
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
public class RecycleFragment extends Fragment implements HomeView {


    private View view;
    /**
     * Hello blank fragment
     */
    private RecyclerView mRv;
    private ArrayList<HomeBean.DataBean> list;
    private HomeAdapter adapter;
    private ImPHomePresneter imPHomePresneter;

    public RecycleFragment() {
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
        adapter = new HomeAdapter(list, getContext());
        mRv.setAdapter(adapter);
        initData();
    }

    private void initData() {
        imPHomePresneter = new ImPHomePresneter(new ImPHomeMolde(), this);
        imPHomePresneter.initData();
    }

    @Override
    public void onSuccess(final HomeBean homeBean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                List<HomeBean.DataBean> data = homeBean.getData();
                list.addAll(data);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onFild(final String onfild) {
        Log.e("e", "run: " + onfild);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void AttOnSuccess(AttentionBean attentionBean) {

    }

    @Override
    public void AttonFild(String onfild) {

    }
}
