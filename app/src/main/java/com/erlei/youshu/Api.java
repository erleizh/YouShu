package com.erlei.youshu;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by lll on 2018/1/28.
 * Email ： lllemail@foxmail.com
 */
public interface Api {


    /**
     * 获取书籍列表
     *
     * @param category 分类
     * @param options  选项
     */
    @GET("category/{category}")
    Flowable<Object> getBooks(@Path("category") String category, @QueryMap Map<String, String> options);

    /**
     * 获取首页数据
     */
    @GET("http://www.yousuu.com/")
    Flowable<Object> getHome();

    /**
     * 获取用户详情
     *
     * @param id userId
     */
    @GET("user/{id}")
    Flowable<Object> getUser(@Path("id") String id);

    /**
     * 获取用户的所有评论
     *
     * @param id userId
     */
    @GET("user/{id}/comments")
    Flowable<Object> getUserComments(@Path("id") String id);

    /**
     * 获取用户的所有积分
     *
     * @param id userId
     */
    @GET("user/{id}/manas")
    Flowable<Object> getUserManas(@Path("id") String id);

    /**
     * 获取用户的书单
     *
     * @param id userId
     */
    @GET("user/{id}/booklist")
    Flowable<Object> getUserBookList(@Path("id") String id);


    /**
     * 获取用户的所有粉丝
     *
     * @param id userId
     */
    @GET("user/{id}/fans")
    Flowable<Object> getUserFans(@Path("id") String id);

    /**
     * 获取用户关注的书单
     *
     * @param id userId
     */
    @GET("user/{id}/followlist")
    Flowable<Object> getUserFollowList(@Path("id") String id);

    /**
     * 获取用户关注的人
     *
     * @param id userId
     */
    @GET("user/{id}/follows")
    Flowable<Object> getUserFollows(@Path("id") String id);

    /**
     * 获取书单
     *
     * @param id 书籍的 UUID
     */
    @GET("booklist/{bookUuid}")
    Flowable<Object> getBookList(@Path("bookUuid") String id);

    /**
     * 获取书单
     * http://www.yousuu.com/ajax/getonecomment?render=true&cid=56c16122139a110e4cd19abd&bid=11748
     */
    @GET("ajax/getonecomment")
    Flowable<Object> getComment(@QueryMap Map<String, String> options);


}
