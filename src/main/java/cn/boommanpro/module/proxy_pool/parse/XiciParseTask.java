package cn.boommanpro.module.proxy_pool.parse;

import cn.boommanpro.common.HeaderUtils;
import cn.boommanpro.common.StringUtils;
import cn.boommanpro.module.proxy_pool.dao.ProxyPoolMapper;
import cn.boommanpro.module.proxy_pool.model.ProxyPool;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
@Component
@Slf4j
public class XiciParseTask {

    @Autowired
    private ProxyPoolMapper proxyPoolMapper;


    public void start(){
        int startPage = 1;
        String url = "https://www.xicidaili.com/nn/";

        XiciModel xiciModel=null;
        boolean canNext = true;
        while (canNext){
            String requestUrl = url + startPage;
            String result = doRequest(requestUrl);
            if (StringUtils.isNullOrEmpty(result)) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    log.error("访问西刺代理网址:{},出错,等待10000毫秒后重试",requestUrl);
                    e.printStackTrace();
                }
                continue;
            }
            xiciModel= XiciParseUtil.parseModel(result);
            if (xiciModel == null) {
                log.error("xiciModel == null content: {}",result);
                continue;
            }
            List<ProxyPool> proxyPoolList = XiciParseUtil.parse2ProxyPoolList(xiciModel);
            proxyPoolMapper.batchInsert(proxyPoolList);

            if ( xiciModel.getNextPage() != null && xiciModel.getNextPage().equals("next")) {
                canNext = false;
            }
            startPage++;
        }
    }

    public String doRequest(String url){

        OkHttpClient client = new OkHttpClient();

        Headers headers = new Headers.Builder()
                .addAll(HeaderUtils.defaultHeaders())
                .add("Host", "www.xicidaili.com")
                .build();

        Request request = new Request.Builder().headers(headers)
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String  result=response.body().string();
            if (result.equals("-10")) {
                log.error("出现-10");
                return null;
            }
            return result;
        } catch (IOException e) {
            return null;
        }
    }

}
