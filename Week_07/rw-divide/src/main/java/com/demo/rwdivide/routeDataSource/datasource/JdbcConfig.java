package com.demo.rwdivide.routeDataSource.datasource;

import com.demo.rwdivide.routeDataSource.enums.DataSourceEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: Bean配置
 * @Date: 2020/12/03 10:51
 * @Author: wp
 **/
@Configuration
public class JdbcConfig {

    @Resource
    private DataSource writeDataSource;

    @Resource
    private List<DataSource> readDataSources;

    @Value(value = "${demo.multi-ds.route}")
    private String strategy;


    @Bean
    public JdbcTemplate jdbcTemplate(AbstractRoutingDataSource abstractRoutingDataSource){
        //TODO 整合持久层框架
        return new JdbcTemplate(abstractRoutingDataSource);
    }

    @Bean
    public AbstractRoutingDataSource abstractRoutingDataSource(){
        AbstractRoutingDataSource dataSource = new MyAbstractRoutingDataSource(readDataSources.size(),strategy);
        Map<Object,Object> targetDataSources = new ConcurrentHashMap<>(5);
        targetDataSources.put(DataSourceEnum.WRITE.getType(),writeDataSource);
        for (int i = 0; i < readDataSources.size(); i++) {
            targetDataSources.put(DataSourceEnum.READ.getType()+i,readDataSources.get(i));
        }
        dataSource.setDefaultTargetDataSource(writeDataSource);
        dataSource.setTargetDataSources(targetDataSources);
        return dataSource;
    }
}
