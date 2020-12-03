package com.demo.rwdivide.routeDataSource.aspect;

import com.demo.rwdivide.routeDataSource.datasource.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description: 数据源选择切面
 * @Date: 2020/12/03 09:54
 * @Author: wp
 **/
@Component
@Aspect
@Order(-1)
@Slf4j
public class DataSourceAop {

    @Pointcut("execution(* com.demo.*.service.*.select*(..)) || execution(* com.demo.*.service..*.get*(..))|| execution(* com.demo.*.service..*.query*(..))")
    public void read(){

    }

    @Pointcut("execution(* com.demo.*.service..*.insert*(..)) || execution(* com.demo.*.service..*.update*(..))")
    public void write(){

    }

    @Pointcut("execution(* com.demo.*.service..*.*(..))")
    public void clear(){

    }


    @Before("read()")
    public void setReadDataSourceType() {
        DataSourceContextHolder.read();
        log.info("dataSource 切换到：Read");
    }

    @Before("write()")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
        log.info("dataSource 切换到：Write");
    }
    @After("clear()")
    public void remove(){
        DataSourceContextHolder.clear();
        log.info("dataSource clear");
    }
}
