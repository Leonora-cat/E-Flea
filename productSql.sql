CREATE TABLE `Product` (
  `pid` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL UNIQUE,
  `price` double DEFAULT NULL,
  `tag` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`pid`),
  `description` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `lifeTime` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `time` datetime,
  `uid` varchar(100),
  `state` boolean
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
alter table product add image1 LongBlob;
alter table product add image2 LongBlob;
alter table product add image3 LongBlob;
select * from product where tag = "3" order by pid desc limit 0, 8;
select * from product;
