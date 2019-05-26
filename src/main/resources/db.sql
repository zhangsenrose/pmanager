-- 新增的数据库表 2019年5月26日22:26:23
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(30) NOT NULL DEFAULT '',
  `file_size` bigint(30) NOT NULL DEFAULT '0',
  `file_extension` varchar(30) NOT NULL DEFAULT '',
  `file_unique_name` varchar(30) NOT NULL DEFAULT '',
  `creator_id` varchar(30) NOT NULL DEFAULT '',
  `creator_name` varchar(30) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_id` varchar(30) NOT NULL DEFAULT '',
  `update_name` varchar(30) NOT NULL DEFAULT '',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_del` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
