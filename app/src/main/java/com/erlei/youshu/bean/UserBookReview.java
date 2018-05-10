package com.erlei.youshu.bean;

import android.support.annotation.Keep;

@Keep
public class UserBookReview<T> extends ListBean<T> {


    private String next;

    /**
     * @return 获取下一页数据的必须参数
     */
    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
