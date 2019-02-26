package cn.boommanpro.module.proxy_pool.parse;

import cn.boommanpro.common.HeaderUtils;
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
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

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



        OkHttpClient client =  new OkHttpClient.Builder()
                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("116.209.59.30", 9999))).build();

        Headers headers = new Headers.Builder()
                .addAll(HeaderUtils.defaultHeaders())
                .add("Host", "www.xicidaili.com")
                .build();

        Request request = new Request.Builder().headers(headers)
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String  result=response.body().string();
            XiciModel xiciModel = XiciParseUtil.parseModel(result);
            List<ProxyPool> proxyPoolList = XiciParseUtil.parse2ProxyPoolList(xiciModel);
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
        XiciModel xiciModel = XiciParseUtil.parseModel(htmlContent);
        List<ProxyPool> proxyPoolList = XiciParseUtil.parse2ProxyPoolList(xiciModel);
        for (ProxyPool proxyPool : proxyPoolList) {
            boolean validate = ValidateProxy.validate(proxyPool);
            System.out.println(proxyPool+"校验结果"+validate);
        }

    }


//    ProxyPool(id=10, ip=116.209.59.30, port=9999, country=湖北仙桃, anonymity=HIGH, type=HTTP)校验结果true

    @Test
    public void validate(){
        ProxyPool proxyPool = new ProxyPool();
        proxyPool.setIp("116.209.59.30");
        proxyPool.setPort(9999);
        proxyPool.setType(HttpType.HTTP);
        boolean validate = ValidateProxy.validate(proxyPool);
        System.out.println(proxyPool+"校验结果"+validate);
    }
}