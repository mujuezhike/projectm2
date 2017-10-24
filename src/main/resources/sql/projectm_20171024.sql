/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.105
Source Server Version : 50629
Source Host           : 192.168.1.105:3306
Source Database       : projectm

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2017-10-24 18:34:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_object_table
-- ----------------------------
DROP TABLE IF EXISTS `s_object_table`;
CREATE TABLE `s_object_table` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '表名',
  `status` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `describe` varchar(255) DEFAULT NULL COMMENT '描述',
  `type` varchar(255) DEFAULT NULL COMMENT '业务类型',
  `structure_type` varchar(255) DEFAULT NULL COMMENT '结构类型',
  `table_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_object_table
-- ----------------------------
INSERT INTO `s_object_table` VALUES ('1', '数据表基表', '1', '2017-09-27 16:14:10', '2017-09-27 16:33:05', '数据表的基本信息', '1', '1', 's_object_table');
INSERT INTO `s_object_table` VALUES ('2', '数据列基表', '1', '2017-09-27 16:26:10', '2017-09-27 16:33:06', '数据表列项信息', '1', '1', 's_object_table_column');
INSERT INTO `s_object_table` VALUES ('3', '数据表状态表', '1', '2017-09-27 16:57:39', '2017-09-27 16:57:39', '数据表状态', '1', '2', 't_table_status');
INSERT INTO `s_object_table` VALUES ('4', '数据表业务类型表', '1', '2017-09-27 16:58:18', '2017-09-27 16:59:27', '数据表业务类型', '1', '2', 't_table_type');
INSERT INTO `s_object_table` VALUES ('5', '数据库结构类型表', '1', '2017-09-27 16:59:43', '2017-09-27 17:00:10', '数据表结构类型', '1', '2', 't_table_structure_type');
INSERT INTO `s_object_table` VALUES ('6', '列类型', '1', '2017-09-27 19:29:15', '2017-09-27 19:29:36', '列类型', '1', '2', 't_column_column_type');
INSERT INTO `s_object_table` VALUES ('7', '列业务类型', '1', '2017-09-27 19:29:45', '2017-09-27 19:29:59', '列业务类型', '1', '2', 't_column_type');
INSERT INTO `s_object_table` VALUES ('8', '数据列默认值', '1', '2017-10-19 10:44:47', '2017-10-19 10:59:56', '数据列默认值', '1', '1', 's_object_table_column_default');

-- ----------------------------
-- Table structure for s_object_table_column
-- ----------------------------
DROP TABLE IF EXISTS `s_object_table_column`;
CREATE TABLE `s_object_table_column` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `describe` varchar(255) DEFAULT NULL COMMENT '描述',
  `fid` varchar(255) DEFAULT NULL COMMENT '表id',
  `column_name` varchar(255) DEFAULT NULL COMMENT '列名称',
  `column_type` varchar(255) DEFAULT NULL COMMENT '列类型',
  `type` varchar(255) DEFAULT NULL COMMENT '业务类型',
  `relation_table_name` varchar(255) DEFAULT NULL COMMENT '关联表名',
  `relation_column_name` varchar(255) DEFAULT NULL COMMENT '关联列名',
  `relation_table` varchar(255) DEFAULT NULL COMMENT '关联表',
  `relation_column` varchar(255) DEFAULT NULL COMMENT '关联列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_object_table_column
-- ----------------------------
INSERT INTO `s_object_table_column` VALUES ('1', 'ID', '1', '2017-09-27 16:28:54', '2017-10-24 15:38:01', '表ID', '1', 'id', '2', '1', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('10', 'ID', '1', '2017-09-27 16:28:54', '2017-10-24 15:38:10', '列ID', '2', 'id', '2', '1', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('11', '名称', '1', '2017-09-27 17:02:41', '2017-09-27 17:02:41', '列名称', '2', 'name', '2', '1', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('12', '状态', '1', '2017-09-27 16:34:45', '2017-09-27 17:20:10', '状态', '2', 'status', '10', '1', 't_table_status', null, '3', null);
INSERT INTO `s_object_table_column` VALUES ('13', '创建时间', '1', '2017-09-27 16:37:05', '2017-10-24 17:09:07', '创建时间', '2', 'create_time', '4', '1', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('14', '更新时间', '1', '2017-09-27 16:37:36', '2017-10-24 17:09:09', '更新时间', '2', 'update_time', '4', '1', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('15', '描述', '1', '2017-09-27 16:38:04', '2017-10-24 17:09:16', '列描述', '2', 'describe', '3', '1', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('16', '表ID', '1', '2017-09-27 17:07:52', '2017-09-27 17:20:12', '对应的表ID', '2', 'fid', '11', '2', 's_object_table', null, '1', null);
INSERT INTO `s_object_table_column` VALUES ('17', '数据表列项列表', '1', '2017-09-27 17:10:20', '2017-09-28 13:04:54', '数据表对应的列项列表', '1', '_table_columns', '21', '3', 's_object_table_column', 'fid', '2', '16');
INSERT INTO `s_object_table_column` VALUES ('18', '数据库列实际名称', '1', '2017-09-27 17:12:13', '2017-09-27 17:12:43', '数据库列实际名称', '2', 'column_name', '2', '2', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('19', '列类型', '1', '2017-09-27 17:13:31', '2017-09-27 19:30:14', '列类型', '2', 'column_type', '10', '2', 't_column_column_type', null, '6', null);
INSERT INTO `s_object_table_column` VALUES ('2', '名称', '1', '2017-09-27 16:30:10', '2017-09-27 16:36:23', '表名称', '1', 'name', '2', '1', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('20', '列业务类型', '1', '2017-09-27 17:23:42', '2017-09-27 19:30:15', '列业务类型', '2', 'type', '10', '2', 't_column_type', null, '7', null);
INSERT INTO `s_object_table_column` VALUES ('21', '关联表名', '1', '2017-09-27 17:46:19', '2017-09-27 19:21:12', '关联表名', '2', 'relation_table_name', '2', '2', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('22', '关联列名', '1', '2017-09-27 17:49:21', '2017-09-27 19:08:15', '关联列名', '2', 'relation_column_name', '2', '2', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('23', '关联表', '1', '2017-09-27 19:07:21', '2017-09-27 19:08:33', '关联表', '2', 'relation_table', '11', '2', 's_object_table', null, '1', null);
INSERT INTO `s_object_table_column` VALUES ('24', '关联列', '1', '2017-09-27 19:09:55', '2017-09-27 19:10:15', '关联列', '2', 'relation_column', '11', '2', 's_object_column', null, '2', null);
INSERT INTO `s_object_table_column` VALUES ('25', 'ID', '1', '2017-09-27 16:28:54', '2017-10-24 15:38:14', '表ID', '3', 'id', '2', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('26', '名称', '1', '2017-09-27 16:30:10', '2017-09-27 16:36:23', '表名称', '3', 'name', '2', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('27', '状态', '1', '2017-09-27 16:34:45', '2017-09-27 17:20:03', '状态', '3', 'status', '10', '1', 't_table_status', '', '3', null);
INSERT INTO `s_object_table_column` VALUES ('28', '创建时间', '1', '2017-09-27 16:37:05', '2017-09-27 16:39:08', '创建时间', '3', 'create_time', '4', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('29', '更新时间', '1', '2017-09-27 16:37:36', '2017-09-27 16:39:10', '更新时间', '3', 'update_time', '4', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('3', '状态', '1', '2017-09-27 16:34:45', '2017-09-27 17:20:03', '状态', '1', 'status', '10', '1', 't_table_status', null, '3', null);
INSERT INTO `s_object_table_column` VALUES ('30', '描述', '1', '2017-09-27 16:38:04', '2017-09-27 16:39:05', '表描述', '3', 'describe', '3', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('31', 'ID', '1', '2017-09-27 16:28:54', '2017-10-24 15:38:17', '表ID', '4', 'id', '2', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('32', '名称', '1', '2017-09-27 16:30:10', '2017-09-27 16:36:23', '表名称', '4', 'name', '2', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('33', '状态', '1', '2017-09-27 16:34:45', '2017-09-27 17:20:03', '状态', '4', 'status', '10', '1', 't_table_status', '', '3', null);
INSERT INTO `s_object_table_column` VALUES ('34', '创建时间', '1', '2017-09-27 16:37:05', '2017-09-27 16:39:08', '创建时间', '4', 'create_time', '4', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('35', '更新时间', '1', '2017-09-27 16:37:36', '2017-09-27 16:39:10', '更新时间', '4', 'update_time', '4', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('36', '描述', '1', '2017-09-27 16:38:04', '2017-09-27 16:39:05', '表描述', '4', 'describe', '3', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('37', 'ID', '1', '2017-09-27 16:28:54', '2017-10-24 15:38:20', '表ID', '5', 'id', '2', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('38', '名称', '1', '2017-09-27 16:30:10', '2017-09-27 16:36:23', '表名称', '5', 'name', '2', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('39', '状态', '1', '2017-09-27 16:34:45', '2017-09-27 17:20:03', '状态', '5', 'status', '10', '1', 't_table_status', '', '3', null);
INSERT INTO `s_object_table_column` VALUES ('4', '创建时间', '1', '2017-09-27 16:37:05', '2017-09-27 16:39:08', '创建时间', '1', 'create_time', '4', '1', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('40', '创建时间', '1', '2017-09-27 16:37:05', '2017-09-27 16:39:08', '创建时间', '5', 'create_time', '4', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('41', '更新时间', '1', '2017-09-27 16:37:36', '2017-09-27 16:39:10', '更新时间', '5', 'update_time', '4', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('42', '描述', '1', '2017-09-27 16:38:04', '2017-09-27 16:39:05', '表描述', '5', 'describe', '3', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('43', 'ID', '1', '2017-09-27 16:28:54', '2017-10-24 15:38:24', '表ID', '6', 'id', '2', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('44', '名称', '1', '2017-09-27 16:30:10', '2017-09-27 16:36:23', '表名称', '6', 'name', '2', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('45', '状态', '1', '2017-09-27 16:34:45', '2017-09-27 17:20:03', '状态', '6', 'status', '10', '1', 't_table_status', '', '3', null);
INSERT INTO `s_object_table_column` VALUES ('46', '创建时间', '1', '2017-09-27 16:37:05', '2017-09-27 16:39:08', '创建时间', '6', 'create_time', '4', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('47', '更新时间', '1', '2017-09-27 16:37:36', '2017-09-27 16:39:10', '更新时间', '6', 'update_time', '4', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('48', '描述', '1', '2017-09-27 16:38:04', '2017-09-27 16:39:05', '表描述', '6', 'describe', '3', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('49', 'ID', '1', '2017-09-27 16:28:54', '2017-10-24 15:38:27', '表ID', '7', 'id', '2', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('5', '更新时间', '1', '2017-09-27 16:37:36', '2017-09-27 16:39:10', '更新时间', '1', 'update_time', '4', '1', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('50', '名称', '1', '2017-09-27 16:30:10', '2017-09-27 16:36:23', '表名称', '7', 'name', '2', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('51', '状态', '1', '2017-09-27 16:34:45', '2017-09-27 17:20:03', '状态', '7', 'status', '10', '1', 't_table_status', '', '3', null);
INSERT INTO `s_object_table_column` VALUES ('52', '创建时间', '1', '2017-09-27 16:37:05', '2017-09-27 16:39:08', '创建时间', '7', 'create_time', '4', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('53', '更新时间', '1', '2017-09-27 16:37:36', '2017-09-27 16:39:10', '更新时间', '7', 'update_time', '4', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('54', '描述', '1', '2017-09-27 16:38:04', '2017-09-27 16:39:05', '表描述', '7', 'describe', '3', '1', '', '', null, null);
INSERT INTO `s_object_table_column` VALUES ('55', 'ID', '1', '2017-10-24 16:59:32', '2017-10-24 17:00:57', '默认值ID', '8', 'id', '2', '1', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('56', '名称', '1', '2017-10-24 17:05:14', '2017-10-24 17:05:14', '默认值名称', '8', 'name', '2', '1', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('57', '状态', '1', '2017-09-27 16:34:45', '2017-10-24 17:09:25', '状态', '8', 'status', '10', '1', 't_table_status', '', '3', null);
INSERT INTO `s_object_table_column` VALUES ('58', '创建时间', '1', '2017-09-27 16:37:05', '2017-09-27 16:39:08', '创建时间', '8', 'create_time', '4', '1', '', '', '', '');
INSERT INTO `s_object_table_column` VALUES ('59', '更新时间', '1', '2017-09-27 16:37:36', '2017-10-24 17:09:51', '更新时间', '8', 'update_time', '4', '1', null, '', '', null);
INSERT INTO `s_object_table_column` VALUES ('6', '描述', '1', '2017-09-27 16:38:04', '2017-09-27 16:39:05', '表描述', '1', 'describe', '3', '1', null, null, null, null);
INSERT INTO `s_object_table_column` VALUES ('60', '描述', '1', '2017-09-27 16:38:04', '2017-10-24 17:22:52', '列默认描述', '8', 'describe', '3', '1', '', '', '', '');
INSERT INTO `s_object_table_column` VALUES ('61', '列ID', '1', '2017-09-27 17:07:52', '2017-10-24 17:22:57', '对应的列ID', '8', 'fid', '11', '2', 's_object_table_column', '', '2', '');
INSERT INTO `s_object_table_column` VALUES ('7', '业务类型', '1', '2017-09-27 16:39:56', '2017-09-27 17:20:07', '表业务类型', '1', 'type', '10', '2', 't_table_type', null, '4', null);
INSERT INTO `s_object_table_column` VALUES ('8', '结构类型', '1', '2017-09-27 16:40:28', '2017-09-27 17:20:09', '表结构类型', '1', 'structure_type', '10', '2', 't_table_structure_type', null, '5', null);
INSERT INTO `s_object_table_column` VALUES ('9', '数据库实际表名', '1', '2017-09-27 16:41:33', '2017-09-27 16:42:12', '数据库实际表名', '1', 'table_name', '2', '2', null, null, null, null);

-- ----------------------------
-- Table structure for s_object_table_column_default
-- ----------------------------
DROP TABLE IF EXISTS `s_object_table_column_default`;
CREATE TABLE `s_object_table_column_default` (
  `id` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `describe` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  `fid` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '列id',
  `default_type` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '列名称',
  `default_table` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '列类型',
  `default_value` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '列值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of s_object_table_column_default
-- ----------------------------

-- ----------------------------
-- Table structure for t_column_column_type
-- ----------------------------
DROP TABLE IF EXISTS `t_column_column_type`;
CREATE TABLE `t_column_column_type` (
  `id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `status` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `describe` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='列业务类型';

