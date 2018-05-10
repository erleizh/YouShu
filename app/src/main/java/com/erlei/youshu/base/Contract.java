package com.erlei.youshu.base;

import android.content.Context;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * Created by lll on 2018/5/7 .
 * Email : lllemail@foxmail.com
 * Describe : 基础契约类
 */
@SuppressWarnings({"unchecked", "WeakerAccess", "unused"})
public interface Contract {

    interface View<P extends Contract.Presenter> {

        /**
         * 使用Toast显示一条消息
         *
         * @param msg 消息文本
         */
        void showMessage(String msg);

        /**
         * 是否显示 Loading 对话框
         *
         * @param show 是否显示
         */
        void showLoading(boolean show);

        /**
         * @return 返回上下文
         */
        Context getContext();


        P getPresenter();

    }

    interface Model {

    }

    abstract class Presenter<V extends Contract.View> {
        protected V mView;
        protected final String TAG = this.getClass().getName();
        protected CompositeDisposable mCompositeSubscription = new CompositeDisposable();

        public Presenter(V view) {
            mView = view;
        }

        public V getView() {
            return mView;
        }

        public Context getContext() {
            return mView.getContext();
        }

        public void add(@NonNull Disposable d) {
            mCompositeSubscription.add(d);
        }

        public void onAttached() {
        }

        public void onDetached() {
            mCompositeSubscription.dispose();
        }

    }
}
