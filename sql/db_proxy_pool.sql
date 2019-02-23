/*
 Navicat Premium Data Transfer

 Source Server         : BoomMan
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : www.boommanpro.cn:3306
 Source Schema         : db_proxy_pool

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 23/02/2019 14:33:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for proxy_pool
-- ----------------------------
DROP TABLE IF EXISTS `proxy_pool`;
CREATE TABLE `proxy_pool`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id自增',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `port` int(11) NULL DEFAULT NULL COMMENT '端口',
  `country` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市',
  `anonymity` enum('HIGH','CLEAR') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '枚举 匿名性',
  `type` enum('HTTP','HTTPS') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Http or Https 类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