-- ----------------------------
-- Records of t_column_column_type
-- ----------------------------
INSERT INTO `t_column_column_type` VALUES ('1', '数字', '1', '2017-09-27 19:25:46', '2017-09-27 19:31:00', '数字');
INSERT INTO `t_column_column_type` VALUES ('10', '键值对', '1', '2017-09-27 19:32:08', '2017-09-27 19:35:49', '枚举类  类型  状态   relation_table 为关联表');
INSERT INTO `t_column_column_type` VALUES ('11', '子项', '1', '2017-09-27 19:35:07', '2017-09-27 19:36:28', '单子项   relation_table 为关联表');
INSERT INTO `t_column_column_type` VALUES ('2', '文本 ', '1', '2017-09-27 19:25:56', '2017-09-27 19:31:17', '文本 ');
INSERT INTO `t_column_column_type` VALUES ('21', '列表', '1', '2017-09-27 19:37:04', '2017-09-27 19:38:13', 'relation_table 为关联表  relation_column 为关联表父项ID项');
INSERT INTO `t_column_column_type` VALUES ('3', '长文本', '1', '2017-09-27 19:31:37', '2017-09-27 19:31:37', '长文本');
INSERT INTO `t_column_column_type` VALUES ('4', '日期', '1', '2017-09-27 19:31:54', '2017-09-27 19:31:57', '日期');

