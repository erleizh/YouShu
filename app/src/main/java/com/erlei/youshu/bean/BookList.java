package com.erlei.youshu.bean;

import android.support.annotation.Keep;

/**
 * Created by lll on 2018/5/7 .
 * Email : lllemail@foxmail.com
 * Describe : 书单
 */
@Keep
public class BookList {

    private String name;
    private String id;
    private String praiseNum;
    private String bookNum;
    private String followNum;
    private String lastUpdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(String praiseNum) {
        this.praiseNum = praiseNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setFollowNum(String followNum) {
        this.followNum = followNum;
    }

    public String getFollowNum() {
        return followNum;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }
}
