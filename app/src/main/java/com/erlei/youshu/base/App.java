package com.erlei.youshu.base;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.erlei.youshu.R;

/**
 * Created by lll on 2018/2/15.
 * Email ： lllemail@foxmail.com
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLog();
    }

    private void initLog() {
        Utils.init(this);
        LogUtils.getConfig()
                .setConsoleSwitch(true)
                .setConsoleFilter(LogUtils.V)
                .setLogSwitch(true)
                .setBorderSwitch(false)
                .setGlobalTag(getString(R.string.app_name))
                .setFilePrefix("log");

    }

}
