package com.demo.rwdivide.routeDataSource.route;

/**
 * @Description: 路由策略定义
 * @Date: 2020/12/03 13:18
 * @Author: wp
 **/
public interface RouteStrategy {
    /**
     * 路由
     * @param num 路由节点数量
     * @return
     */
     Object route(int num);

}
