package com.pinxiango.studytest;

import android.app.Application;

/**
 * Created by 解晓辉 on 2017/9/8.
 * 作用：
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppUtil.init(this);
    }
}
