## 测试存储过程插入效率
#### 测试表结构sql脚本

- [mall_orders.sql](https://github.com/BetterWp/JAVA-000/tree/main/Week_07/db_data_fill/mall_orders.sql)

#### 插入数据到订单表中，关闭自动提交，批量插入

- 存储过程：

```
DROP PROCEDURE IF EXISTS orders_initData;
DELIMITER $
CREATE PROCEDURE orders_initData()
BEGIN
    DECLARE i INT DEFAULT 1;
    set autocommit=0;
    WHILE i<=1000000 DO
            insert into test.mall_orders (user_id, order_no, order_status, goods_info, send_info,transfare_info,snapshot_info,coupon_info,discount_info, create_time, update_time)
            VALUES (CEILING(rand()*10000), CEILING(rand()*100000000), CEILING(rand()*10), '{"key":"value"}', '{"key":"value"}',
'{"key":"value"}','{"key":"value"}','{"key":"value"}','{"key":"value"}', now() , now());
        SET i = i+1;
    END WHILE;
    commit;
END $
CALL orders_initData();
```
- 执行结果：
![image][whole_transaction]
- 执行效率：1min10s

#### 插入数据到订单表中，自动提交，一条一条的插入
- 另外创建表：
```
CREATE TABLE mall_orders1 LIKE mall_orders;
```
- 存储过程：
```
DROP PROCEDURE IF EXISTS orders_initData_one;
DELIMITER $
CREATE PROCEDURE orders_initData_one()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i<=1000000 DO
            insert into test.mall_orders1 (user_id, order_no, order_status, goods_info, send_info,transfare_info,snapshot_info,coupon_info,discount_info, create_time, update_time)
            VALUES (CEILING(rand()*10000), CEILING(rand()*100000000), CEILING(rand()*10), '{"key":"value"}', '{"key":"value"}',
'{"key":"value"}','{"key":"value"}','{"key":"value"}','{"key":"value"}', now() , now());
        SET i = i+1;
    END WHILE;
END $
CALL orders_initData_one();
```
- 执行结果：
![image][onebyone_transaction]
- 执行效率：20min
- 参考链接
  
    - [程序PreparedStatement批处理](https://blog.csdn.net/weixin_45062761/article/details/104601228)
- 总结：
    - 单条的插入sql解析成本高并且重复，程序中还可整合insert语法 values多值插入
    
    - 减少频繁开启事务提交事务的影响
    
    - 减少与mysql的session交互
    
      
    
[whole_transaction]: https://github.com/BetterWp/JAVA-000/tree/main/Week_07/db_data_fill/whole_transaction.png
[onebyone_transaction]: https://github.com/BetterWp/JAVA-000/tree/main/Week_07/db_data_fill/onebyone_transaction.png