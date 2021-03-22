CREATE TABLE `user` (
	`uId` BIGINT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR ( 255 ) COLLATE utf8mb4_general_ci DEFAULT NULL,
	`password` VARCHAR ( 255 ) DEFAULT NULL,
	`email` VARCHAR ( 255 ) DEFAULT NULL,
	`dateOfBirth` date DEFAULT NULL,
	`sex` boolean DEFAULT NULL,
PRIMARY KEY ( `uId` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;