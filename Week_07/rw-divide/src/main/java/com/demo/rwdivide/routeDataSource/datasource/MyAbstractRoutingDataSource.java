package com.demo.rwdivide.routeDataSource.datasource;

import com.demo.rwdivide.routeDataSource.enums.DataSourceEnum;
import com.demo.rwdivide.routeDataSource.route.StrategyFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description: 数据源定义
 * @Date: 2020/12/03 09:47
 * @Author: wp
 **/
public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {

    private int slaveDsNum;
    private String strategy;

    public MyAbstractRoutingDataSource(int slaveDsNum,String strategy){
        this.slaveDsNum = slaveDsNum;
        this.strategy = strategy;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String type = DataSourceContextHolder.getType();
        if (DataSourceEnum.WRITE.getType().equals(type)){
            return DataSourceEnum.WRITE.getType();
        }
        return StrategyFactory.getStrategyInstance(strategy).route(slaveDsNum);
    }
}
