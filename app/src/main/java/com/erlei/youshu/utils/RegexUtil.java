package com.erlei.youshu.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    public static final String img_url = "<img/s+[^>]*/s*src/s*=/s*([']?)(?<url>/S+)'?[^>]*>";
    public static final String img_url_src = "(?<=src/s*=/s*[/'/\"\"]?)(?<url>[http/:////]?[^'\"\"]+)";

    /**
     * 在字符串中获取第一个匹配的数字
     * @param input 输入字符串
     * @return 使用
     */
    public static int getInt(String input) {
        if (input == null) return 0;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            try {
                return Integer.parseInt(matcher.group());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}
