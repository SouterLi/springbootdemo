-- ########################### 专注记录表（番茄钟执行记录） ###########################
DROP TABLE IF EXISTS `focus_record`;
CREATE TABLE `focus_record` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `user_id` bigint unsigned NOT NULL COMMENT '所属用户ID',
  `item_id` bigint unsigned NOT NULL COMMENT '关联专注项ID',
  `start_time` datetime NOT NULL COMMENT '专注开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '专注结束时间',
  `actual_duration` int NOT NULL COMMENT '实际专注时长（分钟）',
  `status` tinyint NOT NULL COMMENT '状态（1-完成，2-暂停，3-放弃）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_start` (`user_id`, `start_time`),
  KEY `idx_user_item` (`user_id`, `item_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='专注执行记录表';

