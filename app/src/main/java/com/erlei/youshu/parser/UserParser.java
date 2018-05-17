package com.erlei.youshu.parser;

import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;
import com.erlei.youshu.bean.Book;
import com.erlei.youshu.bean.BookList;
import com.erlei.youshu.bean.BookReview;
import com.erlei.youshu.bean.Http;
import com.erlei.youshu.bean.ListBean;
import com.erlei.youshu.bean.User;
import com.erlei.youshu.bean.UserBookReview;
import com.erlei.youshu.selector.Html;
import com.erlei.youshu.selector.Selectable;
import com.erlei.youshu.utils.RegexUtil;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class UserParser extends BaseParser<Http<User>> {

    private static final String xpath_icon = "/html/body/div[1]/div[1]/div/div/div[1]/div/img/@src";
    private static final String xpath_user_name = "/html/body/div[1]/div[1]/div/div/div[1]/div/h4/text()";
    private static final String xpath_signature = "/html/body/div[1]/div[1]/div/div/div[2]/div/div/p/text()";
    private static final String xpath_follow_book_list_num = "/html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/a/strong/text()";
    private static final String xpath_fans_num = "/html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[2]/a/strong/text()";
    private static final String xpath_follow_num = "/html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[3]/a/strong/text()";

    //在动态，积分，书单，粉丝，关注书单，关注 中找出选中的那个tab
    private static final String xpath_active_tab = "/html/body/div[1]/div[2]/div/div[2]/ul[1]/li[@class~='active']/allText()";
    private static final String xpath_page_index = "/html/body/div[1]/div[2]/div/div[2]/ul[2]/li[@class='active']/a/text()";
    //书数据
    private static final String xpath_book_author = "/div/div[@class='mod']/div[@class='bd booklist-subject']/div[@class='abstract']/text(1)";
    private static final String xpath_book_wordNumber = "/div/div[@class='mod']/div[@class='bd booklist-subject']/div[@class='abstract']/text(2)";
    private static final String xpath_book_lastUpdate = "/div/div[@class='mod']/div[@class='bd booklist-subject']/div[@class='abstract']/text(3)";
    private static final String xpath_book_review_score = "/div/div[@class='mod']/div[@class='bd booklist-subject']/div[@class='abstract']/span[@class='num2star']/text()";
    private static final String xpath_book_name = "/div/div[@class='mod']/div[@class='bd booklist-subject']/div[@class='title']/allText()";
    private static final String xpath_book_id = "/div/div[@class='mod']/div[@class='bd booklist-subject']/div[@class='title']/a";
    private static final String xpath_book_cover = "/div/div[@class='mod']/div[@class='bd booklist-subject']/div[@class='post']/a/img/@src";

    //书评数据
    private static final String xpath_book_review_list = "/html/body/div[1]/div[2]/div/div[2]/div[@class~='booklist-item']";
    private static final String xpath_book_review_number = "/div/div[@class='mod']/div[@class='bd booklist-subject']/div[@class='rating']/span[3]/text()";
    private static final String xpath_book_review_content = "/div/div[@class='mod']/div[@class='ft clearfix']/blockquote/span/span/text()";
    private static final String xpath_book_review_create_time = "/div/div[@class='mod']/div[@class='ft clearfix']/time/span/@title";
    private static final String xpath_book_review_like_num = "/div/div[@class='mod']/div[@class='ft clearfix']/div[@class='booklist-item-opt']/div/button[1]/span/text()";
    private static final String xpath_book_review_like = "/div/div[@class='mod']/div[@class='ft clearfix']/div[@class='booklist-item-opt']/div/button[1]/@class~='btn btn-danger'";
    private static final String xpath_book_review_id = "/div/div[@class='mod']/div[@class='ft clearfix']/div[@class='booklist-item-opt']/div/@data-cid";
    private static final String xpath_book_review_next_page_key = "/html/body/div[1]/div[2]/div/div[2]/a/@onclick";
    private static final String xpath_book_review_book_list_name = "/div/div[@class='mod']/div[@class='ft clearfix']/blockquote/span/small/a/text()";
    private static final String xpath_book_review_book_list_id = "/div/div[@class='mod']/div[@class='ft clearfix']/blockquote/span/small/a/@href";

    //书单数据（用户自有书单，用户关注书单）
    private static final String xpath_book_list = "/html/body/div[1]/div[2]/div/div[2]/table[@class='table shudanlist']/tbody/";
    private static final String xpath_book_list_praise = "/tr[@class='list-item']/td[1]/a/small/text()";
    private static final String xpath_book_list_name = "/tr[@class='list-item']/td[2]/h4/a/text()";
    private static final String xpath_book_list_id = "/tr[@class='list-item']/td[2]/h4/a/@href";
    private static final String xpath_book_list_book_num = "/tr[@class='list-item']/td[3]/p[1]/text()";
    private static final String xpath_book_list_follow_num = "/tr[@class='list-item']/td[5]/p[1]/text()";
    private static final String xpath_book_list_last_update = "/tr[@class='list-item']/td[4]/p[1]/text()";

    //用户数据（关注用户的人，用户关注的人）
    private static final String xpath_fans_list = "/html/body/div[1]/div[2]/div/div[2]/div[2]/div[@class='col-md-6 col-lg-4 col-sm-12']";
    private static final String xpath_fans_name = "/div[@class='col-md-6 col-lg-4 col-sm-12']/div/div/div/div/a/span/text()";
    private static final String xpath_fans_avatar = "/div[@class='col-md-6 col-lg-4 col-sm-12']/div/div/div/a[2]/img/@src";
    private static final String xpath_fans_id = "/div[@class='col-md-6 col-lg-4 col-sm-12']/div/div/div/div/a/@href";

@Override
protected Http<User> convert(Html html) {
    Http<User> http = new Http<>();
    User user = new User();
    http.setData(user);

    //用戶信息
    user.setAvatar(html.xpath(xpath_icon).get());
    user.setName(html.xpath(xpath_user_name).get());
    user.setSignature(html.xpath(xpath_signature).get());
    user.setFollowBookListNum(html.xpath(xpath_follow_book_list_num).get());
    user.setFansNum(html.xpath(xpath_fans_num).get());
    user.setFollowNum(html.xpath(xpath_follow_num).get());

    String s = html.xpath(xpath_active_tab).get();
    if (!TextUtils.isEmpty(s)) {
        switch (s) {
            case "动态":
                user.setBookReviews(new BookReviewParser().parserBookReviewList(html));
                break;
            case "积分":

                break;
            case "书单":
                user.setBookList(new BookListParser().parserBookList(html));
                break;
            case "粉丝":
                user.setFans(new FollowedUserParser().parserUser(html));
                break;
            case "关注书单":
                user.setFollowBookList(new BookListParser().parserBookList(html));
                break;
            case "关注":
                user.setFollowUser(new FollowedUserParser().parserUser(html));
                break;
        }
    }
    return http;
}

    /**
     * 解析用戶书评
     */
    private class BookReviewParser {
        private UserBookReview<BookReview> parserBookReviewList(Html html) {
            long millis = System.currentTimeMillis();
            List<Selectable> nodes = html.xpath(xpath_book_review_list).nodes();
            LogUtils.dTag(TAG, "nodes : " + String.valueOf(System.currentTimeMillis() - millis));
            UserBookReview<BookReview> userBookReview = new UserBookReview<>();
            ArrayList<BookReview> bookReviews = new ArrayList<>();
            userBookReview.setList(bookReviews);
            userBookReview.setPage(1);
            millis = System.currentTimeMillis();
            userBookReview.setNext(html.xpath(xpath_book_review_next_page_key).regex("\\d+").get());
            LogUtils.dTag(TAG, "setNext : " + String.valueOf(System.currentTimeMillis() - millis));
            millis = System.currentTimeMillis();
            for (Selectable node : nodes) {
                BookReview bookReview = new BookReview();
                bookReview.setBook(parserBook(node));
                bookReview.setContent(node.xpath(xpath_book_review_content).get());
                bookReview.setBookList(parserBookList(node));
                bookReview.setCreateTime(node.xpath(xpath_book_review_create_time).get());
                //bookReview.setLike(node.xpath(xpath_book_review_like).match());//网页并没有保存这个状态，每一次刷新都重置
                bookReview.setLikeNum(node.xpath(xpath_book_review_like_num).get());
                bookReview.setScore(node.xpath(xpath_book_review_score).get());
                bookReview.setId(node.xpath(xpath_book_review_id).get());
                bookReviews.add(bookReview);
            }
            LogUtils.dTag(TAG, "bookReviewList : " + String.valueOf(System.currentTimeMillis() - millis));
            return userBookReview;
        }


        private BookList parserBookList(Selectable node) {
            BookList bookList = new BookList();
            bookList.setName(node.xpath(xpath_book_review_book_list_name).get());
            bookList.setId(node.xpath(xpath_book_review_book_list_id).get());
            return bookList;
        }

        private Book parserBook(Selectable node) {
            User user = new User();
            user.setName(node.xpath(xpath_book_author).get());

            Book book = new Book();
            book.setAuthor(user);
            book.setName(node.xpath(xpath_book_name).get());
            book.setWordNumber(node.xpath(xpath_book_wordNumber).get());
            book.setLastUpdate(node.xpath(xpath_book_lastUpdate).get());
            book.setId(node.xpath(xpath_book_id).links().get());
            book.setCover(node.xpath(xpath_book_cover).get());
            book.setTotalBookReviewNumber(RegexUtil.getInt(node.xpath(xpath_book_review_number).get()));
            return book;
        }
    }


    /**
     * 解析用戶书单或关注的书单
     */
    private class BookListParser {
        ListBean<BookList> parserBookList(Html html) {
            ListBean<BookList> bookLists = new ListBean<>();
            ArrayList<BookList> lists = new ArrayList<>();
            bookLists.setList(lists);
            bookLists.setPage(RegexUtil.getInt(html.xpath(xpath_page_index).get()));
            List<Selectable> nodes = html.xpath(xpath_book_list).nodes();
            for (Selectable node : nodes) {
                BookList bookList = new BookList();
                bookList.setPraiseNum(node.xpath(xpath_book_list_praise).get());
                bookList.setId(node.xpath(xpath_book_list_id).get());
                bookList.setName(node.xpath(xpath_book_list_name).get());
                bookList.setBookNum(node.xpath(xpath_book_list_book_num).get());
                bookList.setFollowNum(node.xpath(xpath_book_list_follow_num).get());
                bookList.setLastUpdate(node.xpath(xpath_book_list_last_update).get());
                lists.add(bookList);
            }
            return bookLists;
        }
    }

    /**
     * 解析該用戶的粉絲，和該用戶關注的人
     */
    private class FollowedUserParser {
        ListBean<User> parserUser(Html html) {
            ListBean<User> bean = new ListBean<>();
            ArrayList<User> lists = new ArrayList<>();
            bean.setList(lists);
            bean.setPage(RegexUtil.getInt(html.xpath(xpath_page_index).get()));
            List<Selectable> nodes = html.xpath(xpath_fans_list).nodes();
            for (Selectable node : nodes) {
                User user = new User();
                user.setAvatar(node.xpath(xpath_fans_avatar).get());
                user.setName(node.xpath(xpath_fans_name).get());
                user.setId(node.xpath(xpath_fans_id).get());
                lists.add(user);
            }
            return bean;
        }
    }


}
