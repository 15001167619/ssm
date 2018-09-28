
CREATE DATABASE local_test;
USE local_test;

-- 用户表
CREATE TABLE `user` (
	`user_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`user_name` VARCHAR(255) NULL DEFAULT NULL COMMENT '姓名',
	`user_phone` BIGINT(20) NULL DEFAULT NULL COMMENT '手机号',
	PRIMARY KEY (`user_id`),
	UNIQUE INDEX `mobile` (`user_phone`)
)
COMMENT='用户表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

