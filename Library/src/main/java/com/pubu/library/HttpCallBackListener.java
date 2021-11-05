package com.pubu.library;

public interface HttpCallBackListener {

    void onSuccess(String msg);
    void onFailure(String msg);
    void onUnConnect(String msg);
}
