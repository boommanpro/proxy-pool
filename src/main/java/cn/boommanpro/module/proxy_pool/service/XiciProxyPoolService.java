package cn.boommanpro.module.proxy_pool.service;

import cn.boommanpro.module.proxy_pool.parse.XiciParseTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
@Service
public class XiciProxyPoolService {
    @Autowired
    private XiciParseTask xiciParseTask;

    public void startTask(){
        xiciParseTask.start();
    }
}
