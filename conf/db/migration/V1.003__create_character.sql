CREATE TABLE `characters` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `full_name` VARCHAR(255) DEFAULT NULL,
  `real_name` VARCHAR(255) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  `skill` VARCHAR(4096) DEFAULT NULL,
  `image_url` VARCHAR(4096) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

INSERT INTO `characters` (`id`, `name`, `full_name`,`real_name`,`role_id`,`skill`,`image_url`)
VALUES
(1,'リチャード','リチャード・ヘンドリックス','Thomas Middleditch',1,'アルゴリズム','http://pattaya-time.wpcloud.net/wp-content/uploads/2016/07/90c9a72cdfd1ae6fb056aae168b8c10e.jpg'),
(2,'アーリック','アーリック・バックマン','T.J. Miller',3,'プレゼン','http://pattaya-time.wpcloud.net/wp-content/uploads/2016/07/c38598674c3ed3fb518fce4b5079f486.jpg'),
(3,'ネルソン','ネルソン','Josh Brener',1, NULL,'http://creatorjapan.asia/wp-content/uploads/2016/04/josh-brener-images.jpg'),
(4,'ギルフォイル','バートラム・ギルフォイル','Martin Starr',1,'セキュリティ','http://creatorjapan.asia/wp-content/uploads/2016/04/a452a090_siliconvalley18.xxxlarge_2x.jpg'),
(5,'ディネッシュ','ディネッシュ・チャグタイ','Kumail Nanjiani',1, 'Java','http://creatorjapan.asia/wp-content/uploads/2016/04/kumail-nanjiani-1920-768x432.jpg'),
(6,'ジャレッド','ドナルド”ジャレッド”ダン','Zach Woods',2, NULL,'http://pattaya-time.wpcloud.net/wp-content/uploads/2016/07/bf153af5fdf8bd3ea9c91ddcde681de9.jpg'),
(7,'ギャビン','ギャビン・ベルソン','Matt Ross',4, NULL,'http://creatorjapan.asia/wp-content/uploads/2016/04/matt-ross-sv-1920-1024x576.jpg'),
(8,'グレゴリー','ピーター・グレゴリー','Christopher Evan Welch',5, NULL,'http://creatorjapan.asia/wp-content/uploads/2016/04/how-silicon-valley-dealt-with-the-death-of-one-of-its-most-popular-actors.jpg'),
(9,'モニカ','モニカ・ホール','Amanda Crew',6, NULL,'http://creatorjapan.asia/wp-content/uploads/2016/04/amanda-crew-1024.jpg');
