package com.erlei.baselibrary.base;

import com.blankj.utilcode.util.Utils;

/**
 * Created by lll on 2018/2/15.
 * Email ： lllemail@foxmail.com
 */
public class BaseApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
