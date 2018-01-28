package com.erlei.youshu.bean;

import com.erlei.baselibrary.base.BaseBean;

/**
 * Created by lll on 2018/1/28.
 * Email ： lllemail@foxmail.com
 * 针对书评的评论
 */
public class Comment extends BaseBean {

    private User sender;
    private User receiver;
    private String createTime;
    private String content;

}
