package com.erlei.youshu;

import android.support.annotation.NonNull;

import com.erlei.youshu.parser.YouShuConverterFactory;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by lll on 2018/2/15.
 * Email ： lllemail@foxmail.com
 */
public class Api {
    private static YouShuApi api;

    static {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(Config.BASE_URL);
            builder.addConverterFactory(YouShuConverterFactory.create());
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                .addInterceptor(new GlobalParamsInterceptor());
        builder.client(client.build());
        Retrofit retrofit = builder.build();
        api = retrofit.create(YouShuApi.class);
    }

    public static YouShuApi getInstance() {
        return api;
    }

    private static class GlobalParamsInterceptor implements Interceptor {
        String userAgent = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Mobile Safari/537.36";

        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .header("User-Agent", userAgent)
                    .build();
            return chain.proceed(request);
        }
    }
}
