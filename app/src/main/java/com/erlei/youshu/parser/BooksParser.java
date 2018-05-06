package com.erlei.youshu.parser;

import com.blankj.utilcode.util.RegexUtils;
import com.erlei.baselibrary.base.Http;
import com.erlei.youshu.bean.Book;
import com.erlei.youshu.bean.User;
import com.erlei.youshu.selector.Html;
import com.erlei.youshu.selector.Selectable;
import com.erlei.youshu.utils.RegexUtil;

import java.util.ArrayList;
import java.util.List;

public class BooksParser extends BaseParser<Http<List<Book>>> {

    private static final String xpath_books = "/html/body/div[@class='sokk-body']/div[@class='container']/div[@class='row']/div[2]/div[@class='categorymain']/div[@class='books']/div[@class='row']/div[@class='col-md-6 col-sm-12']";
    private static final String xpath_author = "/div[@class='col-md-6 col-sm-12']/div/div/div[@class='bd booklist-subject']/div[@class='abstract']/text(1)";
    private static final String xpath_wordNumber = "/div[@class='col-md-6 col-sm-12']/div/div/div[@class='bd booklist-subject']/div[@class='abstract']/text(2)";
    private static final String xpath_lastUpdate = "/div[@class='col-md-6 col-sm-12']/div/div/div[@class='bd booklist-subject']/div[@class='abstract']/text(3)";
    private static final String xpath_score = "/div[@class='col-md-6 col-sm-12']/div/div/div[@class='bd booklist-subject']/div[@class='abstract']/span[@class='num2star']/text()";
    private static final String xpath_name = "/div[@class='col-md-6 col-sm-12']/div/div/div[@class='bd booklist-subject']/div[@class='title']/allText()";
    private static final String xpath_id = "/div[@class='col-md-6 col-sm-12']/div/div/div[@class='bd booklist-subject']/div[@class='title']/a";
    private static final String xpath_cover = "/div[@class='col-md-6 col-sm-12']/div/div/div[@class='bd booklist-subject']/div[@class='post']/a/img/@src";
    private static final String xpath_reviewNumber = "/div[@class='col-md-6 col-sm-12']/div/div/div[@class='bd booklist-subject']/div[@class='rating']/span[3]/text()";

    @Override
    protected Http<List<Book>> convert(Html html) {
        Http<List<Book>> http = new Http<>();
        ArrayList<Book> books = new ArrayList<>();
        List<Selectable> nodes = html.xpath(xpath_books).nodes();
        for (Selectable node : nodes) {
            Book book = new Book();
            User user = new User();
            String name = node.xpath(xpath_author).get();
            user.setName(name);
            book.setAuthor(user);
            String name1 = node.xpath(xpath_name).get();
            book.setName(name1);
            book.setWordNumber(node.xpath(xpath_wordNumber).get());
            book.setLastUpdate(node.xpath(xpath_lastUpdate).get());
            book.setScore(node.xpath(xpath_score).get());
            book.setId(node.xpath(xpath_id).links().get());
            book.setCover(node.xpath(xpath_cover).get());
            String s = node.xpath(xpath_reviewNumber).get();
            book.setTotalBookReviewNumber(RegexUtil.getInt(s));
            books.add(book);
        }
        http.setData(books);
        http.setCode(0);
        return http;
    }
}
