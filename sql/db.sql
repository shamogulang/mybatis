CREATE TABLE `animals` (
  `id` mediumint NOT NULL AUTO_INCREMENT,
  `name` char(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `caraliu`.`animals`(`id`, `name`) VALUES (1, 'dog');
INSERT INTO `caraliu`.`animals`(`id`, `name`) VALUES (2, 'cat');
INSERT INTO `caraliu`.`animals`(`id`, `name`) VALUES (3, 'penguin');
INSERT INTO `caraliu`.`animals`(`id`, `name`) VALUES (4, 'lax');
INSERT INTO `caraliu`.`animals`(`id`, `name`) VALUES (5, 'whale');
INSERT INTO `caraliu`.`animals`(`id`, `name`) VALUES (6, 'ostrich');