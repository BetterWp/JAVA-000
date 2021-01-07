/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2021-01-07 16:21:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_orders
-- ----------------------------
DROP TABLE IF EXISTS `mall_orders`;
CREATE TABLE `mall_orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户关联ID',
  `order_no` varchar(30) DEFAULT NULL COMMENT '订单编号',
  `order_status` int(10) DEFAULT NULL COMMENT '订单状态',
  `goods_info` varchar(255) DEFAULT NULL COMMENT '订单商品信息',
  `send_info` varchar(255) DEFAULT NULL COMMENT '配送信息',
  `transfare_info` varchar(255) DEFAULT NULL COMMENT '运费信息',
  `snapshot_info` varchar(255) DEFAULT NULL COMMENT '订单快照信息',
  `coupon_info` varchar(255) DEFAULT NULL COMMENT '优惠券信息',
  `discount_info` varchar(255) DEFAULT NULL COMMENT '折扣信息',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000001 DEFAULT CHARSET=utf8mb4;
