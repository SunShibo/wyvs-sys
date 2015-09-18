/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : wyvs-working-platform

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-09-18 18:44:31
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `pms_member_info` VALUES ('1005', null, null, '1', '孙诗博', 'SUN SHI BO', '1', null, null, '', '', '', '', '', '', '18601117545', '', '11111@qq.com', '00000@skype.com', null, '2015-08-14 17:38:04', null, null, '2015-08-14 17:38:04', '0', '1', '测试数据', null, null, 'P3', 'CTO(首席技术官)');

-- ----------------------------
-- Table structure for `pms_member_quit`
-- ----------------------------
DROP TABLE IF EXISTS `pms_member_quit`;
CREATE TABLE `pms_member_quit` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '离职申请表',
  `member_id` int(9) DEFAULT NULL COMMENT '退会会员id',
  `member_name` varchar(50) DEFAULT NULL COMMENT '退会会员名字',
  `english_name` varchar(100) DEFAULT NULL COMMENT '退会会员英文名',
  `department` varchar(100) DEFAULT NULL COMMENT '部门',
  `job_grade` varchar(10) DEFAULT NULL COMMENT '职级',
  `create_time` datetime DEFAULT NULL COMMENT '记录创建时间',
  `last_date` date DEFAULT NULL COMMENT '退会会员的最后工作日期',
  `join_date` date DEFAULT NULL COMMENT '退会会员的加入时间',
  `description` varchar(1000) DEFAULT NULL COMMENT '离职原因描述',
  `lister_id` int(9) DEFAULT NULL COMMENT '制表人id',
  `lister_name` varchar(50) DEFAULT NULL COMMENT '制表人名字',
  `status` varchar(50) DEFAULT NULL COMMENT '状态  PASS通过  reject驳回 ，',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_member_quit
-- ----------------------------
INSERT INTO `pms_member_quit` VALUES ('1', '1005', '孙诗博/SUN SHI BO', 'SUN SHI BO', null, 'P3', '2015-08-27 17:41:39', '2015-08-26', '2015-08-14', 'test', '1003', '金琪斌', 'new');

-- ----------------------------
-- Table structure for `pms_permission`
-- ----------------------------
DROP TABLE IF EXISTS `pms_permission`;
CREATE TABLE `pms_permission` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(70) DEFAULT NULL,
  `is_menu` varchar(5) DEFAULT NULL,
  `parent_id` int(9) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `unique_flag` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `pms_role`
