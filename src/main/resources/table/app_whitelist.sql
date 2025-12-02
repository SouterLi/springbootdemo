-- ########################### App白名单表 ###########################
DROP TABLE IF EXISTS `app_whitelist`;
CREATE TABLE `app_whitelist` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '白名单ID',
  `user_id` bigint unsigned NOT NULL COMMENT '所属用户ID',
  `app_name` varchar(100) NOT NULL COMMENT 'App名称（如“微信”）',
  `app_package` varchar(255) NOT NULL COMMENT 'App包名（唯一标识）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_app_package` (`app_package`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='专注时允许打开的App白名单表';

