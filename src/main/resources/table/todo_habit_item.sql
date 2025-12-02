-- ########################### 习惯养成表（后续功能） ###########################
DROP TABLE IF EXISTS `habit_item`;
CREATE TABLE `habit_item` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '习惯ID',
  `user_id` bigint unsigned NOT NULL COMMENT '所属用户ID',
  `name` varchar(100) NOT NULL COMMENT '习惯名称（如“每日专注1小时”）',
  `frequency` tinyint NOT NULL COMMENT '频率（1-每日，2-每周，3-每月）',
  `target` int NOT NULL COMMENT '目标值（如频率为每日则为60分钟）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_frequency` (`frequency`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='习惯养成定义表';

