package com.jy.santianzuoye.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jy.santianzuoye.bean.AttentionBean;
import com.jy.santianzuoye.bean.HomeBean;
import com.jy.santianzuoye.callback.HomeCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ImPHomeMolde implements HomeModel{
    @Override
    public void getData(final HomeCallback homeCallback) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("https://www.apiopen.top/satinApi?type=1&page=1").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
               homeCallback.onFild("失败"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new GsonBuilder().serializeNulls().create();
                HomeBean homeBean = gson.fromJson(string, HomeBean.class);
                homeCallback.onSuccess(homeBean);


            }
        });

    }

    @Override
    public void getDatas(final HomeCallback homeCallback) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("http://apps.game.qq.com/" +
                "lol/act/website2013/video.php?page=1&pagesize=10&r1=1&source=lolapp&plat=android&version=9832&tdsourcetag=s_pcqq_aiomsg").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                homeCallback.AttonFild("失败"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new GsonBuilder().serializeNulls().create();
                AttentionBean attentionBean = gson.fromJson(string, AttentionBean.class);

                homeCallback.AttOnSuccess(attentionBean);

            }
        });
    }
}
