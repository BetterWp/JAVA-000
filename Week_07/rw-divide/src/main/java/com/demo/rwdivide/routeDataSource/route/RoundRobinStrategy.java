package com.demo.rwdivide.routeDataSource.route;

import com.demo.rwdivide.routeDataSource.enums.DataSourceEnum;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 轮询
 * @Date: 2020/12/03 13:21
 * @Author: wp
 **/
public class RoundRobinStrategy implements RouteStrategy {

    AtomicInteger count = new AtomicInteger(0);

    @Override
    public Object route(int num) {
        int number = count.getAndIncrement();
        int i = number % num;
        return DataSourceEnum.READ.getType()+i;
    }
}
