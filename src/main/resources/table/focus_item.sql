-- ########################### 专注项表（番茄钟模板） ###########################
DROP TABLE IF EXISTS `focus_item`;
CREATE TABLE `focus_item` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '专注项ID',
  `user_id` bigint unsigned NOT NULL COMMENT '所属用户ID',
  `name` varchar(100) NOT NULL COMMENT '专注名称（如“编程”）',
  `duration` int NOT NULL COMMENT '专注时长（分钟，≥1）',
  `bg_url` varchar(255) DEFAULT NULL COMMENT '倒计时背景图URL',
  `bgm_url` varchar(255) DEFAULT NULL COMMENT '倒计时BGM URL',
  `sort` int DEFAULT '0' COMMENT '排序优先级（值越小越靠前）',
  `is_delete` tinyint DEFAULT '0' COMMENT '逻辑删除（0-未删，1-已删）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_name` (`user_id`, `name`),
  KEY `idx_is_delete` (`is_delete`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='专注项模板表（番茄钟定义）';


