package cn.boommanpro.module.proxy_pool.dao;

import cn.boommanpro.module.proxy_pool.model.ProxyPool;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 2019/02/23
*/
@Mapper
public interface ProxyPoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProxyPool record);

    int insertSelective(ProxyPool record);

    ProxyPool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProxyPool record);

    int updateByPrimaryKey(ProxyPool record);

    int batchInsert(@Param("proxyPoolList") List<ProxyPool> proxyPoolList);
}