package com.demo.rwdivide.routeDataSource.datasource;

import com.demo.rwdivide.routeDataSource.enums.DataSourceEnum;

/**
 * @Description: 数据源上下文
 * @Date: 2020/12/03 10:01
 * @Author: wp
 **/
public class DataSourceContextHolder {

    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void read(){
        threadLocal.set(DataSourceEnum.READ.getType());
    }

    public static void write(){
        threadLocal.set(DataSourceEnum.WRITE.getType());
    }

    public static void clear(){
        threadLocal.remove();
    }

    public static String getType(){
        return threadLocal.get();
    }

}
