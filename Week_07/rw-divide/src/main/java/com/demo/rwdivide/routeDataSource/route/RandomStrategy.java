package com.demo.rwdivide.routeDataSource.route;

import com.demo.rwdivide.routeDataSource.enums.DataSourceEnum;

/**
 * @Description: 随机策略
 * @Date: 2020/12/03 13:43
 * @Author: wp
 **/
public class RandomStrategy implements RouteStrategy {

    @Override
    public Object route(int num) {
        int number = (int)Math.random()*num;
        return DataSourceEnum.READ.getType()+number;
    }
}
