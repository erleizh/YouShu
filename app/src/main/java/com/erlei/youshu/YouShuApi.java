package com.erlei.youshu;

import com.erlei.baselibrary.base.Http;
import com.erlei.youshu.bean.Book;
import com.erlei.youshu.bean.HomeBean;
import com.erlei.youshu.bean.User;
import com.erlei.youshu.parser.BaseParser;
import com.erlei.youshu.parser.BooksParser;
import com.erlei.youshu.parser.HomeParser;
import com.erlei.youshu.parser.Parser;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by lll on 2018/1/28.
 * Email ： lllemail@foxmail.com
 */
@SuppressWarnings("unused")
public interface YouShuApi {

    /**
     * 获取书籍列表
     *
     * @param category 分类
     * @param options  选项
     */
    @Parser(value = BooksParser.class)
    @GET("http://www.yousuu.com/{category}")
    Observable<Http<List<Book>>> getBooks(@Path(value = "category", encoded = true) String category, @QueryMap Map<String, String> options);

    /**
     * 获取首页数据
     */
    @Parser(value = HomeParser.class)
    @GET("http://www.yousuu.com/")
    Observable<Http<HomeBean>> getHome();

    /**
     * 获取用户详情
     *
     * @param id userId
     */
    @GET("user/{id}")
    Observable<Http<User>> getUser(@Path("id") String id);

    /**
     * 获取用户的所有评论
     *
     * @param id userId
     */
    @GET("user/{id}/comments")
    Flowable<String> getUserComments(@Path("id") String id);

    /**
     * 获取用户的所有积分
     *
     * @param id userId
     */
    @GET("user/{id}/manas")
    Flowable<String> getUserManas(@Path("id") String id);

    /**
     * 获取用户的书单
     *
     * @param id userId
     */
    @GET("user/{id}/booklist")
    Flowable<String> getUserBookList(@Path("id") String id);


    /**
     * 获取用户的所有粉丝
     *
     * @param id userId
     */
    @GET("user/{id}/fans")
    Flowable<String> getUserFans(@Path("id") String id);

    /**
     * 获取用户关注的书单
     *
     * @param id userId
     */
    @GET("user/{id}/followlist")
    Flowable<String> getUserFollowList(@Path("id") String id);

    /**
     * 获取用户关注的人
     *
     * @param id userId
     */
    @GET("user/{id}/follows")
    Flowable<String> getUserFollows(@Path("id") String id);

    /**
     * 获取书单
     *
     * @param id 书籍的 UUID
     */
    @GET("booklist/{bookUuid}")
    Flowable<String> getBookList(@Path("bookUuid") String id);

    /**
     * 获取书单
     * http://www.yousuu.com/ajax/getonecomment?render=true&cid=56c16122139a110e4cd19abd&bid=11748
     */
    @GET("ajax/getonecomment")
    Observable<String> getComment(@QueryMap Map<String, String> options);


}
