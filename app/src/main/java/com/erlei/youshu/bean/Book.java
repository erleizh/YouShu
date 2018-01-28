package com.erlei.youshu.bean;

import com.erlei.baselibrary.base.BaseBean;

import java.util.List;

/**
 * Created by lll on 2018/1/28.
 * Email ： lllemail@foxmail.com
 */
public class Book extends BaseBean {
    private String id;
    private String name;
    private String desc;
    private String cover;
    private User author;
    private String score;
    List<BookReview> bookReviews;
    private int totalBookReviewNumber;
    private int chapterNumber;
    private String lastChapter;
    private String from;
    private String wordNumber;
}
