package cn.boommanpro.module.proxy_pool.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author wangqm-b
 * @create 2018/7/19
 */
@Configuration
@Slf4j
public class ProxyPoolDataSourceConfiguration {

    @Bean(value = ProxyPoolDataSourceConfig.DB_PROXY_POOL)
    @Primary
    @ConfigurationProperties(ProxyPoolDataSourceConfig.DB_PROXY_POOL_PREFIX)
    public DataSource proxyPoolDataSource() {
        DataSourceBuilder<HikariDataSource> factory = DataSourceBuilder.create().type(HikariDataSource.class);
        HikariDataSource gameDataSource = factory.build();
        gameDataSource.setConnectionInitSql("SET NAMES utf8mb4");
        return gameDataSource;
    }


    @Bean(value = ProxyPoolDataSourceConfig.DB_APP_SQL_SESSION_FACTORY)
    @Primary
    public SqlSessionFactoryBean proxyPoolSqlSessionFactory(@Qualifier(ProxyPoolDataSourceConfig.DB_PROXY_POOL) DataSource dataSource) {
        SqlSessionFactoryBean mybatisSqlSessionFactoryBean = new SqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        mybatisSqlSessionFactoryBean.setSqlSessionFactoryBuilder(new SqlSessionFactoryBuilder());
        return mybatisSqlSessionFactoryBean;
    }




    @Bean(ProxyPoolDataSourceConfig.TX_PROXY_POOL)
    @Primary
    public DataSourceTransactionManager proxyPoolTx(@Qualifier(ProxyPoolDataSourceConfig.DB_PROXY_POOL) DataSource dataSource) {
        DataSourceTransactionManager basicTx = new DataSourceTransactionManager();
        basicTx.setDataSource(dataSource);
        return basicTx;
    }
}
