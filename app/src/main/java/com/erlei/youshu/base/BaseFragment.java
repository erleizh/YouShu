package com.erlei.youshu.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment<P extends Contract.Presenter> extends Fragment implements Contract.View {
    public P mPresenter;
    protected final String TAG = this.getClass().getName();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(this.getLayoutId(), container, false);
        initView(rootView);
        if (getPresenter() != null) getPresenter().onAttached();
        return rootView;
    }

    protected abstract void initView(View rootView);

    protected abstract int getLayoutId();

    @Nullable
    public abstract P initPresenter();

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showLoading(boolean show) {

    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (getPresenter() != null) getPresenter().onDetached();
    }

    @Override
    public Contract.Presenter getPresenter() {
        return mPresenter;
    }
}
