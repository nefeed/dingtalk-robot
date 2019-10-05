-- 创建用户表 2019-10-05
CREATE TABLE `user_info` (
                             `user_id` int(32) NOT NULL AUTO_INCREMENT,
                             `account` varchar(64) COLLATE utf8mb4_general_ci NOT NULL,
                             `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
                             `username` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
                             `title` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL,
                             `role` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
                             `status` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
                             `last_login_time` int(11) DEFAULT NULL,
                             `gmt_create` int(11) NOT NULL,
                             `gmt_modify` int(11) NOT NULL,
                             `del` tinyint(1) NOT NULL DEFAULT '0',
                             PRIMARY KEY (`user_id`),
                             UNIQUE KEY `idx_account` (`account`) COMMENT '账号唯一性索引'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- 创建使用记录表 2019-10-05
CREATE TABLE `action_log` (
                              `id` int(64) NOT NULL AUTO_INCREMENT,
                              `user_id` int(32) NOT NULL,
                              `team_id` int(32) NOT NULL,
                              `robot_id` int(32) NOT NULL,
                              `event` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL,
                              `log` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
                              `gmt_create` int(11) NOT NULL,
                              `gmt_modify` int(11) NOT NULL,
                              `del` tinyint(1) NOT NULL DEFAULT '0',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;