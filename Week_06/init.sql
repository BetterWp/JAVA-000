
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mall_goods
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods`;
CREATE TABLE `mall_goods` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品关联ID',
  `name` varchar(30) DEFAULT NULL COMMENT '商品名称',
  `goods_describe` longtext COMMENT '商品描述',
  `details` longtext COMMENT '详情',
  `unit` varchar(10) DEFAULT NULL COMMENT '计量单位',
  `goods_img` varchar(300) DEFAULT NULL COMMENT '商品图片(展示多张图片)',
  `goodsIcon` varchar(50) DEFAULT NULL COMMENT '商品图片(展示图片) 1张',
  `seller_price` decimal(10,2) DEFAULT NULL COMMENT '销售价',
  `cost_price` decimal(10,2) DEFAULT NULL COMMENT '成本价',
  `stock` bigint(20) DEFAULT NULL COMMENT '库存',
  `stock_warning` int(10) DEFAULT NULL COMMENT '库存预警值',
  `is_upper` tinyint(1) DEFAULT NULL COMMENT '0上架1下架',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for mall_user
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户关联ID',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `head_img` varchar(50) DEFAULT NULL COMMENT '头像',
  `telephone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
