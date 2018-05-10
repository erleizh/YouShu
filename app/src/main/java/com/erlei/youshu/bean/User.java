package com.erlei.youshu.bean;

import android.support.annotation.Keep;

/**
 * Created by lll on 2018/1/28.
 * Email ： lllemail@foxmail.com
 */
@Keep
public class User {

    private String id;
    private String name;
    private String avatar;
    private String followNum;
    private String fansNum;
    private String followBookListNum;
    private UserBookReview<BookReview> bookReviews;
    private ListBean<BookList> bookList;
    private ListBean<BookList> followBookList;
    private ListBean<User> fans;
    private ListBean<User> followUser;
    private String signature;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFollowNum() {
        return followNum;
    }

    public void setFollowNum(String followNum) {
        this.followNum = followNum;
    }

    public String getFansNum() {
        return fansNum;
    }

    public void setFansNum(String fansNum) {
        this.fansNum = fansNum;
    }

    public String getFollowBookListNum() {
        return followBookListNum;
    }

    public void setFollowBookListNum(String followBookListNum) {
        this.followBookListNum = followBookListNum;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public UserBookReview<BookReview> getBookReviews() {
        return bookReviews;
    }

    public void setBookReviews(UserBookReview<BookReview> bookReviews) {
        this.bookReviews = bookReviews;
    }

    public ListBean<BookList> getBookList() {
        return bookList;
    }

    public void setBookList(ListBean<BookList> bookList) {
        this.bookList = bookList;
    }

    public ListBean<BookList> getFollowBookList() {
        return followBookList;
    }

    public void setFollowBookList(ListBean<BookList> followBookList) {
        this.followBookList = followBookList;
    }

    public ListBean<User> getFans() {
        return fans;
    }

    public void setFans(ListBean<User> fans) {
        this.fans = fans;
    }

    public ListBean<User> getFollowUser() {
        return followUser;
    }

    public void setFollowUser(ListBean<User> followUser) {
        this.followUser = followUser;
    }
}
