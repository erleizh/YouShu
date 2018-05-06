package com.erlei.baselibrary.callback;


import com.erlei.baselibrary.base.Http;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by lll  on 2018/3/26 .
 * Email : lllemail@foxmail.com
 * Describe : 对网络请求观察者的进一步封装 ,
 */
public abstract class BaseObserver<T> extends DisposableObserver<T> {
    @Override
    public void onNext(T t) {
        if (t instanceof Http) {
            Http bean = (Http) t;
            if (bean.getCode() == 0) {
                onSuccess(t);
            } else {
                onFailure(bean.getCode(), bean.getMessage());
            }
        }
    }

    /**
     * 請求出現異常
     *
     * @param e 異常信息
     */
    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {

    }

    /**
     * 请求成功 , 服务器返回数据
     */
    public abstract void onSuccess(T t);

    /**
     * 请求成功 , 服务器返回错误数据
     *
     * @param code 错误码
     * @param msg  消息
     */
    public abstract void onFailure(int code, String msg);
}
