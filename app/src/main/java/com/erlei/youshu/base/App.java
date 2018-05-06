package com.erlei.youshu.base;

import com.blankj.utilcode.util.LogUtils;
import com.erlei.baselibrary.base.BaseApplication;
import com.erlei.baselibrary.base.Http;
import com.erlei.youshu.R;
import com.erlei.youshu.bean.Book;
import com.erlei.youshu.bean.HomeBean;
import com.erlei.youshu.parser.BooksParser;
import com.erlei.youshu.parser.HomeParser;
import com.erlei.youshu.parser.YouShuConverterFactory;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by lll on 2018/2/15.
 * Email ： lllemail@foxmail.com
 */
public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initLog();
        initParser();
    }

    private void initLog() {
        LogUtils.getConfig()
                .setConsoleSwitch(true)
                .setConsoleFilter(LogUtils.V)
                .setLogSwitch(true)
                .setStackDeep(1)
                .setGlobalTag(getString(R.string.app_name))
                .setFilePrefix("log");

    }

    private void initParser() {
//        YouShuConverterFactory.register(new TypeToken<Http<HomeBean>>(){}.getType().toString(),new HomeParser());
//        YouShuConverterFactory.register(new TypeToken<Http<List<Book>>>(){}.getType().toString(),new BooksParser());
    }
}
