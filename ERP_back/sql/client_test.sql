/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : client_test

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 05/03/2021 00:58:12
*/

SET NAMES utf8mb4;

-- ----------------------------
-- Table structure for distance_c
-- ----------------------------
DROP TABLE IF EXISTS `distance_c`;
CREATE TABLE `distance_c`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `loc_1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置1',
  `loc_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置2',
  `distance` double(100, 0) NULL DEFAULT NULL COMMENT '距离',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for manager_c
-- ----------------------------
DROP TABLE IF EXISTS `manager_c`;
CREATE TABLE `manager_c`  (
  `id` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '门店管理员id，登录id',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '门店管理员名字',
  `code` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆密码',
  `power` int(2) NULL DEFAULT NULL COMMENT '权限，分为3级（1，2，3）最高3级',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for materiallist_c
-- ----------------------------
DROP TABLE IF EXISTS `materiallist_c`;
CREATE TABLE `materiallist_c`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原料名称',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for predict_c
-- ----------------------------
DROP TABLE IF EXISTS `predict_c`;
CREATE TABLE `predict_c`  (
  `predict_date` date NOT NULL COMMENT '预测针对的日期',
  `actual_sales_amount` double(10, 0) NOT NULL COMMENT '实际销售额',
  `predict_sales_amount` double(10, 0) NULL DEFAULT NULL COMMENT '预测销售额'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for price_change_c
-- ----------------------------
DROP TABLE IF EXISTS `price_change_c`;
CREATE TABLE `price_change_c`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成品id',
  `change_date` date NULL DEFAULT NULL COMMENT '调价日期',
  `old_price` double(10, 2) NULL DEFAULT NULL COMMENT '原始价格',
  `new_price` double(10, 2) NULL DEFAULT NULL COMMENT '更新后价格',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `price_change_c_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `productlist_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_material_relation_c
-- ----------------------------
DROP TABLE IF EXISTS `product_material_relation_c`;
CREATE TABLE `product_material_relation_c`  (
  `product_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '成品id',
  `material_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原料id',
  PRIMARY KEY (`product_id`, `material_id`) USING BTREE,
  INDEX `material_id`(`material_id`) USING BTREE,
  CONSTRAINT `product_material_relation_c_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `productlist_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `product_material_relation_c_ibfk_2` FOREIGN KEY (`material_id`) REFERENCES `materiallist_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for productlist_c
-- ----------------------------
DROP TABLE IF EXISTS `productlist_c`;
CREATE TABLE `productlist_c`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成品名称',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '成品当前单价',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `price`(`price`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for purchase_acceptance_c
-- ----------------------------
DROP TABLE IF EXISTS `purchase_acceptance_c`;
CREATE TABLE `purchase_acceptance_c`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `purchase_application_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进货申请id',
  `class` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核级别',
  `review_result` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核结果',
  `manager_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核的管理员名字',
  `review_date` date NULL DEFAULT NULL COMMENT '审核的日期',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `manager_name`(`manager_name`) USING BTREE,
  INDEX `purchase_application_id`(`purchase_application_id`) USING BTREE,
  CONSTRAINT `purchase_acceptance_c_ibfk_2` FOREIGN KEY (`manager_name`) REFERENCES `manager_c` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `purchase_acceptance_c_ibfk_3` FOREIGN KEY (`purchase_application_id`) REFERENCES `purchase_application_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for purchase_application_c
-- ----------------------------
DROP TABLE IF EXISTS `purchase_application_c`;
CREATE TABLE `purchase_application_c`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sub_date` date NULL DEFAULT NULL COMMENT '进货申请提交的日期',
  `manager_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数量',
  `state` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'state（1审核中、2 审核未通过、3审核通过、4运输中、5已收货、6已完成、0已取消）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `material_id`(`sub_date`) USING BTREE,
  INDEX `manager_name`(`manager_name`) USING BTREE,
  CONSTRAINT `purchase_application_c_ibfk_1` FOREIGN KEY (`manager_name`) REFERENCES `manager_c` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for purchase_list_c
-- ----------------------------
DROP TABLE IF EXISTS `purchase_list_c`;
CREATE TABLE `purchase_list_c`  (
  `purchase_application_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `material_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原料id',
  `num` double(10, 0) NULL DEFAULT NULL COMMENT '数量',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `supplier_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商id',
  `state` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '货物检验结果（0未检验,1合格,-1不合格）',
  `in_date` date NULL DEFAULT NULL COMMENT '到货日期',
  PRIMARY KEY (`purchase_application_id`, `material_id`) USING BTREE,
  INDEX `material_id`(`material_id`) USING BTREE,
  INDEX `supplier_id`(`supplier_id`) USING BTREE,
  INDEX `in_date`(`in_date`) USING BTREE,
  CONSTRAINT `purchase_list_c_ibfk_2` FOREIGN KEY (`material_id`) REFERENCES `materiallist_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `purchase_list_c_ibfk_3` FOREIGN KEY (`supplier_id`) REFERENCES `supplier_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `purchase_list_c_ibfk_4` FOREIGN KEY (`purchase_application_id`) REFERENCES `purchase_application_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for return_application_c
-- ----------------------------
DROP TABLE IF EXISTS `return_application_c`;
CREATE TABLE `return_application_c`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sales_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售记录id',
  `return_date` date NULL DEFAULT NULL COMMENT '退货申请提交日期',
  `product_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成品id',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货原因',
  `num` int(10) NULL DEFAULT NULL COMMENT '退货数量，即该单原先卖出的数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sales_id`(`sales_id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `return_application_c_ibfk_1` FOREIGN KEY (`sales_id`) REFERENCES `sales_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `return_application_c_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `productlist_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sales_c
-- ----------------------------
DROP TABLE IF EXISTS `sales_c`;
CREATE TABLE `sales_c`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成品id',
  `sales_date` date NULL DEFAULT NULL COMMENT '销售日期',
  `num` int(10) NULL DEFAULT NULL COMMENT '数量',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `sales_sum` double(10, 2) NULL DEFAULT NULL COMMENT '该条销售记录的销售额，即num*price',
  `return_state` tinyint(1) NULL DEFAULT NULL COMMENT '退货状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  INDEX `price`(`price`) USING BTREE,
  CONSTRAINT `sales_c_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `productlist_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sales_c_ibfk_2` FOREIGN KEY (`price`) REFERENCES `productlist_c` (`price`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop_c
-- ----------------------------
DROP TABLE IF EXISTS `shop_c`;
CREATE TABLE `shop_c`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shop_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门店名称',
  `shop_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门店位置',
  `shop_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门店类型',
  `shop_synopsis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门店简介',
  `found_date` datetime(6) NULL DEFAULT NULL COMMENT '成立日期',
  `shop_director` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门店负责人名称',
  `shop_capital` int(10) NULL DEFAULT NULL COMMENT '注册资金',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `shop_name`(`shop_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for supplier_c
-- ----------------------------
DROP TABLE IF EXISTS `supplier_c`;
CREATE TABLE `supplier_c`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商位置',
  `star` int(100) NULL DEFAULT NULL COMMENT '合作分值',
  `time_parameter` double(10, 2) NULL DEFAULT NULL COMMENT '运输时间系数',
  `fare_parameter` double(10, 2) NULL DEFAULT NULL COMMENT '运输费用系数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for supplier_material_relation_c
-- ----------------------------
DROP TABLE IF EXISTS `supplier_material_relation_c`;
CREATE TABLE `supplier_material_relation_c`  (
  `supplier_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商id',
  `material_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原料id',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '报价',
  PRIMARY KEY (`supplier_id`, `material_id`) USING BTREE,
  INDEX `material_id`(`material_id`) USING BTREE,
  CONSTRAINT `supplier_material_relation_c_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `supplier_material_relation_c_ibfk_2` FOREIGN KEY (`material_id`) REFERENCES `materiallist_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for warehouse_material_c
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_material_c`;
CREATE TABLE `warehouse_material_c`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `material_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原料名称',
  `quantity` int(10) NULL DEFAULT NULL COMMENT '数量',
  `in_date` date NULL DEFAULT NULL COMMENT '进货日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `material_name`(`material_name`) USING BTREE,
  INDEX `in_date`(`in_date`) USING BTREE,
  CONSTRAINT `warehouse_material_c_ibfk_1` FOREIGN KEY (`material_name`) REFERENCES `materiallist_c` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for warehouse_product_c
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_product_c`;
CREATE TABLE `warehouse_product_c`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成品id',
  `quantity` int(10) NULL DEFAULT NULL COMMENT '数量',
  `in_date` date NULL DEFAULT NULL COMMENT '进货日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `warehouse_product_c_ibfk_1`(`product_id`) USING BTREE,
  CONSTRAINT `warehouse_product_c_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `productlist_c` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `sales_date`;
CREATE TABLE `sales_date`  (
  `sales_date` datetime(6) NULL DEFAULT NULL COMMENT '已经导出的销售数据的日期'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `return_date`;
CREATE TABLE `return_date`  (
  `return_date` datetime(6) NULL DEFAULT NULL COMMENT '已经导出的退货数据的日期'
)ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
