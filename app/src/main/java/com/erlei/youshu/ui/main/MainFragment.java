package com.erlei.youshu.ui.main;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.erlei.youshu.R;
import com.erlei.youshu.base.BaseFragment;
import com.erlei.youshu.bean.Book;
import com.erlei.youshu.bean.HomeBean;

import java.util.List;

/**
 * Created by lll on 2018/2/15.
 * Email ： lllemail@foxmail.com
 * 主界面
 */
public class MainFragment extends BaseFragment<MainContract.Presenter> implements MainContract.View {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected void initView(View rootView) {
        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Nullable
    @Override
    public MainContract.Presenter initPresenter() {
        return new MainContract.Presenter(this);
    }

    @Override
    public void showHomeData(HomeBean homeBean) {

    }

    @Override
    public void showBooks(List<Book> data) {

    }

}
