/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.1.49-community 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `nx_user` (
	`id` bigint (11),
	`nickname` varchar (150),
	`username` varchar (150),
	`password` varchar (150),
	`email` varchar (150),
	`type` int (2),
	`avator` varchar (1500),
	`create_time` datetime ,
	`update_time` datetime );

insert into `nx_user` (`id`, `nickname`, `username`, `password`, `email`, `type`, `avator`, `create_time`, `update_time`) values('1','李依金','lyj','e10adc3949ba59abbe56e057f20f883e','1421805850@qq.com','1','李依金','2018-10-25 18:14:13','2018-10-25 18:14:17');
