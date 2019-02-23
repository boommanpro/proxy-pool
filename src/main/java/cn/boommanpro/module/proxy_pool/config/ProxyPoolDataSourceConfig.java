package cn.boommanpro.module.proxy_pool.config;

/**
 * @author wangqm-b
 * @create 2018/7/19
 */
public class ProxyPoolDataSourceConfig {
    public static final String PREFIX ="db";

    public static final String DB_PROXY_POOL ="proxy-pool";

    public static final String DB_PROXY_POOL_PREFIX =PREFIX+"."+ DB_PROXY_POOL;

    public static final String DB_APP_SQL_SESSION_FACTORY ="proxyPoolSqlSessionFactory";

    public static final String TX_PROXY_POOL ="txProxyPool";

    public static final String PROXY_POOL_DAO_PACKAGE ="cn.boommanpro.module.proxy_pool.dao";
}
