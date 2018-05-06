package com.erlei.youshu.bean;

import android.support.annotation.Keep;

import com.erlei.baselibrary.base.Http;

/**
 * Created by lll on 2018/1/28.
 * Email ： lllemail@foxmail.com
 * 针对书评的评论
 */
@Keep
public class Comment{

    private User sender;
    private User receiver;
    private String createTime;
    private String content;

    @Override
    public String toString() {
        return "Comment{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", createTime='" + createTime + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
