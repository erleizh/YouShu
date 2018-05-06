package com.erlei.youshu.ui.test;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.erlei.baselibrary.base.BaseFragment;
import com.erlei.baselibrary.base.Contract;
import com.erlei.youshu.R;
import com.erlei.youshu.bean.Book;
import com.erlei.youshu.bean.Category;
import com.erlei.youshu.bean.HomeBean;
import com.erlei.youshu.ui.main.MainContract;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yuyh.jsonviewer.library.JsonRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lll on 2018/2/15.
 * Email ： lllemail@foxmail.com
 * 接口测试
 */
public class ApiTestFragment extends BaseFragment {


    private interface Result {

        void onResult(String result);

    }

    private interface TestTask {

        void execute(Result result);
    }

    private static final ArrayMap<String, TestTask> sApis = new ArrayMap<>();
    private static final ArrayMap<String, TestTask> sResult = new ArrayMap<>();


    static {
        sApis.put("首页", result -> new MainContract.Presenter(new TestView(result)).getHomeData());
        sApis.put("分类", result -> new MainContract.Presenter(new TestView(result)).getBook(new Category("玄幻言情", "category/fantasylove"), new HashMap<>()));
    }

    private TextView mTvResult;
    private JsonRecyclerView mJsonView;
    private TestTaskAdapter mTaskAdapter;


    public static ApiTestFragment newInstance() {
        return new ApiTestFragment();
    }

    @Override
    protected void initView(View view) {
        //        mJsonView = view.findViewById(R.id.jsonView);
        mTvResult = view.findViewById(R.id.tvResult);
        RecyclerView mTestTaskList = view.findViewById(R.id.rvTestList);

        mTestTaskList.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        mTaskAdapter = new TestTaskAdapter(R.layout.item_api_test_task, new ArrayList<>(sApis.keySet()));
        mTaskAdapter.setOnItemClickListener((adapter, view1, position) -> sApis.get(mTaskAdapter.getItem(position)).execute(result -> mTvResult.setText(result)));
        mTestTaskList.setAdapter(mTaskAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_api_test;
    }

    @Nullable
    @Override
    public Contract.Presenter initPresenter() {
        return null;
    }

    private static class TestView implements Contract.View, MainContract.View {
        Gson mGson = new GsonBuilder().setPrettyPrinting().create();

        private final Result result;

        TestView(Result result) {
            this.result = result;
        }

        @Override
        public void showMessage(String msg) {

        }

        @Override
        public void showLoading(boolean show) {

        }

        @Override
        public Context getContext() {
            return null;
        }

        @Override
        public Contract.Presenter getPresenter() {
            return null;
        }

        @Override
        public void showHomeData(HomeBean homeBean) {
            result.onResult(getResult(homeBean));
        }

        @Override
        public void showBooks(List<Book> data) {
            result.onResult(getResult(data));
        }

        private String getResult(Object obj) {
            return mGson.toJson(obj);
        }
    }

    private class TestTaskAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        TestTaskAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.btn_api_name, item);
        }
    }
}
