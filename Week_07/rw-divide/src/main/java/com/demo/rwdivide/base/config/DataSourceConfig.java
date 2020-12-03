package com.demo.rwdivide.base.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 数据源配置
 * @Date: 2020/12/03 09:46
 * @Author: wp
 **/
@Configuration
@Slf4j
public class DataSourceConfig {

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Primary
    @Bean(name="writeDataSource")
    @ConfigurationProperties(prefix = "demo.multi-ds.master")
    public DataSource writeDataSource() {
        log.info("-------------------- writeDataSource init ---------------------");
        DataSource dataSource= DataSourceBuilder.create().type(dataSourceType).build();
        return dataSource;
    }
    /**
     * 有多少个从库就要配置多少个
     * @return
     */
    @Bean(name = "readDataSource1")
    @ConfigurationProperties(prefix = "demo.multi-ds.slave1")
    public DataSource readDataSourceOne(){
        log.info("-------------------- readDataSourceOne init --------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "readDataSource2")
    @ConfigurationProperties(prefix = "demo.multi-ds.slave2")
    public DataSource readDataSourceTwo() {
        log.info("-------------------- readDataSourceTwo init --------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean("readDataSources")
    public List<DataSource> readDataSources(){
        List<DataSource> dataSources=new ArrayList<>();
        dataSources.add(readDataSourceOne());
        dataSources.add(readDataSourceTwo());
        return dataSources;
    }
}
