package com.erlei.youshu.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.erlei.baselibrary.base.Contract;
import com.jude.swipbackhelper.SwipeBackHelper;

/**
 * Created by lll on 2018/3/22.
 * Email : lllemail@foxmail.com
 */
public abstract class BaseActivity<P extends Contract.Presenter> extends AppCompatActivity implements Contract.View {

    public P mPresenter;
    protected final String TAG = this.getClass().getName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = getLayoutInflater().inflate(this.getLayoutId(), null, false);
        rootView.setFitsSystemWindows(true);
        this.setContentView(rootView);
        SwipeBackHelper.onCreate(this);
        initSwipeBack();
        mPresenter = initPresenter();
        initView(rootView);
        if (getPresenter() != null) getPresenter().onAttached();
    }

    private void initSwipeBack() {
        SwipeBackHelper.getCurrentPage(this)//get current instance
                .setSwipeBackEnable(true)//on-off
                .setSwipeEdge(200)//set the touch area。200 mean only the left 200px of screen can touch to begin swipe.
                .setSwipeEdgePercent(0.2f)//0.2 mean left 20% of screen can touch to begin swipe.
                .setSwipeSensitivity(0.5f)//sensitiveness of the gesture。0:slow  1:sensitive
                .setScrimColor(Color.BLACK)//color of Scrim below the activity
                .setSwipeRelateEnable(true)//是否与下一级activity联动(微信效果)。默认关
                .setClosePercent(0.8f)//close activity when swipe over this
                .setSwipeRelateOffset(500)//the Offset of following Activity when setSwipeRelateEnable(true)
                .setDisallowInterceptTouchEvent(false);//your view can hand the events first.default false;

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLoading(false);
        if (getPresenter() != null) getPresenter().onDetached();
        SwipeBackHelper.onDestroy(this);
    }

    protected abstract int getLayoutId();

    protected abstract void initView(View rootView);

    @Nullable
    public abstract P initPresenter();

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void showLoading(boolean show) {
    }
}
