package com.erlei.youshu.ui.main;

import android.support.annotation.NonNull;

import com.erlei.baselibrary.base.Contract;
import com.erlei.baselibrary.base.Http;
import com.erlei.baselibrary.callback.SimpleObserver;
import com.erlei.baselibrary.util.TransformerUtil;
import com.erlei.youshu.Api;
import com.erlei.youshu.bean.Book;
import com.erlei.youshu.bean.Category;
import com.erlei.youshu.bean.HomeBean;

import java.util.List;
import java.util.Map;

public interface MainContract extends Contract {


    interface View extends Contract.View {

        void showHomeData(HomeBean homeBean);

        void showBooks(List<Book> data);
    }

    interface Model extends Contract.Model {

    }

    class Presenter extends Contract.Presenter<MainContract.View> {

        public Presenter(MainContract.View view) {
            super(view);
        }

        public void getHomeData() {
            add(Api.getInstance()
                    .getHome()
                    .compose(TransformerUtil.observableIoMain())
                    .subscribeWith(new SimpleObserver<Http<HomeBean>>() {
                        @Override
                        public void onSuccess(Http<HomeBean> o) {
                            super.onSuccess(o);
                            getView().showHomeData(o.getData());
                        }
                    }));
        }

        public void getBook(@NonNull Category category, @NonNull Map<String, String> options) {
            add(Api.getInstance()
                    .getBooks(category.getId(), options)
                    .compose(TransformerUtil.observableIoMain())
                    .subscribeWith(new SimpleObserver<Http<List<Book>>>() {
                        @Override
                        public void onSuccess(Http<List<Book>> o) {
                            super.onSuccess(o);
                            getView().showBooks(o.getData());
                        }
                    }));
        }

    }
}
