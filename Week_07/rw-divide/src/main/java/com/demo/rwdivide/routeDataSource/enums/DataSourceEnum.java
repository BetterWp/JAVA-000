package com.demo.rwdivide.routeDataSource.enums;

/**
 * @Description: 数据源枚举
 * @Date: 2020/12/03 09:47
 * @Author: wp
 **/
public enum DataSourceEnum {

    READ("read","读库"),
    WRITE("write","写库");

    private String type;
    private String name;

    DataSourceEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
