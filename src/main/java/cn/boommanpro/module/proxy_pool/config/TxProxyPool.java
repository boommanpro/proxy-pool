package cn.boommanpro.module.proxy_pool.config;

import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangqm-b
 * @create 2018/7/17
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional(ProxyPoolDataSourceConfig.TX_PROXY_POOL)
public @interface TxProxyPool {
}
