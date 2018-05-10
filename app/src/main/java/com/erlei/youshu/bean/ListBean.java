package com.erlei.youshu.bean;

import android.support.annotation.Keep;

import java.util.List;

@Keep
public class ListBean<T>{


    protected String total;
    protected List<T> list;
    protected int page;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
