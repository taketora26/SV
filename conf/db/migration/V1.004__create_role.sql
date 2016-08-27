CREATE TABLE `role` (
	`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

INSERT INTO `role` (`id`, `name`)
VALUES
(1,'Programmer'),
(2,'BackOffice'),
(3,'BoardMember'),
(4,'President'),
(5,'Incubator'),
(6,'Assistant');