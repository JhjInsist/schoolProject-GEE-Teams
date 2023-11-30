/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50741
 Source Host           : localhost:3306
 Source Schema         : keshe

 Target Server Type    : MySQL
 Target Server Version : 50741
 File Encoding         : 65001

 Date: 16/11/2023 00:27:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for competition
-- ----------------------------
DROP TABLE IF EXISTS `competition`;
CREATE TABLE `competition`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `deleted` int(1) UNSIGNED NULL DEFAULT 0 COMMENT '删除状态',
  `details` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '详情',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '海报url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of competition
-- ----------------------------
INSERT INTO `competition` VALUES (1, '计算机设计大赛', '你好', '2023-03-15', '2023-03-18', '2023-03-18 21:19:44', '2023-03-18 21:19:44', 0, NULL, NULL);

-- ----------------------------
-- Table structure for download_record
-- ----------------------------
DROP TABLE IF EXISTS `download_record`;
CREATE TABLE `download_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `download_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `deleted` int(1) NULL DEFAULT NULL,
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `competition_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `file_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `download_record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of download_record
-- ----------------------------
INSERT INTO `download_record` VALUES (11, 2, '2023-03-19 09:39:24', 0, 'sxx-files/2023-03-18/2023-03-18a9b6b532-2746-43f1-b9c2-8c357df8863f证件照.jpg', 'abc', '123', '计算机设计大赛', '文本');
INSERT INTO `download_record` VALUES (12, 2, '2023-03-19 09:39:24', 0, 'sxx-files/2023-03-18/2023-03-180e653151-c0a3-4330-9922-3b5aa8b957dc证件照正装.jpg', 'abc', '123', '计算机设计大赛', '文本');
INSERT INTO `download_record` VALUES (13, 2, '2023-03-19 09:39:25', 0, 'sxx-files/2023-03-19/2023-03-1958c859d6-2a7b-40c2-8f0a-b047492cfb2b证件照.jpg', '你好啊', '咪咪咪', '计算机设计大赛', '文本');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sender_id` int(11) NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `read_status` tinyint(1) NOT NULL DEFAULT 0,
  `deleted` int(1) UNSIGNED NULL DEFAULT 0 COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sender_id`(`sender_id`) USING BTREE,
  INDEX `receiver_id`(`receiver_id`) USING BTREE,
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`sender_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`receiver_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 'root', 1, 1, '你好', '2023-03-18 21:19:44', '2023-11-16 00:21:17', 1, 0);
INSERT INTO `message` VALUES (2, 'root', 1, 1, '2222', '2023-03-18 22:08:35', '2023-11-16 00:21:17', 0, 0);
INSERT INTO `message` VALUES (3, 'root', 1, 1, '你好', '2023-03-18 21:19:44', '2023-11-16 00:21:17', 0, 0);
INSERT INTO `message` VALUES (4, 'root', 1, 1, '2222', '2023-03-18 22:08:35', '2023-11-16 00:21:17', 0, 0);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uploader_id` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `deleted` int(1) NULL DEFAULT NULL,
  `competition_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `file_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uploader_id`(`uploader_id`) USING BTREE,
  CONSTRAINT `resource_ibfk_1` FOREIGN KEY (`uploader_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (16, 2, 'abc', '123', 'sxx-files/2023-03-18/2023-03-18a9b6b532-2746-43f1-b9c2-8c357df8863f证件照.jpg', '2023-03-18 11:57:00', '2023-03-19 09:35:16', 0, '计算机设计大赛', '文本');
