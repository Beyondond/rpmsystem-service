/*
 Navicat Premium Data Transfer

 Source Server         : epq
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : rpm_system

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 05/08/2019 09:07:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rpm_department
-- ----------------------------
DROP TABLE IF EXISTS `rpm_department`;
CREATE TABLE `rpm_department`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `dp_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `paternal_id` bigint(20) NULL DEFAULT NULL COMMENT '上级部门id  为空表明没有上级部门',
  `created_num_uid` int(10) NULL DEFAULT NULL COMMENT '创建人工号',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = ' ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rpm_member
-- ----------------------------
DROP TABLE IF EXISTS `rpm_member`;
CREATE TABLE `rpm_member`  (
  `num_uid` int(10) NOT NULL COMMENT '员工工号 主键id',
  `mem_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '员工姓名',
  `mem_gender` int(1) NULL DEFAULT NULL COMMENT '员工性别(1男2女)',
  `mem_level` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '级别',
  `education` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '学历',
  `major` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '专业',
  `eng_level` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '英语等级',
  `gra_school` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '毕业学校',
  `gra_time` date NULL DEFAULT NULL COMMENT '毕业时间',
  `init_position_time` date NULL DEFAULT NULL COMMENT '入职时间 ',
  `init_project_time` date NULL DEFAULT NULL COMMENT '入项时间',
  `technology_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '技术类型',
  `platform_system` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '平台系统',
  `phoneNum` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '电话号码（唯一）',
  `identityId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '身份证号（唯一）',
  `mailbox` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '个人邮箱（唯一）',
  `technology_years` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '技术年限 ',
  `hw_exp` int(1) NULL DEFAULT 0 COMMENT '是否有华为经验 （1有0没有）',
  `past_corp` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '过往公司',
  `project_exp` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '项目经验 ',
  `input_num_uid` int(10) NULL DEFAULT NULL COMMENT '录入人员工号',
  `input_time` datetime(0) NULL DEFAULT NULL COMMENT '录入时间',
  `position_status` int(1) NULL DEFAULT NULL COMMENT '是否在职（1在职 0离职）',
  `status` int(1) NULL DEFAULT 1 COMMENT '数据状态（1正常0删除）',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`num_uid`) USING BTREE,
  UNIQUE INDEX `identityId`(`identityId`) USING BTREE,
  UNIQUE INDEX `mailbox`(`mailbox`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '人员基本信息 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rpm_member_department
-- ----------------------------
DROP TABLE IF EXISTS `rpm_member_department`;
CREATE TABLE `rpm_member_department`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `num_uid` int(10) NULL DEFAULT NULL COMMENT '员工工号',
  `dp_id` bigint(20) NULL DEFAULT NULL COMMENT '部门Id',
  `created_num_uid` int(10) NULL DEFAULT NULL COMMENT '创建人工号',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = ' ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rpm_member_ext
-- ----------------------------
DROP TABLE IF EXISTS `rpm_member_ext`;
CREATE TABLE `rpm_member_ext`  (
  `inum_id` int(10) NOT NULL COMMENT '员工工号 主键id',
  `colum_name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '列',
  PRIMARY KEY (`inum_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '人员信息扩展表 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rpm_member_role
-- ----------------------------
DROP TABLE IF EXISTS `rpm_member_role`;
CREATE TABLE `rpm_member_role`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `num_uid` int(10) NULL DEFAULT NULL COMMENT '员工工号 ',
  `mem_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名字',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色Id ',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户密码 ',
  `created_num_uid` int(10) NULL DEFAULT NULL COMMENT '创建人工号 ',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '人员角色 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rpm_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `rpm_operate_log`;
CREATE TABLE `rpm_operate_log`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `skill` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '技能',
  `operate_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '操作内容',
  `operate_result` int(11) NULL DEFAULT NULL COMMENT '操作结果(1、true 0、false)',
  `operate_num_uid` int(11) NULL DEFAULT NULL COMMENT '操作工号',
  `operate_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rpm_role
-- ----------------------------
DROP TABLE IF EXISTS `rpm_role`;
CREATE TABLE `rpm_role`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `role_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '角色名称',
  `skills` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '技能 ',
  `created_num_uid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人工号 ',
  `colum_name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '基本信息列展示 ',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间 ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = ' ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rpm_setting
-- ----------------------------
DROP TABLE IF EXISTS `rpm_setting`;
CREATE TABLE `rpm_setting`  (
  `id` bigint(20) NOT NULL COMMENT '主键id ',
  `setting_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '配置名称',
  `skill` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '所属技能',
  `setting_value` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '配置内容',
  `enable_status` int(10) NULL DEFAULT NULL COMMENT '是否启用 1启用2未启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '配置信息 ' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rpm_skill_info
-- ----------------------------
DROP TABLE IF EXISTS `rpm_skill_info`;
CREATE TABLE `rpm_skill_info`  (
  `id` int(10) NOT NULL COMMENT '主键id',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `skill_desc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '角色技能描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色配置表 ' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
