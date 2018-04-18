CREATE TABLE `user`(
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(1024) COMMENT '名字',
  `age` int(4)  COMMENT '迷面',
  `address` varchar(1024)  COMMENT '地址',
  `yn`  enum('N','Y') DEFAULT 'N' COMMENT '是否删除, N-不删除，Y-删除' ,
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_date`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';