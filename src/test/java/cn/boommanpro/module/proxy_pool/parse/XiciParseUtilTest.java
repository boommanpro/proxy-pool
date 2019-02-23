package cn.boommanpro.module.proxy_pool.parse;

import cn.boommanpro.module.proxy_pool.model.ProxyPool;
import cn.boommanpro.module.proxy_pool.type.HttpType;
import cn.boommanpro.module.proxy_pool.validate.ValidateProxy;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class XiciParseUtilTest {



    /**
     * 解析高匿代理第一页
     * https://www.xicidaili.com/nn/1
     */

    @Test
    public void requestTest() throws IOException{
        String url = "https://www.xicidaili.com/nn/1";

        OkHttpClient client = new OkHttpClient();

        Headers headers=new Headers.Builder()
                .add("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36")
                .add("Host","www.xicidaili.com")
                .build();

        Request request = new Request.Builder().headers(headers)
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String  result=response.body().string();
            List<ProxyPool> proxyPoolList = XiciParseUtil.parse2ProxyPoolList(result);
            for (ProxyPool proxyPool : proxyPoolList) {
                boolean validate = ValidateProxy.validate(proxyPool);
                System.out.println(proxyPool+"校验结果"+validate);
            }
        }
    }


    @Test
    public void parse2ProxyPoolList() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("parse/XiciProxy.html");
        File file = new File(classPathResource.getURI());
        byte[] fileContent = new byte[(int)file.length()];
        FileInputStream in = new FileInputStream(file);
        in.read(fileContent);
        in.close();
        String htmlContent = new String(fileContent);
        List<ProxyPool> proxyPoolList = XiciParseUtil.parse2ProxyPoolList(htmlContent);
        for (ProxyPool proxyPool : proxyPoolList) {
            boolean validate = ValidateProxy.validate(proxyPool);
            System.out.println(proxyPool+"校验结果"+validate);
        }

    }


    @Test
    public void validate(){
        ProxyPool proxyPool = new ProxyPool();
        proxyPool.setIp("116.209.58.17");
        proxyPool.setPort(9999);
        proxyPool.setType(HttpType.HTTP);
        boolean validate = ValidateProxy.validate(proxyPool);
        System.out.println(proxyPool+"校验结果"+validate);
    }
}