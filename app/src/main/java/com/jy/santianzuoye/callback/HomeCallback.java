package com.jy.santianzuoye.callback;

import com.jy.santianzuoye.bean.AttentionBean;
import com.jy.santianzuoye.bean.HomeBean;

public interface HomeCallback {
    void onSuccess(HomeBean homeBean);

    void onFild(String onfild);

    void AttOnSuccess(AttentionBean attentionBean);

    void AttonFild(String onfild);
}
