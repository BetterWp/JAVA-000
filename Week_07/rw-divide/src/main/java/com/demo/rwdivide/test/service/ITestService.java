package com.demo.rwdivide.test.service;

import java.util.List;

/**
 * @Description: 测试Service
 * @Date: 2020/12/03 11:13
 * @Author: wp
 **/
public interface ITestService {

    /**
     * 测试读
     * @return
     */
    List<Integer> getList();

    /**
     * 测试写
     * @param num
     * @return
     */
    Integer insert(Integer num);
}
