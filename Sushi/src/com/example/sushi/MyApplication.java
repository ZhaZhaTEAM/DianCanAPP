package com.example.jc.store.com.team.bean;

import android.app.Application;

/**
 * Created by JC on 2016/12/14.
 */
public class MyApplication  extends Application{
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
