package com.pubu.advertise_sdk_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.pubu.library.Advertise;
import com.pubu.library.HttpCallBackListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Advertise.getInstance().onRequest(this, new HttpCallBackListener() {
            @Override
            public void onSuccess(String msg) {
                Log.e("jss",msg);
            }

            @Override
            public void onFailure(String msg) {

            }

            @Override
            public void onUnConnect(String msg) {

            }
        });
    }
}