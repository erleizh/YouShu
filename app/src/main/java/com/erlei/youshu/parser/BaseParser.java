package com.erlei.youshu.parser;

import android.support.annotation.NonNull;

import com.blankj.utilcode.util.LogUtils;
import com.erlei.youshu.selector.Html;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;

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
            T convert = convert(new Html(uncompressToString(value.bytes(),charset(value).displayName())));
            LogUtils.iTag(TAG, "end 2parser" + "耗时 ： " + (System.currentTimeMillis() - startTime));
            LogUtils.json(TAG, convert.toString());
            return convert;
        } finally {
            value.close();
        }
    }

    private Charset charset(ResponseBody value) {
        MediaType contentType = value.contentType();
        return contentType != null ? contentType.charset(UTF_8) : UTF_8;
    }
    /**
     * 字节数组解压至string，可选择encoding配置
     */
    private static String uncompressToString(byte[] bytes, String encoding) {
        if (bytes == null || bytes.length == 0) {
            return "";
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString(encoding);
        } catch (IOException e) {
            System.out.println("gzip uncompress to string error");
        }
        return "";
    }

    protected abstract T convert(Html html) throws IOException;
}
