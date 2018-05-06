package com.erlei.youshu.parser;

import android.support.annotation.NonNull;

import com.blankj.utilcode.util.LogUtils;
import com.erlei.youshu.selector.Html;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import static okhttp3.internal.Util.UTF_8;

/**
 * Created by lll on 2018/2/15.
 * Email ： lllemail@foxmail.com
 */
public abstract class BaseParser<T> implements Converter<ResponseBody, T> {


    static final String TAG = "HtmlParser";

    @Override
    public T convert(@NonNull ResponseBody value) throws IOException {
        try {
            long startTime = System.currentTimeMillis();
            LogUtils.iTag(TAG, "start parser");
            T convert = convert(new Html(value.string()));
            LogUtils.iTag(TAG, "end 2parser" + "耗时 ： " + (System.currentTimeMillis() - startTime));
            LogUtils.json(TAG, convert.toString());
            return convert;
        } finally {
            value.close();
        }
    }

    protected abstract T convert(Html html) throws IOException;
}
