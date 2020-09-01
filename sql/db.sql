CREATE TABLE `animals` (
  `id` mediumint NOT NULL AUTO_INCREMENT,
  `name` char(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE TABLE `prod_tag` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `value` varchar(20) NOT NULL DEFAULT '' COMMENT '标签值',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '标签名称',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '类型,0商品销售标签',
  `create_time` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '0：无效，1：有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='商品标签表';