INSERT INTO `resource` VALUES (17, 2, 'abc', '123', 'sxx-files/2023-03-18/2023-03-180e653151-c0a3-4330-9922-3b5aa8b957dc证件照正装.jpg', '2023-03-18 14:53:51', '2023-03-19 09:35:16', 0, '计算机设计大赛', '文本');
INSERT INTO `resource` VALUES (18, 2, '你好啊', '咪咪咪', 'sxx-files/2023-03-19/2023-03-1958c859d6-2a7b-40c2-8f0a-b047492cfb2b证件照.jpg', '2023-03-19 08:43:15', '2023-03-19 09:35:16', 0, '计算机设计大赛', '文本');
INSERT INTO `resource` VALUES (19, 2, '啊啊啊啊', '阿斯顿撒旦', 'sxx-files/2023-03-19/2023-03-1937c753bb-66f6-4059-9861-a5cca56c5549证件照正装.jpg', '2023-03-19 08:45:21', '2023-03-19 09:35:16', 0, '计算机设计大赛', '文本');
INSERT INTO `resource` VALUES (20, 2, '啊啊啊啊', '阿斯顿撒旦', 'sxx-files/2023-03-19/2023-03-19a2645c8e-9d7d-42ef-86ce-1dc1d42867a0证件照正装.jpg', '2023-03-19 08:45:37', '2023-03-19 09:35:16', 0, '计算机设计大赛', '文本');
INSERT INTO `resource` VALUES (21, 2, '啊啊啊啊', '阿斯顿撒旦', 'sxx-files/2023-03-19/2023-03-19b5675205-bfb1-4f10-a8ed-1da597cc82c2证件照正装.jpg', '2023-03-19 08:46:27', '2023-03-19 09:35:16', 0, '计算机设计大赛', '文本');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `team_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '小队名称',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `deleted` int(1) UNSIGNED NULL DEFAULT 0 COMMENT '删除状态',
  `leader_id` int(11) NOT NULL COMMENT '负责人id',
  `leader_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人姓名',
  `Institution_province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '机构省份',
  `Institution_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '机构名称',
  `leader_gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '队长性别',
  `leader_phonenum` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '队长联系方式',
  `team_request` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组队需求',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (NULL, 1, '2023-03-15 01:23:42', '2023-11-16 00:15:28', 1, 1, 'root', 'shanghai', '清华大学', '1', '15324161007', 'asd');
INSERT INTO `team` VALUES (NULL, 2, '2023-03-18 15:57:16', '2023-11-16 00:15:28', 1, 2, '贾宏佳', 'shanghai', '清华大学', '1', '15324161007', 'asd');
INSERT INTO `team` VALUES (NULL, 3, '2023-03-18 15:58:22', '2023-11-16 00:15:28', 1, 2, '贾宏佳', 'shanghai', '清华大学', '1', '15324161007', 'asd');
INSERT INTO `team` VALUES (NULL, 4, '2023-03-18 16:00:06', '2023-11-16 00:15:28', 0, 1, '贾宏佳', 'shanghai', '清华大学', '1', '15324161007', 'asd');
INSERT INTO `team` VALUES (NULL, 5, '2023-03-18 16:01:29', '2023-11-16 00:15:28', 0, 2, '张壮东', 'shanghai', '清华大学', '1', '15324161007', 'asd');
INSERT INTO `team` VALUES (NULL, 6, '2023-03-19 09:47:39', '2023-11-16 00:15:37', 1, 2, '111', 'shanghai', '清华大学', '1', '15324161007', 'asd');
INSERT INTO `team` VALUES (NULL, 7, '2023-03-19 09:51:56', '2023-11-16 00:15:37', 1, 2, '123', 'shanghai', '清华大学', '1', '15324161007', 'asd');
INSERT INTO `team` VALUES (NULL, 8, '2023-03-19 09:53:27', '2023-11-16 00:15:37', 1, 2, '1', 'shanghai', '清华大学', '1', '15324161007', 'asd');
INSERT INTO `team` VALUES (NULL, 9, '2023-03-19 10:16:28', '2023-11-16 00:15:28', 0, 2, 'asda', 'shanghai', '清华大学', '1', '15324161007', 'asd');
INSERT INTO `team` VALUES (NULL, 10, '2023-03-19 10:26:52', '2023-11-16 00:15:37', 0, 2, 'a', 'shanghai', '清华大学', '1', '15324161007', 'asd');
INSERT INTO `team` VALUES (NULL, 11, '2023-03-19 12:35:04', '2023-11-16 00:15:37', 1, 2, '张壮东', 'shanghai', '清华大学', '1', '15324161007', 'asd');
INSERT INTO `team` VALUES ('ada', 13, '2023-11-16 00:13:57', '2023-11-16 00:15:37', 0, 1, '贾宏佳', 'shanghai', '清华大学', '1', '15324161007', 'asd');
INSERT INTO `team` VALUES ('123', 14, '2023-11-16 00:17:09', '2023-11-16 00:17:09', 0, 1, '贾宏佳', 'beijing', '北京大学', '1', '15324161007', 'asdas');

-- ----------------------------
-- Table structure for team_application
-- ----------------------------
DROP TABLE IF EXISTS `team_application`;
CREATE TABLE `team_application`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sender_id` int(11) NOT NULL,
  `leader_id` int(11) NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `accept` tinyint(1) NULL DEFAULT 0,
  `deleted` int(1) UNSIGNED NULL DEFAULT 0 COMMENT '删除状态',
  `team_id` int(11) NULL DEFAULT NULL COMMENT '队伍id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sender_id`(`sender_id`) USING BTREE,
  INDEX `receiver_id`(`leader_id`) USING BTREE,
  CONSTRAINT `team_application_ibfk_1` FOREIGN KEY (`sender_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `team_application_ibfk_2` FOREIGN KEY (`leader_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team_application
-- ----------------------------
INSERT INTO `team_application` VALUES (1, 'root', 1, 2, '你好', '2023-03-18 21:19:44', '2023-03-18 21:19:44', 1, 1, NULL);
INSERT INTO `team_application` VALUES (2, 'root', 1, 2, '2222', '2023-03-18 22:08:35', '2023-03-18 22:26:03', 0, 1, NULL);
INSERT INTO `team_application` VALUES (3, 'root', 1, 2, '你好', '2023-03-18 21:19:44', '2023-03-18 22:26:03', 0, 1, NULL);
INSERT INTO `team_application` VALUES (4, 'root', 1, 2, '2222', '2023-03-18 22:08:35', '2023-03-18 22:26:03', 0, 0, NULL);

-- ----------------------------
-- Table structure for team_member
-- ----------------------------
DROP TABLE IF EXISTS `team_member`;
CREATE TABLE `team_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `deleted` int(1) UNSIGNED NULL DEFAULT 0 COMMENT '删除状态',
  `team_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `team_id`(`team_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `team_member_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `team_member_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team_member
-- ----------------------------
INSERT INTO `team_member` VALUES (1, 13, 1, '2023-11-16 00:13:57', '2023-11-16 00:13:57', 0, NULL);
INSERT INTO `team_member` VALUES (3, 14, 1, '2023-11-16 00:17:09', '2023-11-16 00:17:09', 0, NULL);

-- ----------------------------
-- Table structure for team_record
-- ----------------------------
DROP TABLE IF EXISTS `team_record`;
CREATE TABLE `team_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) NOT NULL,
  `team_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `deleted` int(1) NULL DEFAULT NULL,
  `team_leader` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `leader_contact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `match_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `match_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `team_id`(`team_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `team_record_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `team_record_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team_record
-- ----------------------------
INSERT INTO `team_record` VALUES (1, 1, '你好对', 1, '2023-03-17 00:19:11', '2023-03-18 16:44:00', 1, 'root', '18525397003', '计算机设计大赛', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `cantact` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `deleted` int(1) UNSIGNED NULL DEFAULT 0 COMMENT '删除状态',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `school` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学校',
  `gender` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省份',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `permeryKey`(`phone_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', '12345678', 'jhj_insist@outlool.com', '2023-03-15 00:32:07', '2023-11-15 23:33:10', 1, '贾宏佳', '大连工业大学', '男', '15324161007', '辽宁', NULL);
INSERT INTO `user` VALUES (2, 'user', '12345678', 'jhj_insist@outlool.com', '2023-03-15 00:32:07', '2023-11-15 23:33:12', 0, '张壮东', '大连工业大学', '男', '18525397003', '辽宁', NULL);
INSERT INTO `user` VALUES (3, 'user1', '12345678', 'jhj_insist@outlool.com', '2023-03-15 00:32:07', '2023-11-15 23:33:15', 0, '张壮东', '大连工业大学', '男', NULL, '北京', NULL);
INSERT INTO `user` VALUES (4, 'user2', '12345678', 'jhj_insist@outlool.com', '2023-03-15 00:32:07', '2023-11-15 23:33:17', 0, '张壮东', '大连工业大学', '男', NULL, '杭州', NULL);
INSERT INTO `user` VALUES (5, '', '12345678', '', '2023-11-14 20:54:01', '2023-11-16 00:14:25', 0, 'jhj', '大连工业大学', '女', '15324161008', 'shanghai', 'asd');

SET FOREIGN_KEY_CHECKS = 1;
