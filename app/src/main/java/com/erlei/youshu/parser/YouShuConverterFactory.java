package com.erlei.youshu.parser;

import com.blankj.utilcode.util.LogUtils;
import com.erlei.youshu.selector.Html;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.annotations.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by lll on 2018/2/15.
 * Email ： lllemail@foxmail.com
 */
public class YouShuConverterFactory extends Converter.Factory {
    private static HashMap<String, BaseParser> sParser = new HashMap<>();

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        LogUtils.dTag("responseBodyConverter", type, annotations.toString(), retrofit);

        BaseParser baseParser = null;
        for (Annotation annotation : annotations) {
            LogUtils.dTag("responseBodyConverter", annotation.toString());
            if (annotation instanceof Parser) {
                String name = ((Parser) annotation).value().getName();
                baseParser = sParser.get(name);
                if (baseParser != null) break;
                try {
                    baseParser = (BaseParser) ((Parser) annotation).value().newInstance();
                    LogUtils.dTag("responseBodyConverter", "baseUrl" + retrofit);
                    sParser.put(name, baseParser);
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        if (baseParser == null) baseParser = new BaseParser() {
            @Override
            protected Object convert(Html html) {
                return html;
            }
        };
        LogUtils.dTag("responseBodyConverter", "ParserName" + baseParser.getClass().getName());
        return baseParser;
    }

    public static Converter.Factory create() {
        return new YouShuConverterFactory();
    }
}
