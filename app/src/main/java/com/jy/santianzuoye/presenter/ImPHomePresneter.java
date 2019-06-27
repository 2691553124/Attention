package com.jy.santianzuoye.presenter;

import com.jy.santianzuoye.bean.AttentionBean;
import com.jy.santianzuoye.bean.HomeBean;
import com.jy.santianzuoye.callback.HomeCallback;
import com.jy.santianzuoye.model.ImPHomeMolde;
import com.jy.santianzuoye.view.HomeView;

public class ImPHomePresneter implements HomePresenter, HomeCallback {
    private ImPHomeMolde imPHomeMolde;
    private HomeView homeView;

    public ImPHomePresneter(ImPHomeMolde imPHomeMolde, HomeView homeView) {
        this.imPHomeMolde = imPHomeMolde;
        this.homeView = homeView;
    }

    @Override
    public void initData() {
        if (imPHomeMolde != null) {
            imPHomeMolde.getData(this);
        }
    }

    @Override
    public void initDatas() {
        if (imPHomeMolde != null) {
            imPHomeMolde.getDatas(this);
        }
    }

    @Override
    public void onSuccess(HomeBean homeBean) {
        if (homeView != null) {
            homeView.onSuccess(homeBean);
        }
    }

    @Override
    public void onFild(String onfild) {
        if (homeView != null) {
            homeView.onFild(onfild);
        }
    }

    @Override
    public void AttOnSuccess(AttentionBean attentionBean) {
        if (homeView != null) {
            homeView.AttOnSuccess(attentionBean);
        }
    }

    @Override
    public void AttonFild(String onfild) {
        if (homeView != null) {
            homeView.AttonFild(onfild);
        }
    }
}
