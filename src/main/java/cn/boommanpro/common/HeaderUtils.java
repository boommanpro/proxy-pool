package cn.boommanpro.common;

import okhttp3.Headers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class HeaderUtils {

    private static final List<Headers> headerList = new ArrayList<>();

    private static final Headers defaultHeaders = new Headers.Builder().
            add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36")
            .build();

    static {
        headerList.add(defaultHeaders);
    }


    public static Headers randomHeaders() {
        int random = new Random().nextInt(headerList.size());
        return headerList.get(random);
    }

    public static Headers defaultHeaders(){
        return defaultHeaders;
    }

}
