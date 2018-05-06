package com.erlei.youshu.bean;

import com.erlei.baselibrary.base.Http;

import java.util.List;

/**
 * Created by lll on 2018/2/15.
 * Email ： lllemail@foxmail.com
 * 首页数据
 */
public class HomeBean extends Http {

    private List<Category> category;
    private List<BookReview> bookReview;

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<Category> getCategory() {
        return this.category;
    }

    public void setBookReview(List<BookReview> bookReview) {
        this.bookReview = bookReview;
    }

    public List<BookReview> getBookReview() {
        return this.bookReview;
    }

    @Override
    public String toString() {
        return "HomeBean{" +
                "category=" + category +
                ", bookReview=" + bookReview +
                '}';
    }
}
