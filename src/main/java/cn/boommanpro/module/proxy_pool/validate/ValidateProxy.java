package cn.boommanpro.module.proxy_pool.validate;

import cn.boommanpro.module.proxy_pool.model.ProxyPool;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
@Slf4j
public class ValidateProxy {
    private static final String validateUrl = "http://icanhazip.com/";
    public static boolean validate(ProxyPool proxyPool) {
        OkHttpClient client = new OkHttpClient.Builder()
                .proxy(new Proxy(proxyPool.getType().convert2ProxyType(), new InetSocketAddress(proxyPool.getIp(), proxyPool.getPort()))).build();
        Request request = new Request.Builder()
                .url(validateUrl)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String  result=response.body().string();
            if (result.contains(proxyPool.getIp())) {
                return true;
            }
        } catch (IOException e) {

        }
        return false;
    }
}
