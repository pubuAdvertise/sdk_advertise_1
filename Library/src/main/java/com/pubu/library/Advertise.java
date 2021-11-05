package com.pubu.library;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Advertise {

    private static Advertise advertise;
    private Advertise() { }
    public static Advertise getInstance() {
        if (advertise == null) {
            synchronized (Advertise.class) {
                if (advertise == null) {
                    advertise = new Advertise();
                }
            }
        }
        return advertise;
    }

    public void onRequest(AppCompatActivity activity, HttpCallBackListener httpCallBackListener){
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        InvisibleFragment fragment = new InvisibleFragment();
        if (fragment.isAdded()){
            fragmentTransaction.show(fragment);
        }else {
            fragmentTransaction.add(fragment,"").commitNow();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                fragment.getwebinfo(httpCallBackListener);
            }
        }).start();
    }

}
