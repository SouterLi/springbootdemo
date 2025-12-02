-- ########################### 待办事项表（后续功能） ###########################
DROP TABLE IF EXISTS `todo_item`;
CREATE TABLE `todo_item` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '待办ID',
  `user_id` bigint unsigned NOT NULL COMMENT '所属用户ID',
  `title` varchar(200) NOT NULL COMMENT '待办标题',
  `deadline` datetime DEFAULT NULL COMMENT '截止时间',
  `priority` tinyint DEFAULT '2' COMMENT '优先级（1-高，2-中，3-低）',
  `status` tinyint DEFAULT '0' COMMENT '状态（0-未完成，1-已完成）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_deadline` (`deadline`),
  KEY `idx_priority` (`priority`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='待办事项表';
