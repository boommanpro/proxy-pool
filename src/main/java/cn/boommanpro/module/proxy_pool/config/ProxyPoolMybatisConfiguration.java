package cn.boommanpro.module.proxy_pool.config;



import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangqm-b
 * @create 2018/4/24
 */
@Configuration
@ConditionalOnBean(SqlSessionFactoryBean.class)
@MapperScan(basePackages = ProxyPoolDataSourceConfig.PROXY_POOL_DAO_PACKAGE,sqlSessionFactoryRef = ProxyPoolDataSourceConfig.DB_APP_SQL_SESSION_FACTORY)
public class ProxyPoolMybatisConfiguration {
}
