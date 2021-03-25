CREATE TABLE `user` (
	`userID` BIGINT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR ( 255 ) COLLATE utf8mb4_general_ci NOT NULL,
	`password` VARCHAR ( 255 ) NOT NULL,
	`email` VARCHAR ( 255 ) DEFAULT NULL,
	`major` VARCHAR (255) DEFAULT NULL,
	`dateOfBirth` date DEFAULT NULL,
	`sex` boolean DEFAULT NULL,
PRIMARY KEY ( `userId` ) 
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;