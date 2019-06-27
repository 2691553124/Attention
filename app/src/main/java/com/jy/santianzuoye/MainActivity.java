package com.jy.santianzuoye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    /**
     * 5
     */
    private TextView mTvMain;
    private int a = 5;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mTvMain = (TextView) findViewById(R.id.tv_main);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTvMain.setText(a-- + "");
                        if (a < 0) {
                            timer.cancel();
                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                            finish();
                        }
                    }
                });
            }
        }, 500, 1000);


    }
}
