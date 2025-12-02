-- ########################### 专注目标表 ###########################
DROP TABLE IF EXISTS `focus_target`;
CREATE TABLE `focus_target` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '目标ID',
  `user_id` bigint unsigned NOT NULL COMMENT '所属用户ID',
  `day_target` int DEFAULT '120' COMMENT '每日目标时长（分钟，默认2小时）',
  `week_target` int DEFAULT '600' COMMENT '每周目标时长（分钟，默认10小时）',
  `month_target` int DEFAULT '2400' COMMENT '每月目标时长（分钟，默认40小时）',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='专注时长目标表';

