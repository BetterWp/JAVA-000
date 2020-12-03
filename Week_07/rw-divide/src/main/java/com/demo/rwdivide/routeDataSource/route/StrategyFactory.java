package com.demo.rwdivide.routeDataSource.route;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Description: 策略工厂类
 * @Date: 2020/12/03 13:29
 * @Author: wp
 **/
public class StrategyFactory {

    private static final Map<String,RouteStrategy> map = new HashMap<>(10);

    static {
        map.put("round-robin",new RoundRobinStrategy());
        map.put("random",new RandomStrategy());
    }

    public static RouteStrategy getStrategyInstance(String strategy){
        return Optional.ofNullable(map.get(strategy)).orElseThrow(IllegalArgumentException::new);
    }
}
