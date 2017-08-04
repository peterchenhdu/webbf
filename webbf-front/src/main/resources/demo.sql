/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2016-07-08 11:35:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小陈', '杭州市');
INSERT INTO `user` VALUES ('4', 'user001', 'HangZhou');
INSERT INTO `user` VALUES ('38', '99', '9999999');
INSERT INTO `user` VALUES ('42', '877', '877878');
INSERT INTO `user` VALUES ('44', '9', '9');
INSERT INTO `user` VALUES ('45', '1212', '121212');
INSERT INTO `user` VALUES ('46', '5', '5');
INSERT INTO `user` VALUES ('47', '999', '999999999');

-- ----------------------------
-- View structure for `view_user_course`
-- ----------------------------
DROP VIEW IF EXISTS `view_user_course`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_user_course` AS (select `uc`.`id` AS `id`,`u`.`name` AS `username`,`c`.`name` AS `coursename` from ((`user` `u` left join `user_course` `uc` on((`u`.`id` = `uc`.`userid`))) left join `course` `c` on((`uc`.`courseid` = `c`.`id`)))) ;

-- ----------------------------
-- View structure for `view_user_keyinfo`
-- ----------------------------
DROP VIEW IF EXISTS `view_user_keyinfo`;
