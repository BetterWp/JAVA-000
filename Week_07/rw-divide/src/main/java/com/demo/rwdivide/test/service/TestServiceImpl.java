package com.demo.rwdivide.test.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 测试Service实现类
 * @Date: 2020/12/03 11:14
 * @Author: wp
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements ITestService {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Integer> getList() {
        String sql = "SELECT * FROM t1";
        log.info("DataSource===={}",jdbcTemplate.getDataSource().toString());
        return jdbcTemplate.queryForList(sql,int.class);
    }

    @Override
    @Transactional(transactionManager = "transactionManager",rollbackFor = Exception.class)
    public Integer insert(Integer num) {
        String sql = "INSERT INTO t1 value(?)";
        int update = jdbcTemplate.update(sql, num);
        int i = 1/0;
        return update;
    }
}
