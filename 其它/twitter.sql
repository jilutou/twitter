/*
Navicat MySQL Data Transfer

Source Server         : MySql-1
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : twitter

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-12-19 13:59:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL auto_increment,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `picfname` varchar(40) NOT NULL,
  `join` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('11', '954213', 'one', 'no.1', '2007-05-09 18:11:18');
INSERT INTO `admin` VALUES ('22', '415f7a618', 'two', 'no.2', '2006-11-30 13:11:55');
INSERT INTO `admin` VALUES ('33', '786466qw', 'third', 'no.3', '2008-10-21 13:13:04');
INSERT INTO `admin` VALUES ('44', '1q1q2w2w', 'fourth', 'no.4', '2009-12-09 06:42:31');
INSERT INTO `admin` VALUES ('55', '8425139.', 'fifth', 'no.5', '2009-02-23 19:32:05');
INSERT INTO `admin` VALUES ('66', 'qwaskkk', 'sixth', 'no.6', '2010-03-10 20:33:45');
INSERT INTO `admin` VALUES ('77', '85208520+', 'seventh', 'no.7', '2011-09-11 15:15:15');
INSERT INTO `admin` VALUES ('88', '789789.*0', 'eighth', 'no.8', '2011-06-23 09:49:35');
INSERT INTO `admin` VALUES ('99', '```5201235', 'ninth', 'no.9', '2014-10-01 10:01:22');
INSERT INTO `admin` VALUES ('100', '/*-+999co', 'tenth', 'no.10', '2016-05-09 12:26:18');

-- ----------------------------
-- Table structure for bookmarks
-- ----------------------------
DROP TABLE IF EXISTS `bookmarks`;
CREATE TABLE `bookmarks` (
  `uid` varchar(20) NOT NULL,
  `tid` int(11) NOT NULL,
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  KEY `bookmarks_ibfk_1` (`uid`),
  KEY `tid` (`tid`),
  CONSTRAINT `bookmarks_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bookmarks_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `tweets` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookmarks
-- ----------------------------
INSERT INTO `bookmarks` VALUES ('1', '1', '2017-06-09 19:27:00');
INSERT INTO `bookmarks` VALUES ('2', '2', '2017-08-15 20:57:17');
INSERT INTO `bookmarks` VALUES ('3', '3', '2018-03-01 14:36:46');
INSERT INTO `bookmarks` VALUES ('4', '4', '2016-10-28 04:49:06');
INSERT INTO `bookmarks` VALUES ('5', '5', '2016-05-09 16:39:24');
INSERT INTO `bookmarks` VALUES ('6', '6', '2018-09-09 17:14:10');
INSERT INTO `bookmarks` VALUES ('7', '7', '2016-05-24 11:11:11');
INSERT INTO `bookmarks` VALUES ('8', '8', '2014-10-19 12:21:03');
INSERT INTO `bookmarks` VALUES ('9', '9', '2019-04-05 22:30:34');
INSERT INTO `bookmarks` VALUES ('10', '10', '2015-02-14 19:30:50');

-- ----------------------------
-- Table structure for countor
-- ----------------------------
DROP TABLE IF EXISTS `countor`;
CREATE TABLE `countor` (
  `id` int(11) NOT NULL auto_increment,
  `objectid` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of countor
-- ----------------------------

-- ----------------------------
-- Table structure for follows
-- ----------------------------
DROP TABLE IF EXISTS `follows`;
CREATE TABLE `follows` (
  `uid` varchar(20) NOT NULL,
  `to_uid` varchar(20) NOT NULL,
  `time` timestamp NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  KEY `uid` (`uid`),
  KEY `to_uid` (`to_uid`),
  CONSTRAINT `follows_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `follows_ibfk_2` FOREIGN KEY (`to_uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follows
-- ----------------------------
INSERT INTO `follows` VALUES ('2', '9', '2019-12-10 02:51:35');
INSERT INTO `follows` VALUES ('3', '8', '2019-12-10 02:51:39');
INSERT INTO `follows` VALUES ('4', '7', '2019-12-10 02:51:42');
INSERT INTO `follows` VALUES ('5', '6', '2019-12-10 02:51:48');
INSERT INTO `follows` VALUES ('6', '5', '2019-12-10 02:51:56');
INSERT INTO `follows` VALUES ('7', '4', '2019-12-10 02:52:00');
INSERT INTO `follows` VALUES ('8', '3', '2019-12-10 02:52:04');
INSERT INTO `follows` VALUES ('9', '2', '2019-12-10 02:52:08');
INSERT INTO `follows` VALUES ('10', '1', '2019-12-10 02:52:12');
INSERT INTO `follows` VALUES ('1', '9', '2019-12-10 04:19:15');
INSERT INTO `follows` VALUES ('1', '8', '2019-12-10 04:19:33');
INSERT INTO `follows` VALUES ('1', '4', '2019-12-10 04:19:56');
INSERT INTO `follows` VALUES ('1', '3', '2019-12-10 04:20:00');
INSERT INTO `follows` VALUES ('1', '7', '2019-12-15 21:40:40');
INSERT INTO `follows` VALUES ('1', '5', '2019-12-16 20:38:53');
INSERT INTO `follows` VALUES ('1', '6', '2019-12-16 20:54:43');

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes` (
  `uid` varchar(20) NOT NULL,
  `tid` int(11) NOT NULL,
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  KEY `uid` (`uid`),
  KEY `tid` (`tid`),
  CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `tweets` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES ('2', '2', '2019-12-08 23:13:36');
INSERT INTO `likes` VALUES ('3', '3', '2019-10-10 06:30:59');
INSERT INTO `likes` VALUES ('4', '4', '2016-12-22 11:20:21');
INSERT INTO `likes` VALUES ('5', '5', '2019-12-09 23:29:39');
INSERT INTO `likes` VALUES ('6', '6', '2011-10-29 16:55:36');
INSERT INTO `likes` VALUES ('7', '7', '2007-09-14 19:38:13');
INSERT INTO `likes` VALUES ('8', '8', '2017-12-06 20:08:51');
INSERT INTO `likes` VALUES ('9', '9', '2016-05-11 10:39:20');
INSERT INTO `likes` VALUES ('10', '10', '2013-12-08 01:40:06');

-- ----------------------------
-- Table structure for lists
-- ----------------------------
DROP TABLE IF EXISTS `lists`;
CREATE TABLE `lists` (
  `id` int(11) NOT NULL auto_increment,
  `uid` varchar(20) NOT NULL,
  `title` varchar(30) NOT NULL,
  `description` tinytext NOT NULL,
  `isprivate` tinyint(1) NOT NULL,
  `members` int(11) NOT NULL default '0',
  `subscribers` int(11) NOT NULL default '0',
  `time` timestamp NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `lists_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lists
-- ----------------------------
INSERT INTO `lists` VALUES ('1', '1', '1', '表1', '1', '3', '9', '2018-09-09 16:36:21');
INSERT INTO `lists` VALUES ('2', '2', '2', '表2', '2', '6', '4', '2019-02-19 16:39:02');
INSERT INTO `lists` VALUES ('3', '3', '3', '表3', '3', '49', '109', '2016-11-23 19:56:25');
INSERT INTO `lists` VALUES ('4', '4', '4', '表4', '4', '16', '42', '2019-12-09 16:48:14');
INSERT INTO `lists` VALUES ('5', '5', '5', '表5', '5', '9', '51', '2019-03-20 16:57:02');
INSERT INTO `lists` VALUES ('6', '6', '6', '表6', '6', '64', '206', '2018-09-06 21:00:34');
INSERT INTO `lists` VALUES ('7', '7', '7', '表7', '7', '23', '94', '2017-01-04 15:01:23');
INSERT INTO `lists` VALUES ('8', '8', '8', '表8', '8', '90', '226', '2015-05-28 17:02:38');
INSERT INTO `lists` VALUES ('9', '9', '9', '表9', '9', '1104', '7625', '2016-10-17 16:59:47');
INSERT INTO `lists` VALUES ('10', '10', '10', '表10', '10', '238', '706', '2018-07-06 21:04:48');

-- ----------------------------
-- Table structure for media
-- ----------------------------
DROP TABLE IF EXISTS `media`;
CREATE TABLE `media` (
  `fname` varchar(40) NOT NULL,
  `tid` int(11) NOT NULL,
  PRIMARY KEY  (`fname`),
  KEY `tid` (`tid`),
  CONSTRAINT `media_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `tweets` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of media
-- ----------------------------
INSERT INTO `media` VALUES ('12.jpg', '1');
INSERT INTO `media` VALUES ('14.jpg', '2');
INSERT INTO `media` VALUES ('19.jpg', '3');
INSERT INTO `media` VALUES ('18.jpg', '4');
INSERT INTO `media` VALUES ('28.jpg', '5');
INSERT INTO `media` VALUES ('15.jpg', '6');
INSERT INTO `media` VALUES ('16.jpg', '6');
INSERT INTO `media` VALUES ('23.jpg', '6');
INSERT INTO `media` VALUES ('32.gif', '6');
INSERT INTO `media` VALUES ('26.gif', '10');

-- ----------------------------
-- Table structure for members
-- ----------------------------
DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
  `id` int(11) NOT NULL auto_increment,
  `listid` int(11) NOT NULL,
  `uid` varchar(20) NOT NULL,
  `time` timestamp NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  KEY `listid` (`listid`),
  KEY `uid` (`uid`),
  CONSTRAINT `members_ibfk_1` FOREIGN KEY (`listid`) REFERENCES `lists` (`id`) ON DELETE CASCADE,
  CONSTRAINT `members_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of members
-- ----------------------------
INSERT INTO `members` VALUES ('101', '1', '1', '2019-12-10 02:17:40');
INSERT INTO `members` VALUES ('102', '2', '2', '2019-12-10 02:17:42');
INSERT INTO `members` VALUES ('103', '3', '3', '2019-12-10 02:17:44');
INSERT INTO `members` VALUES ('104', '4', '4', '2019-12-10 02:17:46');
INSERT INTO `members` VALUES ('105', '5', '5', '2019-12-10 02:17:48');
INSERT INTO `members` VALUES ('106', '6', '6', '2019-12-10 02:17:50');
INSERT INTO `members` VALUES ('107', '7', '7', '2019-12-10 02:17:53');
INSERT INTO `members` VALUES ('108', '8', '8', '2019-12-10 02:17:54');
INSERT INTO `members` VALUES ('109', '9', '9', '2019-12-10 02:17:56');
INSERT INTO `members` VALUES ('110', '10', '10', '2019-12-10 02:17:59');

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages` (
  `id` int(11) NOT NULL auto_increment,
  `id_1` varchar(20) NOT NULL,
  `id_2` varchar(20) NOT NULL,
  `log_fname` varchar(40) NOT NULL,
  `lastTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  KEY `id_1` (`id_1`),
  KEY `id_2` (`id_2`),
  CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`id_1`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `messages_ibfk_2` FOREIGN KEY (`id_2`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES ('1', '1', '2', '1st', '2019-04-10 18:00:08');
INSERT INTO `messages` VALUES ('2', '1', '3', '2nd', '2015-06-16 21:44:57');
INSERT INTO `messages` VALUES ('3', '6', '10', '3rd', '2013-12-31 23:01:59');
INSERT INTO `messages` VALUES ('4', '9', '3', '4th', '2017-12-09 09:37:32');
INSERT INTO `messages` VALUES ('5', '7', '5', '5th', '2007-01-01 00:00:00');
INSERT INTO `messages` VALUES ('6', '4', '8', '6th', '2017-12-31 19:05:00');
INSERT INTO `messages` VALUES ('7', '5', '6', '7th', '2012-05-20 05:20:22');
INSERT INTO `messages` VALUES ('8', '10', '9', '8th', '2019-12-09 18:07:22');
INSERT INTO `messages` VALUES ('9', '2', '4', '9th', '2019-12-09 18:07:46');
INSERT INTO `messages` VALUES ('10', '7', '9', '10th', '2018-11-22 08:19:38');

-- ----------------------------
-- Table structure for moments
-- ----------------------------
DROP TABLE IF EXISTS `moments`;
CREATE TABLE `moments` (
  `id` int(11) NOT NULL auto_increment,
  `uid` varchar(20) NOT NULL,
  `title` varchar(30) NOT NULL,
  `description` mediumtext NOT NULL,
  `cover_fname` varchar(40) NOT NULL,
  `time` timestamp NULL default CURRENT_TIMESTAMP,
  `count` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `moments_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of moments
-- ----------------------------
INSERT INTO `moments` VALUES ('1', '1', '本日', '第一条', '1', '2019-12-11 17:41:56', '1');
INSERT INTO `moments` VALUES ('2', '2', '小辣椒', '只要107', '2', '2019-12-09 17:44:43', '1');
INSERT INTO `moments` VALUES ('3', '3', 'Moring', 'Night', '3', '2019-10-30 17:46:12', '1');
INSERT INTO `moments` VALUES ('4', '4', '鬼灭之刃', '鳄鱼老师真的太棒了', '4', '2019-12-08 17:47:56', '1');
INSERT INTO `moments` VALUES ('5', '5', '啊啊啊', '黑五折算成270到手', '5', '2019-11-29 17:48:57', '1');
INSERT INTO `moments` VALUES ('6', '6', '守望好莱坞', '《神奇女侠1984》预告', '6', '2019-12-09 14:50:19', '1');
INSERT INTO `moments` VALUES ('7', '7', '闪耀暖暖', '刷完左一的情报屋之后都在刷谁的', '7', '2019-11-26 17:52:33', '1');
INSERT INTO `moments` VALUES ('8', '8', '嘿', '夫子庙老门东', '8', '2019-12-01 20:05:21', '1');
INSERT INTO `moments` VALUES ('9', '9', '特斯拉', '要每月收取10美元流量费了', '9', '2019-12-10 13:55:14', '1');
INSERT INTO `moments` VALUES ('10', '10', '你见过最有初恋脸的人', '当然是我家王一宝了 ', '10', '2019-10-14 03:06:07', '1');

-- ----------------------------
-- Table structure for mtweets
-- ----------------------------
DROP TABLE IF EXISTS `mtweets`;
CREATE TABLE `mtweets` (
  `mid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  KEY `mid` (`mid`),
  KEY `tid` (`tid`),
  CONSTRAINT `mtweets_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `moments` (`id`) ON DELETE CASCADE,
  CONSTRAINT `mtweets_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `tweets` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mtweets
-- ----------------------------
INSERT INTO `mtweets` VALUES ('1', '1');
INSERT INTO `mtweets` VALUES ('2', '2');
INSERT INTO `mtweets` VALUES ('3', '3');
INSERT INTO `mtweets` VALUES ('4', '4');
INSERT INTO `mtweets` VALUES ('5', '5');
INSERT INTO `mtweets` VALUES ('6', '6');
INSERT INTO `mtweets` VALUES ('7', '7');
INSERT INTO `mtweets` VALUES ('8', '8');
INSERT INTO `mtweets` VALUES ('9', '9');
INSERT INTO `mtweets` VALUES ('10', '10');

-- ----------------------------
-- Table structure for newmessages
-- ----------------------------
DROP TABLE IF EXISTS `newmessages`;
CREATE TABLE `newmessages` (
  `uid` varchar(20) NOT NULL,
  `mid` int(11) NOT NULL,
  `count` int(11) NOT NULL default '1',
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  KEY `uid` (`uid`),
  KEY `mid` (`mid`),
  CONSTRAINT `newmessages_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `newmessages_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `messages` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newmessages
-- ----------------------------

-- ----------------------------
-- Table structure for newnotification
-- ----------------------------
DROP TABLE IF EXISTS `newnotification`;
CREATE TABLE `newnotification` (
  `uid` varchar(20) NOT NULL,
  `time` timestamp NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  UNIQUE KEY `uid` (`uid`),
  CONSTRAINT `newnotification_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newnotification
-- ----------------------------
INSERT INTO `newnotification` VALUES ('1', '2019-12-18 23:49:58');

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `id` int(11) NOT NULL auto_increment,
  `uid` varchar(20) NOT NULL,
  `type` int(11) NOT NULL,
  `to_uid` varchar(20) NOT NULL,
  `time` timestamp NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notification
-- ----------------------------
INSERT INTO `notification` VALUES ('101', '1', '1', '1', '2019-09-11 17:28:13');
INSERT INTO `notification` VALUES ('102', '2', '1', '2', '2019-12-09 17:30:41');
INSERT INTO `notification` VALUES ('103', '3', '1', '3', '2018-07-12 22:31:15');
INSERT INTO `notification` VALUES ('104', '4', '1', '4', '2019-10-09 19:31:41');
INSERT INTO `notification` VALUES ('105', '5', '1', '5', '2019-08-25 16:49:00');
INSERT INTO `notification` VALUES ('106', '6', '1', '6', '2012-12-09 09:32:39');
INSERT INTO `notification` VALUES ('107', '7', '1', '7', '2019-12-09 17:33:47');
INSERT INTO `notification` VALUES ('108', '8', '1', '8', '2019-12-08 17:34:22');
INSERT INTO `notification` VALUES ('109', '9', '1', '9', '2017-01-01 00:00:45');
INSERT INTO `notification` VALUES ('110', '10', '1', '10', '2013-12-28 02:19:11');
INSERT INTO `notification` VALUES ('111', '1', '0', '6', '2019-12-16 20:44:59');
INSERT INTO `notification` VALUES ('112', '1', '0', '6', '2019-12-16 20:45:58');
INSERT INTO `notification` VALUES ('113', '1', '0', '6', '2019-12-16 20:50:25');
INSERT INTO `notification` VALUES ('114', '1', '0', '6', '2019-12-16 20:54:43');
INSERT INTO `notification` VALUES ('115', '1', '2', '12', '2019-12-18 23:47:17');
INSERT INTO `notification` VALUES ('116', '1', '2', '13', '2019-12-18 23:49:58');
INSERT INTO `notification` VALUES ('117', '1', '2', '13', '2019-12-18 23:50:01');
INSERT INTO `notification` VALUES ('118', '1', '3', '13', '2019-12-19 00:54:11');
INSERT INTO `notification` VALUES ('119', '1', '3', '13', '2019-12-19 00:54:12');
INSERT INTO `notification` VALUES ('120', '1', '3', '13', '2019-12-19 00:54:13');
INSERT INTO `notification` VALUES ('121', '1', '3', '13', '2019-12-19 00:54:13');
INSERT INTO `notification` VALUES ('122', '1', '3', '13', '2019-12-19 00:54:14');
INSERT INTO `notification` VALUES ('123', '1', '3', '13', '2019-12-19 00:54:14');
INSERT INTO `notification` VALUES ('124', '1', '3', '12', '2019-12-19 00:55:51');
INSERT INTO `notification` VALUES ('125', '1', '3', '12', '2019-12-19 00:55:52');
INSERT INTO `notification` VALUES ('126', '1', '3', '12', '2019-12-19 00:55:53');
INSERT INTO `notification` VALUES ('127', '1', '3', '12', '2019-12-19 00:55:53');
INSERT INTO `notification` VALUES ('128', '1', '3', '12', '2019-12-19 00:55:53');
INSERT INTO `notification` VALUES ('129', '1', '3', '12', '2019-12-19 00:55:54');
INSERT INTO `notification` VALUES ('130', '1', '3', '12', '2019-12-19 00:55:54');
INSERT INTO `notification` VALUES ('131', '1', '3', '12', '2019-12-19 00:55:55');
INSERT INTO `notification` VALUES ('132', '1', '3', '12', '2019-12-19 00:55:56');
INSERT INTO `notification` VALUES ('133', '1', '3', '12', '2019-12-19 00:55:56');
INSERT INTO `notification` VALUES ('134', '1', '3', '12', '2019-12-19 00:55:57');
INSERT INTO `notification` VALUES ('135', '1', '1', '19', '2019-12-19 10:44:18');
INSERT INTO `notification` VALUES ('136', '1', '1', '0', '2019-12-19 10:56:38');

-- ----------------------------
-- Table structure for retweets
-- ----------------------------
DROP TABLE IF EXISTS `retweets`;
CREATE TABLE `retweets` (
  `uid` varchar(20) NOT NULL,
  `tid` int(11) NOT NULL,
  `time` timestamp NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  KEY `uid` (`uid`),
  KEY `tid` (`tid`),
  CONSTRAINT `retweets_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `retweets_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `tweets` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of retweets
-- ----------------------------
INSERT INTO `retweets` VALUES ('2', '2', '2019-12-07 16:20:31');
INSERT INTO `retweets` VALUES ('3', '3', '2019-10-10 21:20:57');
INSERT INTO `retweets` VALUES ('4', '4', '2019-12-09 01:21:22');
INSERT INTO `retweets` VALUES ('5', '6', '2018-11-14 00:29:46');
INSERT INTO `retweets` VALUES ('6', '6', '2019-12-10 16:49:21');
INSERT INTO `retweets` VALUES ('7', '7', '2019-11-30 19:32:47');
INSERT INTO `retweets` VALUES ('8', '8', '2019-12-07 23:23:13');
INSERT INTO `retweets` VALUES ('9', '9', '2018-09-12 17:23:32');
INSERT INTO `retweets` VALUES ('10', '10', '2017-06-23 07:19:51');

-- ----------------------------
-- Table structure for subscribed
-- ----------------------------
DROP TABLE IF EXISTS `subscribed`;
CREATE TABLE `subscribed` (
  `uid` varchar(20) NOT NULL,
  `listid` int(11) NOT NULL,
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  KEY `uid` (`uid`),
  KEY `listid` (`listid`),
  CONSTRAINT `subscribed_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `subscribed_ibfk_2` FOREIGN KEY (`listid`) REFERENCES `lists` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subscribed
-- ----------------------------
INSERT INTO `subscribed` VALUES ('1', '1', '2019-05-09 16:36:30');
INSERT INTO `subscribed` VALUES ('2', '2', '2019-02-19 16:39:17');
INSERT INTO `subscribed` VALUES ('3', '3', '2016-11-23 19:56:51');
INSERT INTO `subscribed` VALUES ('4', '4', '2019-12-09 17:05:40');
INSERT INTO `subscribed` VALUES ('5', '5', '2019-03-20 16:57:52');
INSERT INTO `subscribed` VALUES ('6', '6', '2018-09-21 21:00:09');
INSERT INTO `subscribed` VALUES ('7', '7', '2019-12-09 17:07:58');
INSERT INTO `subscribed` VALUES ('8', '8', '2015-05-28 17:02:58');
INSERT INTO `subscribed` VALUES ('9', '9', '2016-10-17 16:59:44');
INSERT INTO `subscribed` VALUES ('10', '10', '2018-07-06 21:04:11');

-- ----------------------------
-- Table structure for trends
-- ----------------------------
DROP TABLE IF EXISTS `trends`;
CREATE TABLE `trends` (
  `id` int(11) NOT NULL auto_increment,
  `keywords` varchar(30) NOT NULL,
  `counts` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trends
-- ----------------------------
INSERT INTO `trends` VALUES ('1', '女生现实里最真实的样子', '1');
INSERT INTO `trends` VALUES ('2', '零下36度，消防员冻出“冰雪妆”', '2');
INSERT INTO `trends` VALUES ('3', '六盘水5死1伤命案抓捕视频曝光', '3');
INSERT INTO `trends` VALUES ('4', '家长贴标签式表达，影响孩子人格和思维发展', '4');
INSERT INTO `trends` VALUES ('5', '日本史上最强逃犯：11年4次越狱，一碗汤也能打开手铐脚镣', '5');
INSERT INTO `trends` VALUES ('6', '《爱尔兰人》：有一种电影叫黑帮片', '6');
INSERT INTO `trends` VALUES ('7', '孙兴慜一条龙破门', '7');
INSERT INTO `trends` VALUES ('8', '郎朗魔性钢琴教学现场', '8');
INSERT INTO `trends` VALUES ('9', '四川绵阳4.6级地震', '9');
INSERT INTO `trends` VALUES ('10', '詹姆斯拥抱安东尼', '10');

-- ----------------------------
-- Table structure for tweets
-- ----------------------------
DROP TABLE IF EXISTS `tweets`;
CREATE TABLE `tweets` (
  `id` int(11) NOT NULL auto_increment,
  `type` int(11) NOT NULL default '0',
  `to_uid` varchar(20) default NULL,
  `to_tid` int(11) default NULL,
  `uid` varchar(20) NOT NULL,
  `contents` mediumtext NOT NULL,
  `mediaType` int(11) NOT NULL default '0',
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `replays` int(11) NOT NULL default '0',
  `retweets` int(11) NOT NULL default '0',
  `likes` int(11) NOT NULL default '0',
  `counts` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `tweets_ibfk_3` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tweets
-- ----------------------------
INSERT INTO `tweets` VALUES ('1', '0', '', null, '1', '今日份欢乐', '2', '2019-10-09 20:55:35', '601', '38', '2', '3');
INSERT INTO `tweets` VALUES ('2', '0', '', '1', '2', 'uzi输了', '2', '2019-12-08 20:59:59', '9001', '871', '90', '90');
INSERT INTO `tweets` VALUES ('3', '0', '', '2', '3', '华为用八千万买下这首歌的版权，居然只是当铃声，真是太好听', '2', '2019-10-09 21:01:46', '4249', '406', '14805', '43');
INSERT INTO `tweets` VALUES ('4', '0', '', '3', '4', '贵州丹寨：苗族群众欢度“祭尤节”', '2', '2016-12-08 21:04:24', '1604', '294', '9423', '29');
INSERT INTO `tweets` VALUES ('5', '0', '', '4', '5', '别让“甩老族”肆意践踏养老责任', '2', '2018-07-08 19:59:07', '64', '63', '64', '64');
INSERT INTO `tweets` VALUES ('6', '0', '', '5', '6', '“鹿晗恋爱险”是有毒的金融创新', '2', '2019-12-08 21:13:47', '998', '109', '66', '66');
INSERT INTO `tweets` VALUES ('7', '0', '', '6', '7', ' \r\n2017 VS 2019火了，真的很惨，看完我哭了', '0', '2019-11-28 14:25:21', '21065', '351', '351', '352');
INSERT INTO `tweets` VALUES ('8', '0', '', '7', '8', '短道速滑——世界杯上海站：范可新获女子500米冠军', '0', '2019-12-07 21:19:36', '251', '250', '251', '251');
INSERT INTO `tweets` VALUES ('9', '0', '9', '8', '9', 'G20：最忆是杭州', '0', '2016-09-05 21:25:50', '52069', '718', '718', '719');
INSERT INTO `tweets` VALUES ('10', '0', '10', '9', '10', '忙啊！', '2', '2017-06-28 06:15:15', '9', '1', '12', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `power` int(11) NOT NULL default '0',
  `name` varchar(20) default NULL,
  `picfname` varchar(40) default NULL,
  `bgfname` varchar(40) default NULL,
  `bio` tinytext,
  `birth` varchar(20) default NULL,
  `join` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `following` int(11) NOT NULL default '0',
  `follower` int(11) NOT NULL default '0',
  `pinnedtid` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '0', '实一', '1.jpg', '41.jpg', '这个人很懒什么都没有留下', '1.1', '2014-09-03 15:08:59', '13', '10', '1');
INSERT INTO `user` VALUES ('10', '7864513', '0', '阿呆', '10.jpg', '40.jpg', '无', '11.3', '2013-12-06 20:21:16', '7', '61', '10');
INSERT INTO `user` VALUES ('2', '98463166+', '0', '咚咚', '2.jpg', '42.jpg', 'You do make a difference', '7.40', '2012-12-06 17:24:25', '2', '35', '2');
INSERT INTO `user` VALUES ('3', '8745211', '0', '七狮', '3.jpg', '43.jpg', '无简介', '2.26', '2009-08-06 23:00:00', '10', '90', '3');
INSERT INTO `user` VALUES ('4', '789', '0', '6224', '4.jpg', '44.jpg', '佬鱼干', '9.16', '2014-06-07 16:01:57', '5', '61', '4');
INSERT INTO `user` VALUES ('5', '6tcoooi', '0', '深白', '5.jpg', '45.jpg', '特立独行，天下无双', '9.21', '2006-12-21 04:54:58', '10', '48', '5');
INSERT INTO `user` VALUES ('6', '111111', '0', 'jie杀', '6.jpg', '46.jpg', '雨夜凉心寒', '4.28', '2011-10-29 19:27:04', '0', '1', '6');
INSERT INTO `user` VALUES ('7', '7535754', '0', '珠秋~', '7.jpg', '47.jpg', '天，晴了吗？', '6.23', '2007-09-13 10:05:47', '9', '44', '7');
INSERT INTO `user` VALUES ('8', 'qaz248', '0', 'ZHyd', '8.jpg', '48.jpg', 'IGNB', '11.23', '2017-12-06 20:09:20', '1', '0', '8');
INSERT INTO `user` VALUES ('9', '852415', '0', '时间', '9.jpg', '49.jpg', '呼，好困', '5.28', '2016-05-10 19:52:13', '5', '90', '9');
