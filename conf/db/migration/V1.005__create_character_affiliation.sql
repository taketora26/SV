CREATE TABLE `character_affiliation` (
	`company_id` bigint(20)  NOT NULL REFERENCES company(id),
  `character_id` bigint(20)  NOT NULL REFERENCES characters(id),
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`company_id`,`character_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

INSERT INTO `character_affiliation` (`company_id`, `character_id`)
VALUES
(1,1),
(1,2),
(2,3),
(1,4),
(1,5),
(1,6),
(2,7);