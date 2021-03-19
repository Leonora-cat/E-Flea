CREATE TABLE `user` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
	`pssword` VARCHAR(255) DEFAULT NULL,
	`date_of_birth` date DEFAULT NULL,
	`sex` boolean DEFAULT NULL,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;