-- ----------------------------
DROP TABLE IF EXISTS `pms_role`;
CREATE TABLE `pms_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `level` int(2) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `permission_ids` varchar(500) DEFAULT NULL COMMENT '权限id集合，通过","分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_role
-- ----------------------------
INSERT INTO `pms_role` VALUES ('1', 'Administrator', '1', '系统最高管理员', null, '2015-09-18 14:30:33', 'ALL');
INSERT INTO `pms_role` VALUES ('2', '部长角色', null, '各部门部长角色', null, '2015-09-18 17:13:34', null);
INSERT INTO `pms_role` VALUES ('3', '副部长角色', null, '各部门副部长角色', null, '2015-09-22 17:13:28', null);

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
-- Table structure for `pms_task`
-- ----------------------------
DROP TABLE IF EXISTS `pms_task`;
CREATE TABLE `pms_task` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `subject` varchar(100) DEFAULT NULL COMMENT '主题',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL COMMENT '计划结束时间',
  `content` varchar(2000) DEFAULT NULL COMMENT '内容',
  `create_user` int(9) DEFAULT NULL COMMENT '创建人',
  `status` varchar(50) DEFAULT NULL COMMENT '状态',
  `level` varchar(50) DEFAULT NULL COMMENT '任务级别',
  `finish_time` datetime DEFAULT NULL COMMENT '最总完成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12522 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_task
-- ----------------------------
INSERT INTO `pms_task` VALUES ('10000', '测试的任务', '2015-09-09 13:56:11', '2015-09-11 15:35:48', '2015-09-09 13:56:13', '这是一条测试数据，测试时间：2015/09/09.', '1001', 'Finish', 'Middle', '2015-09-09 13:56:53');
INSERT INTO `pms_task` VALUES ('10001', '不可能完成的任务', '2015-09-09 18:07:57', '2015-09-11 15:35:51', '2015-09-11 15:36:02', '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1001', 'Finish', 'Middle', null);
INSERT INTO `pms_task` VALUES ('10003', '搞定大魔王', '2015-09-10 10:37:47', '2015-09-11 15:35:53', '2015-09-11 15:36:05', '<h1><u>解决大魔王，有奖励。。。<small></small></u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1001', 'Finish', 'High', null);
INSERT INTO `pms_task` VALUES ('10004', '消灭敌人', '2015-09-10 16:50:49', '2015-09-11 15:35:56', '2015-09-11 15:36:07', '<h1><u>打到敌人。。。。<small>﻿</small></u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1001', 'Finish', 'Low', null);
INSERT INTO `pms_task` VALUES ('12506', '攻打小日本', '2015-09-10 17:22:35', '2015-09-11 15:35:59', '2015-09-11 15:36:10', '<h1><u>打到日本军国主义，打到法西斯。</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1001', 'Finish', 'Low', null);
INSERT INTO `pms_task` VALUES ('12507', '测试新任务', '2015-09-16 14:35:32', '2015-09-15 18:31:12', '2015-09-29 18:31:15', '<h1><u>测试任务模块</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>Shibo Sun</p>', '1003', 'Close', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12508', '去淘宝买U盘', '2015-09-16 14:58:22', '2015-09-09 18:31:18', '2015-09-30 18:31:23', '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'Close', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12509', '淘宝买钢笔', '2015-09-16 14:59:10', '2015-09-08 18:52:05', '2015-09-21 18:52:08', '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'New', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12510', '准备支教前的课件', '2015-09-16 15:06:26', '2015-09-21 18:52:11', '2015-09-28 18:52:14', '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'Close', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12511', '测试任务', '2015-09-16 16:53:28', null, null, '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'New', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12512', '测试任务', '2015-09-16 16:53:51', null, null, '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'New', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12513', '测试小任务', '2015-09-16 17:15:53', null, null, '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'New', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12514', '购买易耗品', '2015-09-16 18:22:52', null, null, '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'New', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12515', '购买蔬菜', '2015-09-16 18:23:46', null, null, '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'New', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12516', '买证书纸张', '2015-09-16 18:29:32', null, null, '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'New', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12517', '给小孩买钢笔', '2015-09-16 18:30:53', null, null, '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'New', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12518', '修篮球场', '2015-09-16 18:49:12', '2015-09-17 00:00:00', null, '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'New', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12519', '买修篮球场需要的材料', '2015-09-16 18:49:58', '2015-09-23 00:00:00', null, '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'New', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12520', '召集人员', '2015-09-16 18:51:31', '2015-09-10 00:00:00', null, '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'New', 'Middle', null);
INSERT INTO `pms_task` VALUES ('12521', '去赶集买菜', '2015-09-16 18:51:59', '2015-09-09 00:00:00', '2015-09-30 00:00:00', '<h1><u>Heading Of Message</u></h1>\n                      <h4>Subheading</h4>\n                      <p>请输入一些描述......</p>\n                      <ul>\n                          <li>List item one</li>\n                          <li>List item two</li>\n                          <li>List item three</li>\n                          <li>List item four</li>\n                      </ul>\n                      <p>Thank you,</p>\n                      <p>John Doe</p>', '1003', 'Close', 'Middle', null);

-- ----------------------------
-- Table structure for `pms_task_user`
-- ----------------------------
DROP TABLE IF EXISTS `pms_task_user`;
CREATE TABLE `pms_task_user` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `task_id` int(9) DEFAULT NULL,
  `member_id` int(9) DEFAULT NULL,
  `member_name` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_task_user
-- ----------------------------
INSERT INTO `pms_task_user` VALUES ('1', '12506', '1003', '金琪斌', '2015-09-11 16:37:10');
INSERT INTO `pms_task_user` VALUES ('2', '12506', '1004', '孙诗博', '2015-09-14 10:47:09');
INSERT INTO `pms_task_user` VALUES ('3', '10000', '1005', null, '2015-09-14 10:49:25');
INSERT INTO `pms_task_user` VALUES ('4', '10000', '1006', null, '2015-09-14 10:49:40');
INSERT INTO `pms_task_user` VALUES ('5', '12507', '1003', '金琪斌', '2015-09-16 14:35:49');
INSERT INTO `pms_task_user` VALUES ('6', '12508', '1003', '金琪斌', '2015-09-16 15:13:03');
INSERT INTO `pms_task_user` VALUES ('7', '10003', '1003', '金琪斌', '2015-09-16 16:12:38');
INSERT INTO `pms_task_user` VALUES ('8', '12510', '1003', '金琪斌', '2015-09-16 16:15:31');
INSERT INTO `pms_task_user` VALUES ('9', '12521', '1003', '金琪斌', '2015-09-17 10:45:24');
