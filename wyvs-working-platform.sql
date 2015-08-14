/*
Navicat MySQL Data Transfer

Source Server         : location
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : wyvs-working-platform

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-08-14 18:19:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pms_departmentinfo`
-- ----------------------------
DROP TABLE IF EXISTS `pms_departmentinfo`;
CREATE TABLE `pms_departmentinfo` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parentId` int(9) DEFAULT NULL,
  `flagId` varchar(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `delFlag` int(4) DEFAULT NULL,
  `enabledState` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_departmentinfo
-- ----------------------------
INSERT INTO `pms_departmentinfo` VALUES ('1', '总部', '1', '1,', '2014-02-14', '0', '1');
INSERT INTO `pms_departmentinfo` VALUES ('4', '中国', '1', '1,4,', '2014-02-14', '0', '1');
INSERT INTO `pms_departmentinfo` VALUES ('5', '加拿大', '1', '1,5,', '2014-02-14', '0', '1');
INSERT INTO `pms_departmentinfo` VALUES ('6', '美国', '1', '1,6,', '2014-02-14', '0', '1');
INSERT INTO `pms_departmentinfo` VALUES ('8', '秘书部', '4', '1,4,8,', '2014-02-14', '0', '1');
INSERT INTO `pms_departmentinfo` VALUES ('9', '人事部', '4', '1,4,9,', '2014-02-14', '0', '1');
INSERT INTO `pms_departmentinfo` VALUES ('10', '外联部', '4', '1,4,10,', '2014-02-14', '0', '1');
INSERT INTO `pms_departmentinfo` VALUES ('12', '活动部', '4', '1,4,12,', '2014-02-14', '0', '1');
INSERT INTO `pms_departmentinfo` VALUES ('13', '宣传部', '4', '1,4,13,', '2014-02-14', '0', '1');
INSERT INTO `pms_departmentinfo` VALUES ('14', '山东分会', '4', '1,4,14,', '2014-02-14', '0', '1');
INSERT INTO `pms_departmentinfo` VALUES ('16', '技术部', '8', '1,4,8,16,', '2014-02-14', '0', '1');
INSERT INTO `pms_departmentinfo` VALUES ('17', '百合处', '9', '1,4,9,17,', '2014-02-14', '0', '1');
INSERT INTO `pms_departmentinfo` VALUES ('18', '韩国', '1', '1,18,', '2014-02-15', '1', '1');

-- ----------------------------
-- Table structure for `pms_department_info`
-- ----------------------------
DROP TABLE IF EXISTS `pms_department_info`;
CREATE TABLE `pms_department_info` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parentId` int(9) DEFAULT NULL,
  `flagId` varchar(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `delFlag` int(4) DEFAULT NULL,
  `enabledState` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_department_info
-- ----------------------------
INSERT INTO `pms_department_info` VALUES ('1', '总部', '1', '1,', '2014-02-14', '0', '1');
INSERT INTO `pms_department_info` VALUES ('4', '中国', '1', '1,4,', '2014-02-14', '0', '1');
INSERT INTO `pms_department_info` VALUES ('5', '加拿大', '1', '1,5,', '2014-02-14', '0', '1');
INSERT INTO `pms_department_info` VALUES ('6', '美国', '1', '1,6,', '2014-02-14', '0', '1');
INSERT INTO `pms_department_info` VALUES ('8', '秘书部', '4', '1,4,8,', '2014-02-14', '0', '1');
INSERT INTO `pms_department_info` VALUES ('9', '人事部', '4', '1,4,9,', '2014-02-14', '0', '1');
INSERT INTO `pms_department_info` VALUES ('10', '外联部', '4', '1,4,10,', '2014-02-14', '0', '1');
INSERT INTO `pms_department_info` VALUES ('12', '活动部', '4', '1,4,12,', '2014-02-14', '0', '1');
INSERT INTO `pms_department_info` VALUES ('13', '宣传部', '4', '1,4,13,', '2014-02-14', '0', '1');
INSERT INTO `pms_department_info` VALUES ('14', '山东分会', '4', '1,4,14,', '2014-02-14', '0', '1');
INSERT INTO `pms_department_info` VALUES ('16', '技术部', '8', '1,4,8,16,', '2014-02-14', '0', '1');
INSERT INTO `pms_department_info` VALUES ('17', '百合处', '9', '1,4,9,17,', '2014-02-14', '0', '1');
INSERT INTO `pms_department_info` VALUES ('18', '韩国', '1', '1,18,', '2014-02-15', '1', '1');
INSERT INTO `pms_department_info` VALUES ('19', '纽约', '6', '1,6,19,', '2014-07-26', '0', '1');

-- ----------------------------
-- Table structure for `pms_member_department`
-- ----------------------------
DROP TABLE IF EXISTS `pms_member_department`;
CREATE TABLE `pms_member_department` (
  `id` int(9) NOT NULL DEFAULT '0' COMMENT '主键',
  `member_id` int(9) NOT NULL COMMENT '会员id',
  `department_id` int(9) NOT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `state` int(9) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_member_department
-- ----------------------------

-- ----------------------------
-- Table structure for `pms_member_info`
-- ----------------------------
DROP TABLE IF EXISTS `pms_member_info`;
CREATE TABLE `pms_member_info` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `password` varchar(60) DEFAULT NULL COMMENT '密码',
  `role_id` int(9) DEFAULT NULL COMMENT '角色id',
  `enabled_state` int(9) DEFAULT NULL COMMENT '开通状态  0锁定  1正常',
  `name` varchar(20) DEFAULT NULL COMMENT '名字',
  `english_name` varchar(30) DEFAULT NULL COMMENT '英文名',
  `gender` int(2) DEFAULT NULL COMMENT '新别：0女 1男',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `education_background` int(4) DEFAULT NULL COMMENT '学历',
  `university` varchar(50) DEFAULT NULL COMMENT '大学',
  `major` varchar(50) DEFAULT NULL COMMENT '专业',
  `nationality` varchar(50) DEFAULT NULL COMMENT '国籍',
  `native_place` varchar(50) DEFAULT NULL COMMENT '籍贯',
  `residence_country` varchar(50) DEFAULT NULL COMMENT '现居住国家',
  `residence_city` varchar(50) DEFAULT NULL COMMENT '现在居住城市',
  `phone` varchar(30) DEFAULT NULL COMMENT '手机号',
  `qq` varchar(50) DEFAULT NULL COMMENT 'qq',
  `email` varchar(50) DEFAULT NULL COMMENT 'email',
  `skype` varchar(30) DEFAULT NULL COMMENT '部门id',
  `photo` varchar(300) DEFAULT NULL COMMENT '照片路径',
  `join_time` datetime DEFAULT NULL COMMENT '加入时间',
  `positive_time` datetime DEFAULT NULL COMMENT '转正时间',
  `quit_time` datetime DEFAULT NULL COMMENT '退会时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `del_flag` int(9) DEFAULT NULL,
  `state` int(9) DEFAULT NULL COMMENT '状态id：1正式会员 2退会',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注',
  `description` varchar(300) DEFAULT NULL COMMENT '个人描述',
  `address` varchar(300) DEFAULT NULL COMMENT '地址',
  `job_grade` varchar(10) DEFAULT NULL COMMENT '职级',
  `title` varchar(100) DEFAULT NULL COMMENT '职务',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_member_info
-- ----------------------------
INSERT INTO `pms_member_info` VALUES ('1003', '7c4a8d09ca3762af61e59520943dc26494f8941b', '1', '1', '金琪斌', 'Qibin', '1', '2014-02-28', null, 'XX大学', '英语', '中国', '天津', '美国1', '波士顿1', '18601117545', '123456789', '395831708@qq.com', '395831708@qq.com', '../wyvs/member/1003/headPortrait/1420972207651.jpg', '2014-02-28 00:00:00', '2014-02-28 00:00:00', '2014-02-28 00:00:00', null, '0', '1', '测试数据', '', '美国XX街道', null, '纪检委');
INSERT INTO `pms_member_info` VALUES ('1004', null, null, null, '孙诗博', 'shibo', '1', null, null, '', '', '', '', '', '', '', null, '', '', '../wyvs/member/1004/headPortrait/1420969512711.png', null, null, null, null, '0', null, '', '', '', null, null);
INSERT INTO `pms_member_info` VALUES ('1005', null, null, null, '孙诗博', 'SUN SHI BO', '1', null, null, '', '', '', '', '', '', '18601117545', '', '11111@qq.com', '00000@skype.com', null, '2015-08-14 17:38:04', null, null, '2015-08-14 17:38:04', '0', '1', '测试数据', null, null, 'P3', 'CTO(首席技术官)');

-- ----------------------------
-- Table structure for `pms_permission`
-- ----------------------------
DROP TABLE IF EXISTS `pms_permission`;
CREATE TABLE `pms_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  `level` int(2) DEFAULT NULL,
  `enabled_state` int(2) DEFAULT NULL,
  `is_menu` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_permission
-- ----------------------------
INSERT INTO `pms_permission` VALUES ('1', '目录', null, '0', '0', '1', '1');
INSERT INTO `pms_permission` VALUES ('2', '会员管理', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('3', '志愿者管理', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('4', '部门管理', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('5', '任务管理', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('6', '活动管理', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('7', '报表中心', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('8', '信息交流', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('9', '快速检索', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('10', '异常信息', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('11', '系统设置', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('12', '会员资料维护', 'member!queryAllMemberInfo.action', '2', '2', '1', '1');
INSERT INTO `pms_permission` VALUES ('13', '部门列表', 'department!initDepartmentList.action', '4', '2', '1', '1');
INSERT INTO `pms_permission` VALUES ('14', '新建任务', 'task!initAddTaskInfo.action', '5', '2', '1', '1');
INSERT INTO `pms_permission` VALUES ('15', '数据分析', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('16', '数据报表', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('17', '下载中心', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('18', '我的中心', null, '1', '1', '1', '1');
INSERT INTO `pms_permission` VALUES ('19', '日程安排', 'myCenter!initSchedulePage.action', '18', '2', '1', '1');
INSERT INTO `pms_permission` VALUES ('20', '任务统计分析', 'task!initTaskStatisticAnalysis.action', '5', '2', '1', '1');

-- ----------------------------
-- Table structure for `pms_role_info`
-- ----------------------------
DROP TABLE IF EXISTS `pms_role_info`;
CREATE TABLE `pms_role_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `level` int(2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `permission_ids` varchar(500) DEFAULT NULL COMMENT '权限id集合，通过","分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_role_info
-- ----------------------------
INSERT INTO `pms_role_info` VALUES ('1', 'Administrator', '1', '系统最高管理员', null, null, null);

-- ----------------------------
-- Table structure for `pms_role_permis_link`
-- ----------------------------
DROP TABLE IF EXISTS `pms_role_permis_link`;
CREATE TABLE `pms_role_permis_link` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `role_id` int(9) DEFAULT NULL,
  `permission_id` int(9) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_role_permis_link
-- ----------------------------
INSERT INTO `pms_role_permis_link` VALUES ('1', '1', '1');
INSERT INTO `pms_role_permis_link` VALUES ('2', '1', '2');
INSERT INTO `pms_role_permis_link` VALUES ('3', '1', '3');
INSERT INTO `pms_role_permis_link` VALUES ('4', '1', '4');
INSERT INTO `pms_role_permis_link` VALUES ('5', '1', '5');
INSERT INTO `pms_role_permis_link` VALUES ('6', '1', '6');
INSERT INTO `pms_role_permis_link` VALUES ('7', '1', '7');
INSERT INTO `pms_role_permis_link` VALUES ('8', '1', '8');
INSERT INTO `pms_role_permis_link` VALUES ('9', '1', '9');
INSERT INTO `pms_role_permis_link` VALUES ('10', '1', '10');
INSERT INTO `pms_role_permis_link` VALUES ('11', '1', '11');
INSERT INTO `pms_role_permis_link` VALUES ('12', '1', '12');
INSERT INTO `pms_role_permis_link` VALUES ('13', '1', '13');
INSERT INTO `pms_role_permis_link` VALUES ('14', '1', '14');
INSERT INTO `pms_role_permis_link` VALUES ('15', '1', '15');
INSERT INTO `pms_role_permis_link` VALUES ('16', '1', '16');
INSERT INTO `pms_role_permis_link` VALUES ('17', '1', '17');
INSERT INTO `pms_role_permis_link` VALUES ('18', '1', '18');
INSERT INTO `pms_role_permis_link` VALUES ('19', '1', '19');
INSERT INTO `pms_role_permis_link` VALUES ('20', '1', '20');

-- ----------------------------
-- Table structure for `pms_schedule_info`
-- ----------------------------
DROP TABLE IF EXISTS `pms_schedule_info`;
CREATE TABLE `pms_schedule_info` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `userId` int(9) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `allDay` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_schedule_info
-- ----------------------------
INSERT INTO `pms_schedule_info` VALUES ('1', 'Today is my birthday', '2014-03-29 00:00:00', '2014-03-29 00:00:00', '1', null, null);
INSERT INTO `pms_schedule_info` VALUES ('2', 'get up', '2014-03-29 09:00:00', '2014-03-29 09:30:00', '1', null, null);
INSERT INTO `pms_schedule_info` VALUES ('3', 'test', '2014-03-27 00:00:00', '2014-03-27 00:00:00', '1', null, null);
INSERT INTO `pms_schedule_info` VALUES ('4', 'test2', '2014-03-25 00:00:00', '2014-03-25 00:00:00', '1', null, null);
INSERT INTO `pms_schedule_info` VALUES ('6', 'Airanna\'s birthday', '2014-04-13 00:00:00', '2014-04-13 00:00:00', '1', '今天是京花的生日', null);
INSERT INTO `pms_schedule_info` VALUES ('13', 'test', '2014-04-14 00:00:00', '2014-04-14 00:00:00', '1', null, null);
INSERT INTO `pms_schedule_info` VALUES ('18', 'QiBin\'s birthday', '2014-04-24 00:00:00', '2014-04-24 00:00:00', '1003', null, null);
INSERT INTO `pms_schedule_info` VALUES ('19', 'Boxing\'s Birthday', '2014-04-21 00:00:00', '2014-04-21 00:00:00', '1003', null, null);
INSERT INTO `pms_schedule_info` VALUES ('20', '例会', '2014-06-11 00:00:00', '2014-06-11 00:00:00', '1003', null, null);

-- ----------------------------
-- Table structure for `pms_task_allocation_info`
-- ----------------------------
DROP TABLE IF EXISTS `pms_task_allocation_info`;
CREATE TABLE `pms_task_allocation_info` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `taskId` int(9) DEFAULT NULL COMMENT '任务id',
  `memberId` int(9) DEFAULT NULL COMMENT '认领者id',
  `score` double(4,2) DEFAULT NULL COMMENT '分数',
  `taskState` int(4) DEFAULT NULL COMMENT '任务状态  0是正在处理  1是已完成',
  `claimOrAssign` int(4) DEFAULT NULL COMMENT '任务是自己认领   还是部门分配 0部门分配 1自己认领',
  `submitTime` datetime DEFAULT NULL COMMENT '提交完成任务的时间',
  `joinTime` datetime DEFAULT NULL COMMENT '分配任务时间',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_task_allocation_info
-- ----------------------------

-- ----------------------------
-- Table structure for `pms_task_info`
-- ----------------------------
DROP TABLE IF EXISTS `pms_task_info`;
CREATE TABLE `pms_task_info` (
  `id` int(9) NOT NULL DEFAULT '0',
  `taskName` varchar(60) DEFAULT NULL COMMENT '任务名称',
  `taskDescription` varchar(400) DEFAULT NULL COMMENT '任务描述',
  `startTime` datetime DEFAULT NULL COMMENT '开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '结束时间',
  `departmentFlag` varchar(255) DEFAULT NULL COMMENT '部门标记',
  `taskLevel` int(9) DEFAULT NULL COMMENT '任务等级：1非常紧急，2正常任务',
  `taskStatus` int(9) DEFAULT NULL COMMENT 's任务状态：0未认领  1工作中  2已完成  3已作废',
  `checkStatus` int(9) DEFAULT NULL COMMENT '审核状态：0未审核 1已审核',
  `checkMemberId` int(9) DEFAULT NULL COMMENT '审核人id',
  `checkTime` datetime DEFAULT NULL COMMENT '审核时间',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_task_info
-- ----------------------------

-- ----------------------------
-- Table structure for `pms_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `pms_user_info`;
CREATE TABLE `pms_user_info` (
  `userId` int(4) NOT NULL AUTO_INCREMENT,
  `account` varchar(30) DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `departmentId` int(6) DEFAULT NULL,
  `roleId` int(4) DEFAULT NULL,
  `delState` int(4) DEFAULT NULL,
  `enabledState` int(3) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pms_user_info
-- ----------------------------
INSERT INTO `pms_user_info` VALUES ('1', 'admin', 'admin', 'admin', null, '1', '0', '1');
