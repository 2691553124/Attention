package com.jy.santianzuoye;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jy.santianzuoye.adapter.FragmentAdapter;
import com.jy.santianzuoye.fragment.AttentionFragment;
import com.jy.santianzuoye.fragment.RecycleFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> list;
    private ArrayList<String> strings;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();


    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        list = new ArrayList<>();
        RecycleFragment recycleFragment = new RecycleFragment();
        AttentionFragment attentionFragment = new AttentionFragment();
        list.add(recycleFragment);
        list.add(attentionFragment);
        strings = new ArrayList<>();
        strings.add("热门");
        strings.add("关注");
        adapter = new FragmentAdapter(getSupportFragmentManager(), list, strings);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);
    }
}
