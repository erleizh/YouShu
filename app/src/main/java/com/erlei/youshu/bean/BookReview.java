package com.erlei.youshu.bean;

import com.erlei.baselibrary.base.BaseBean;

import java.util.List;

/**
 * Created by lll on 2018/1/28.
 * Email ： lllemail@foxmail.com
 * 书评
 */
public class BookReview extends BaseBean {

    private String content;
    private String createTime;
    private String score;
    private User sender;
    private Book book;
    private boolean isLike;
    private List<Comment> comments;
}
