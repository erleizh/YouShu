package com.erlei.baselibrary.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by lll on 2018/1/27.
 * Email ： lllemail@foxmail.com
 */
public abstract class BasePresenter<V> {

    protected V mView;

    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void setView(V v){

    }
    public abstract void onAttached();

    public void onDetached() {
        mCompositeDisposable.dispose();
    }
}
