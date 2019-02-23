package cn.boommanpro.module.proxy_pool.parse;

import cn.boommanpro.module.proxy_pool.model.ProxyPool;
import cn.boommanpro.module.proxy_pool.type.AnonymityType;
import cn.boommanpro.module.proxy_pool.type.HttpType;
import me.ghui.fruit.Fruit;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class XiciParseUtil {

    private static final String HIGH = "高匿";
    private static final String HTTPS = "HTTPS";

    public static List<ProxyPool> parse2ProxyPoolList(String context) {
        XiciModel xiciModel = new Fruit().fromHtml(context, XiciModel.class);

        List<XiciModel.XiciRow> pageData = xiciModel.getPageData();
        return pageData.stream().map(xiciRow -> {
            ProxyPool current = new ProxyPool();
            current.setIp(xiciRow.getIp());
            current.setPort(xiciRow.getPort());
            current.setCountry(xiciRow.getCountry());
            current.setAnonymity(convertAnonymity(xiciRow.getAnonymity()));
            current.setType(convertType(xiciRow.getType()));
            return current;
        }).collect(Collectors.toList());
    }

    private static AnonymityType convertAnonymity(String anonymity){
        if (HIGH.equals(anonymity)) {
            return AnonymityType.HIGH;
        }
        return AnonymityType.CLEAR;
    }

    private static HttpType convertType(String type){
        if (HTTPS.equals(type)) {
            return HttpType.HTTPS;
        }
        return HttpType.HTTP;
    }
}
