package com.erlei.youshu.callback;

import android.app.Activity;

import com.blankj.utilcode.util.ActivityUtils;
import com.erlei.youshu.base.Contract;

/**
 * Created by lll on 2018/3/27.
 * Email : lllemail@foxmail.com
 */
public class SimpleObserver<T> extends BaseObserver<T> {
    @Override
    public void onSuccess(T o) {
        hideLoading();
    }

    @Override
    public void onFailure(int code, String msg) {
        hideLoading();
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        // TODO: 2018/3/27 全局异常处理,无网络...
        hideLoading();
    }

    private void hideLoading() {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity != null && topActivity instanceof Contract.View) {
            ((Contract.View) topActivity).showLoading(false);
        }
    }
}
