package cn.boommanpro.module.proxy_pool.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class XiciProxyPoolServiceTest {

    @Autowired
    private XiciProxyPoolService xiciProxyPoolService;

    @Test
    public void validateProxyPool() {
        xiciProxyPoolService.validateProxyPool();
    }
}