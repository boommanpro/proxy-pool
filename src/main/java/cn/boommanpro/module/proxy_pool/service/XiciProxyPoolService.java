package cn.boommanpro.module.proxy_pool.service;

import cn.boommanpro.module.proxy_pool.dao.ProxyPoolMapper;
import cn.boommanpro.module.proxy_pool.model.ProxyPool;
import cn.boommanpro.module.proxy_pool.parse.XiciParseTask;
import cn.boommanpro.module.proxy_pool.validate.ValidateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
@Service
public class XiciProxyPoolService {
    @Autowired
    private XiciParseTask xiciParseTask;

    @Autowired
    private ProxyPoolMapper proxyPoolMapper;

    public void startTask(){
        xiciParseTask.start();
    }

    public void validateProxyPool(){
        List<ProxyPool> proxyPoolList = proxyPoolMapper.listAll();
        for (ProxyPool proxyPool : proxyPoolList) {
            boolean validate = ValidateProxy.validate(proxyPool);
            System.out.println(proxyPool+"校验结果"+validate);
        }
    }
}
