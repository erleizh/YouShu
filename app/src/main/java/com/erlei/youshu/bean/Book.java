package com.erlei.youshu.bean;

import android.support.annotation.Keep;

import java.util.List;
import java.util.Objects;

/**
 * Created by lll on 2018/1/28.
 * Email ： lllemail@foxmail.com
 */
@Keep
public class Book {
    private String id;
    private String name;
    private String desc;
    private String cover;
    private User author;
    private String score;
    List<BookReview> bookReviews;
    private int totalBookReviewNumber;
    private int chapterNumber;
    private String lastChapter;
    private String lastUpdate;
    private String from;
    private String wordNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public List<BookReview> getBookReviews() {
        return bookReviews;
    }

    public void setBookReviews(List<BookReview> bookReviews) {
        this.bookReviews = bookReviews;
    }

    public int getTotalBookReviewNumber() {
        return totalBookReviewNumber;
    }

    public void setTotalBookReviewNumber(int totalBookReviewNumber) {
        this.totalBookReviewNumber = totalBookReviewNumber;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getWordNumber() {
        return wordNumber;
    }

    public void setWordNumber(String wordNumber) {
        this.wordNumber = wordNumber;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return totalBookReviewNumber == book.totalBookReviewNumber &&
                chapterNumber == book.chapterNumber &&
                Objects.equals(id, book.id) &&
                Objects.equals(name, book.name) &&
                Objects.equals(desc, book.desc) &&
                Objects.equals(cover, book.cover) &&
                Objects.equals(author, book.author) &&
                Objects.equals(score, book.score) &&
                Objects.equals(bookReviews, book.bookReviews) &&
                Objects.equals(lastChapter, book.lastChapter) &&
                Objects.equals(lastUpdate, book.lastUpdate) &&
                Objects.equals(from, book.from) &&
                Objects.equals(wordNumber, book.wordNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, desc, cover, author, score, bookReviews, totalBookReviewNumber, chapterNumber, lastChapter, lastUpdate, from, wordNumber);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", cover='" + cover + '\'' +
                ", author=" + author +
                ", score='" + score + '\'' +
                ", bookReviews=" + bookReviews +
                ", totalBookReviewNumber=" + totalBookReviewNumber +
                ", chapterNumber=" + chapterNumber +
                ", lastChapter='" + lastChapter + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", from='" + from + '\'' +
                ", wordNumber='" + wordNumber + '\'' +
                '}';
    }
}
