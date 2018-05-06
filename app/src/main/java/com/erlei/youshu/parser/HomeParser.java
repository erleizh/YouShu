package com.erlei.youshu.parser;

import com.erlei.baselibrary.base.Http;
import com.erlei.youshu.bean.Book;
import com.erlei.youshu.bean.BookReview;
import com.erlei.youshu.bean.Category;
import com.erlei.youshu.bean.HomeBean;
import com.erlei.youshu.bean.User;
import com.erlei.youshu.selector.Html;
import com.google.gson.reflect.TypeToken;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lll on 2018/2/15.
 * Email ： lllemail@foxmail.com
 */
public class HomeParser extends BaseParser<Http<HomeBean>> {
    @Override
    protected Http<HomeBean> convert(Html html) {
        Document document = html.getDocument();
        Http<HomeBean> bean = new Http<>();
        HomeBean homeBean = new HomeBean();
        homeBean.setCategory(parserCategory(document));
        Elements elements = parserNodes(document);
        homeBean.setBookReview(parserBookReviewList(elements.get(2)));
        bean.setData(homeBean);
        bean.setCode(0);
        return bean;
    }

    /**
     * 解析节点 ， [0]优书公告,[1]新书速递,[2]书单列表
     *
     * @param document 文档
     */
    private Elements parserNodes(Document document) {
        return document.select("div.sokk-body>div.container>div.row");
    }

    private List<BookReview> parserBookReviewList(Element element) {
        ArrayList<BookReview> list = new ArrayList<>();
        Elements elements = element.getElementsByClass("media ys-comments-left");
        for (Element comment : elements) {
            BookReview bookReview = new BookReview();
            elements = comment.getElementsByClass("hidden-xs ys-comments-user ys-comments-layout-x");
            Element userEle = elements.get(0);
            Elements img = userEle.getElementsByTag("img");
            Attributes attributes = img.get(0).attributes();
            String userIcon = attributes.get("src");

            String userId = userEle.attributes().get("href");
            User user = new User();
            user.setIcon(userIcon);
            user.setId(userId.substring(6, userId.lastIndexOf("/")));

            elements = comment.getElementsByClass("media-body");
            Element element1 = elements.get(0);
            String userName = element1.getElementsByTag("a").get(0).text();
            user.setName(userName);
            bookReview.setSender(user);

            Elements small = element1.getElementsByTag("small");
            Element element2 = small.get(0);
            //创建时间
            bookReview.setCreateTime(element2.textNodes().get(0).text());
            //星级
            bookReview.setScore(element2.select("span.num2star").get(0).text());

            element2 = small.get(1);
            element1 = element2.getElementsByTag("a").get(0);
            String s = element1.attributes().get("href");
            Book book = new Book();
            book.setId(s.substring(s.lastIndexOf("/") + 1, s.length()));
            String name = element1.text();
            book.setName(name.substring(1, name.length() - 1));
            bookReview.setBook(book);


            element2 = elements.get(0).getElementsByClass("ys-comments-message").get(0);
            bookReview.setContent(element2.getElementsByTag("p").text());

            Element element3 = elements.get(0).getElementsByAttribute("data-cid").get(0);
            String id = element3.attributes().get("data-cid");
            bookReview.setId(id);
            list.add(bookReview);
        }
        return list;
    }

    private List<Category> parserCategory(Document document) {
        try {
            ArrayList<Category> categories = new ArrayList<>();
            Elements select = document.select("div.index-category>div.container>div.row");
            Elements allElements = select.get(0).getElementsByClass("col-md-1 col-sm-2 col-lg-1 col-xs-2");
            for (Element element : allElements) {
                String text = element.text();
                Elements href = element.getElementsByAttribute("href");
                List<String> strings = href.eachAttr("href");
                Category category = new Category(text, strings.get(0));
                categories.add(category);
            }
            return categories;
        } catch (Exception e) {
            return null;
        }
    }
}
