-- ########################### 习惯打卡表（后续功能） ###########################
DROP TABLE IF EXISTS `habit_checkin`;
CREATE TABLE `habit_checkin` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '打卡ID',
  `user_id` bigint unsigned NOT NULL COMMENT '所属用户ID',
  `habit_id` bigint unsigned NOT NULL COMMENT '关联习惯ID',
  `checkin_date` date NOT NULL COMMENT '打卡日期',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_habit_date` (`user_id`, `habit_id`, `checkin_date`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_habit_id` (`habit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='习惯打卡记录表';

SET FOREIGN_KEY_CHECKS = 1;