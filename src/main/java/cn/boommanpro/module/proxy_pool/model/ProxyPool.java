package cn.boommanpro.module.proxy_pool.model;

import cn.boommanpro.module.proxy_pool.type.AnonymityType;
import cn.boommanpro.module.proxy_pool.type.HttpType;
import lombok.Data;

/**
* Created by Mybatis Generator 2019/02/23
*/
@Data
public class ProxyPool {
    /**
	* 主键id自增
	*/
    private Integer id;

    /**
	* ip
	*/
    private String ip;

    /**
	* 端口
	*/
    private Integer port;

    /**
	* 城市
	*/
    private String country;

    /**
	* 枚举 匿名性
	*/
    private AnonymityType anonymity;

    /**
	* Http or Https 类型
	*/
    private HttpType type;
}