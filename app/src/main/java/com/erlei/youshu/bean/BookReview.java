package com.erlei.youshu.bean;

import android.support.annotation.Keep;

import java.util.List;

/**
 * Created by lll on 2018/1/28.
 * Email ： lllemail@foxmail.com
 * 书评
 */
@Keep
public class BookReview {

    private String content;
    private String createTime;
    private String score;
    private String id;
    private User sender;
    private Book book;
    private boolean isLike;
    private String likeNum;
    private List<Comment> comments;
    private BookList bookList;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * 网页并没有保存这个状态，每一次刷新都重置，这个状态不可靠
     * @return 是否喜欢过这个书评
     */
    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public BookList getBookList() {
        return bookList;
    }

    public void setBookList(BookList bookList) {
        this.bookList = bookList;
    }

    public String getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(String likeNum) {
        this.likeNum = likeNum;
    }
}
