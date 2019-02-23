package cn.boommanpro.web;

import cn.boommanpro.module.proxy_pool.service.XiciProxyPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
@RestController
@RequestMapping("backDoor")
public class BackDoorController {
    @Autowired
    private XiciProxyPoolService xiciProxyPoolService;




    @GetMapping("xiciProxyPoolTask")
    public String xiciProxyPoolTask(){
        xiciProxyPoolService.startTask();
        return "SUCCESS";
    }
}
