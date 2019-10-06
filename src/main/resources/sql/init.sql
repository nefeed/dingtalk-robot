-- 创建用户表 2019-10-05
CREATE TABLE `user_info` (
                             `user_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
                             `account` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
                             `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
                             `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
                             `title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '职称',
                             `user_avatar` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户头像',`role` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限',
                             `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户状态',
                             `last_login_time` int(11) DEFAULT NULL COMMENT '最后登录时间',
                             `gmt_create` int(11) NOT NULL COMMENT '创建时间（UnixTimestamp）10位秒数',
                             `gmt_modify` int(11) NOT NULL COMMENT '更新时间（UnixTimestamp）10位秒数',
                             `del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
                             PRIMARY KEY (`user_id`),
                             UNIQUE KEY `idx_account` (`account`) COMMENT '账号唯一性索引'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- 团队表 2019-10-05
CREATE TABLE `team_info` (
                             `team_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '团队id',
                             `team_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '团队名',
                             `creator_user_id` int(32) NOT NULL COMMENT '创建者id',
                             `team_avatar` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '团队头像',
                             `status` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '状态',
                             `gmt_create` int(11) NOT NULL COMMENT '创建时间（UnixTimestamp）10位秒数',
                             `gmt_modify` int(11) NOT NULL COMMENT '修改时间（UnixTimestamp）10位秒数',
                             `del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标签',
                             PRIMARY KEY (`team_id`),
                             KEY `idx_creatorUserId` (`creator_user_id`) COMMENT '创建者userId索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- 用户与团队关联表 2019-10-05
CREATE TABLE `ut_relation` (
                               `relation_id` int(64) NOT NULL AUTO_INCREMENT COMMENT '用户与团队的关联关系id',
                               `user_id` int(32) NOT NULL COMMENT '用户id',
                               `team_id` int(32) NOT NULL COMMENT '团队id',
                               `gmt_create` int(11) NOT NULL COMMENT '创建时间（UnixTimestamp）10位秒数',
                               `gmt_modify` int(11) NOT NULL COMMENT '更新时间（UnixTimestamp）10位秒数',
                               `del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
                               PRIMARY KEY (`relation_id`),
                               KEY `idx_userId` (`user_id`) COMMENT '用户id索引',
                               KEY `idx_teamId` (`team_id`) COMMENT '团队id索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- 机器人表 2019-10-05
CREATE TABLE `robot_info` (
                              `robot_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '机器人id',
                              `team_id` int(32) NOT NULL COMMENT '团队id',
                              `robot_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '机器人名臣',
                              `webhook` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '机器人webhook',
                              `type` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '机器人类型',
                              `robot_avatar` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '机器人头像',
                              `status` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '机器人状态',
                              `gmt_create` int(11) NOT NULL COMMENT '创建时间（UnixTimestamp）10位秒数',
                              `gmt_modify` int(11) NOT NULL COMMENT '更新时间（UnixTimestamp）10位秒数',
                              `del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
                              PRIMARY KEY (`robot_id`),
                              KEY `idx_teamId` (`team_id`) COMMENT '团队id索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- 定时任务表 2019-10-05
CREATE TABLE `task_info` (
                             `task_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '任务id',
                             `robot_id` int(32) NOT NULL COMMENT '机器人id',
                             `task_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '任务名称',
                             `task_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '任务内容',
                             `type` varchar(32) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '任务类型',
                             `run_times` int(32) NOT NULL DEFAULT '0' COMMENT '执行次数',
                             `expect_run_time` int(11) DEFAULT NULL COMMENT '预期执行时间',
                             `schedule` varchar(64) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '执行规则',
                             `gmt_create` int(11) NOT NULL COMMENT '创建时间（UnixTimestamp）10位秒数',
                             `gmt_modify` int(11) NOT NULL COMMENT '更新时间（UnixTimestamp）10位秒数',
                             `del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
                             PRIMARY KEY (`task_id`),
                             KEY `idx_robotId` (`robot_id`) COMMENT '机器人id索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- 创建使用记录表 2019-10-05
CREATE TABLE `action_log` (
                              `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
                              `user_id` int(32) NOT NULL COMMENT '用户id',
                              `team_id` int(32) NOT NULL COMMENT '团队id',
                              `robot_id` int(32) NOT NULL COMMENT '机器人id',
                              `event` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '事件类型',
                              `log` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '操作日志',
                              `gmt_create` int(11) NOT NULL COMMENT '创建时间（UnixTimestamp）10位秒数',
                              `gmt_modify` int(11) NOT NULL COMMENT '更新时间（UnixTimestamp）10位秒数',
                              `del` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
                              PRIMARY KEY (`id`),
                              KEY `idx_userId` (`user_id`) COMMENT '用户id索引',
                              KEY `idx_teamId` (`team_id`) COMMENT '团队id索引',
                              KEY `idx_robotId` (`robot_id`) COMMENT '机器人id索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;