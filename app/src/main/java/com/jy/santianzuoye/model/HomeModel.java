package com.jy.santianzuoye.model;

import com.jy.santianzuoye.callback.HomeCallback;

public interface HomeModel {
    void getData(HomeCallback homeCallback);

    void getDatas(HomeCallback homeCallback);
}
