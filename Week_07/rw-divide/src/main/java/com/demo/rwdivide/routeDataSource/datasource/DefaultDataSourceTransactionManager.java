package com.demo.rwdivide.routeDataSource.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Description: 自定义事务管理器
 * @Date: 2020/12/03 14:02
 * @Author: wp
 **/
@Configuration
@EnableTransactionManagement
public class DefaultDataSourceTransactionManager implements TransactionManagementConfigurer {

    @Resource
    private DataSource abstractRoutingDataSource;

    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(abstractRoutingDataSource);
    }

    @Override
    public TransactionManager annotationDrivenTransactionManager() {
        return transactionManager();
    }
}
