-- ########################### 临时笔记表 ###########################
DROP TABLE IF EXISTS `temp_note`;
CREATE TABLE `temp_note` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '笔记ID',
  `user_id` bigint unsigned NOT NULL COMMENT '所属用户ID',
  `record_id` bigint unsigned NOT NULL COMMENT '关联专注记录ID',
  `content` text NOT NULL COMMENT '笔记内容',
  `is_read` tinyint DEFAULT '0' COMMENT ' 是否已读（0-未读，1-已读）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_read` (`user_id`, `is_read`),
  KEY `idx_record_id` (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='专注过程临时笔记表';

