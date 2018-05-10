package com.erlei.youshu.ui.personal;

import com.erlei.youshu.Api;
import com.erlei.youshu.base.Contract;
import com.erlei.youshu.bean.Http;
import com.erlei.youshu.bean.User;
import com.erlei.youshu.callback.SimpleObserver;
import com.erlei.youshu.utils.TransformerUtil;

public interface PersonalContract extends Contract {


    interface View extends Contract.View {

        void getUserBookReview(User user);

        void showUserBookList(User user);

        void showUserFans(User user);

        void showUserFollowBookList(User user);

        void showUserFollows(User user);

        void showUserManas(User user);
    }

    interface Model extends Contract.Model {

    }

    class Presenter extends Contract.Presenter<PersonalContract.View> {

        public Presenter(PersonalContract.View view) {
            super(view);
        }

        public void getUserBookReview(String userId) {
            add(Api.getInstance()
                    .getUserBookReview(userId)
                    .compose(TransformerUtil.observableIoMain())
                    .subscribeWith(new SimpleObserver<Http<User>>() {
                        @Override
                        public void onSuccess(Http<User> o) {
                            super.onSuccess(o);
                            getView().getUserBookReview(o.getData());
                        }
                    }));
        }

        public void getUserBookReview1(String userId) {
            add(Api.getInstance()
                    .getUserBookReview1(userId)
                    .compose(TransformerUtil.observableIoMain())
                    .subscribeWith(new SimpleObserver<Http<User>>() {
                        @Override
                        public void onSuccess(Http<User> o) {
                            super.onSuccess(o);
                            getView().getUserBookReview(o.getData());
                        }
                    }));
        }

        public void getUserBookList(String userId) {
            add(Api.getInstance()
                    .getUserBookList(userId)
                    .compose(TransformerUtil.observableIoMain())
                    .subscribeWith(new SimpleObserver<Http<User>>() {
                        @Override
                        public void onSuccess(Http<User> o) {
                            super.onSuccess(o);
                            getView().showUserBookList(o.getData());
                        }
                    }));
        }

        public void getUserFans(String userId) {
            add(Api.getInstance()
                    .getUserFans(userId)
                    .compose(TransformerUtil.observableIoMain())
                    .subscribeWith(new SimpleObserver<Http<User>>() {
                        @Override
                        public void onSuccess(Http<User> o) {
                            super.onSuccess(o);
                            getView().showUserFans(o.getData());
                        }
                    }));
        }

        public void getUserFollowList(String userId) {
            add(Api.getInstance()
                    .getUserFollowList(userId)
                    .compose(TransformerUtil.observableIoMain())
                    .subscribeWith(new SimpleObserver<Http<User>>() {
                        @Override
                        public void onSuccess(Http<User> o) {
                            super.onSuccess(o);
                            getView().showUserFollowBookList(o.getData());
                        }
                    }));
        }

        public void getUserManas(String userId) {
            add(Api.getInstance()
                    .getUserManas(userId)
                    .compose(TransformerUtil.observableIoMain())
                    .subscribeWith(new SimpleObserver<Http<User>>() {
                        @Override
                        public void onSuccess(Http<User> o) {
                            super.onSuccess(o);
                            getView().showUserManas(o.getData());
                        }
                    }));
        }

        public void getUserFollows(String userId) {
            add(Api.getInstance()
                    .getUserFollows(userId)
                    .compose(TransformerUtil.observableIoMain())
                    .subscribeWith(new SimpleObserver<Http<User>>() {
                        @Override
                        public void onSuccess(Http<User> o) {
                            super.onSuccess(o);
                            getView().showUserFollows(o.getData());
                        }
                    }));
        }

    }

}
