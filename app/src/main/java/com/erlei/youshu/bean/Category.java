package com.erlei.youshu.bean;

import android.support.annotation.Keep;

/**
 * Created by lll on 2018/2/15.
 * Email ： lllemail@foxmail.com
 * 小说分类
 */
@Keep
public class Category {
    private String name;
    private String id;

    public Category(String name, String id) {
        this.name = name;
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        return id != null ? id.equals(category.id) : category.id == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
