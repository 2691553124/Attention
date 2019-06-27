package com.jy.santianzuoye;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Web extends AppCompatActivity {

    private WebView mWb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
    }

    private void initView() {
        mWb = (WebView) findViewById(R.id.wb);
        mWb.loadUrl("http://mini.eastday.com/mobile/171109180324333.html");
        WebSettings settings = mWb.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
    }
}
