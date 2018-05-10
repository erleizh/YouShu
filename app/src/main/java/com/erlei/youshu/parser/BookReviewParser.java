package com.erlei.youshu.parser;

import com.erlei.youshu.bean.BookReview;
import com.erlei.youshu.bean.Http;
import com.erlei.youshu.selector.Html;

import java.util.ArrayList;
import java.util.List;


public class BookReviewParser extends BaseParser<Http<List<BookReview>>> {


    @Override
    protected Http<List<BookReview>> convert(Html html) {
        Http<List<BookReview>> http = new Http<>();
        ArrayList<BookReview> bookReviews = new ArrayList<>();


        BookReview bookReview = new BookReview();





        http.setData(bookReviews);
        return http;
    }

}