-- ----------------------------
-- Table structure for t_column_type
-- ----------------------------
DROP TABLE IF EXISTS `t_column_type`;
CREATE TABLE `t_column_type` (
  `id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `status` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `describe` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='列业务类型';

-- ----------------------------
-- Records of t_column_type
-- ----------------------------
INSERT INTO `t_column_type` VALUES ('1', '系统', '1', '2017-09-27 19:25:46', '2017-09-27 19:25:46', '系统默认');
INSERT INTO `t_column_type` VALUES ('2', '业务', '1', '2017-09-27 19:25:56', '2017-09-27 19:25:56', '业务');
INSERT INTO `t_column_type` VALUES ('3', '虚拟', '1', '2017-09-28 10:58:31', '2017-09-28 10:58:31', '虚拟字段');

-- ----------------------------
-- Table structure for t_table_status
-- ----------------------------
DROP TABLE IF EXISTS `t_table_status`;
CREATE TABLE `t_table_status` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `status` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `describe` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_table_status
-- ----------------------------
INSERT INTO `t_table_status` VALUES ('1', '正常', '1', '2017-09-27 16:46:22', '2017-09-27 16:46:22', '运转正常 未被删除的');
INSERT INTO `t_table_status` VALUES ('2', '删除', '1', '2017-09-27 16:46:54', '2017-09-27 16:54:15', '删除的');

-- ----------------------------
-- Table structure for t_table_structure_type
-- ----------------------------
DROP TABLE IF EXISTS `t_table_structure_type`;
CREATE TABLE `t_table_structure_type` (
  `id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `status` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `describe` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_table_structure_type
-- ----------------------------
INSERT INTO `t_table_structure_type` VALUES ('1', '对象', '1', '2017-09-27 16:55:55', '2017-09-27 16:56:33', '对象');
INSERT INTO `t_table_structure_type` VALUES ('2', '键值对', '1', '2017-09-27 16:56:30', '2017-09-27 16:56:37', '键值对');

-- ----------------------------
-- Table structure for t_table_type
-- ----------------------------
DROP TABLE IF EXISTS `t_table_type`;
CREATE TABLE `t_table_type` (
  `id` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `status` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `describe` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_table_type
-- ----------------------------
INSERT INTO `t_table_type` VALUES ('1', '系统表', '1', '2017-09-27 16:53:43', '2017-09-27 16:54:04', '系统表');
INSERT INTO `t_table_type` VALUES ('2', '业务表', '1', '2017-09-27 16:54:00', '2017-09-27 16:54:00', '业务表');
