/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.3-m13 : Database - jygl
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jygl` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jygl`;

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `companyname` varchar(50) NOT NULL,
  `unitproperty` varchar(50) NOT NULL,
  `licensenumber` varchar(50) NOT NULL,
  `unitscale` varchar(10) NOT NULL,
  `address` varchar(200) NOT NULL,
  `webaddress` varchar(70) NOT NULL,
  `linkman` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `email` varchar(20) NOT NULL,
  `postcode` varchar(10) NOT NULL,
  `industry` varchar(20) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `company` */

insert  into `company`(`cid`,`companyname`,`unitproperty`,`licensenumber`,`unitscale`,`address`,`webaddress`,`linkman`,`telephone`,`email`,`postcode`,`industry`) values (2,'喜之郎','私有','食品','500','阳江','www.xzl.com','郎爷','1234567896','584956@qq.com','hiuh','58465646'),(8,'三只松鼠','私有','食品','256','广州','www.szss.com','松鼠兄弟','15454548888','三只松鼠','fff','1234564454'),(11,'网易','214141525@qq.com','IT','广州天河区','7418529458794538','小易','546437','123586478254','私有','www.wy.com','700');

/*Table structure for table `employment` */

DROP TABLE IF EXISTS `employment`;

CREATE TABLE `employment` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `studentusername` varchar(50) NOT NULL,
  `school` varchar(50) NOT NULL,
  `companyname` varchar(50) NOT NULL,
  `position` varchar(50) NOT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `employment` */

insert  into `employment`(`eid`,`studentusername`,`school`,`companyname`,`position`) values (4,'张三','广州大学','广州信息贸易公司','财务总监'),(5,'李四','广东食品职业技术学院','阳江医院','分药师');

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `msgtime` varchar(20) DEFAULT NULL,
  `content` text,
  `reply` text,
  `replytime` text,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `message` */

insert  into `message`(`mid`,`id`,`username`,`title`,`msgtime`,`content`,`reply`,`replytime`) values (1,8,'三只松鼠','','2018-12-14 10:07:29','<p>kljojoi nhbjfvuytgkh mbvfuyfuyrvexcj</p>\r\n','IUOIUIUI','2018-12-16 15:13:24'),(3,8,'三只松鼠','vfdva','2018-12-16 21:13:34','<p>vdfava</p>\r\n',NULL,NULL),(4,5,'yuan','','2018-12-18 17:07:47','<p>ewgerhgrsthbg x</p>\r\n',NULL,NULL),(5,5,'yuan','gfhs','2018-12-18 17:07:56','<p>ewgerhgrsthbg x</p>\r\n',NULL,NULL),(6,7,'女神','hhh','2018-12-20 8:00:54','<h2 style=\"font-style: italic;\"><span class=\"marker\"><font style=\"background-color: rgb(255, 255, 255);\">fhhfdhhfhdtret</font></span></h2>\r\n',NULL,NULL),(7,11,'网易','招聘信息','2018-12-23 23:00:29','<p><strong>管理员你好，本次招聘信息已发布，也希望管理员能和学校同学宣传，主要技术过关，什么都好说，月薪面议，谢谢！</strong></p>\r\n','OK！','2018-12-23 23:53:31');

/*Table structure for table `recruitresume` */

DROP TABLE IF EXISTS `recruitresume`;

CREATE TABLE `recruitresume` (
  `rid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `sid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `recruitresume` */

insert  into `recruitresume`(`rid`,`cid`,`sid`) values (2,34,3),(8,2,1),(8,34,5),(8,10,1),(6,11,7);

/*Table structure for table `recurit` */

DROP TABLE IF EXISTS `recurit`;

CREATE TABLE `recurit` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `companyname` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `postcode` varchar(10) NOT NULL,
  `recruitment` int(11) NOT NULL,
  `workingplace` varchar(60) NOT NULL,
  `positiontype` varchar(10) NOT NULL,
  `edurequire` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `branch` varchar(50) NOT NULL,
  `linkman` varchar(34) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `hostpage` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `recurit` */

insert  into `recurit`(`rid`,`cid`,`companyname`,`address`,`postcode`,`recruitment`,`workingplace`,`positiontype`,`edurequire`,`description`,`branch`,`linkman`,`telephone`,`hostpage`,`email`) values (1,8,'三只松鼠','广州','123',123,'广州','全职','初中以上','责任心强','食品加工','小松','666666666','123','45856649@qq.com'),(2,123,'sfghfys','dfguyhd','g123',123,'123','全职','123','123tyfy','123','123','123','123','123'),(3,2,'sdg','ij','hiuh',78,'姑姑iyu98','全职','大专','责任心强','食品检测','大松','888888888','huih','hiu'),(5,8,'三只松鼠','广州','fff',23,'广州','兼职','FSDFS','FSFS','FDS','FDS','244234','www.szss.com','三只松鼠'),(6,11,'网易','7418529458794538','www.wy.com',2,'广州天河信息港隔壁','全职','大专以上','对android框架熟悉，熟练AS','移动开发部','小易','1582427644328','小易','私有');

/*Table structure for table `resume` */

DROP TABLE IF EXISTS `resume`;

CREATE TABLE `resume` (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，对studentinfo中的sid',
  `sname` varchar(50) NOT NULL COMMENT '真实姓名和高考通知书上一致',
  `gender` varchar(12) NOT NULL COMMENT 'not null',
  `birthdate` varchar(10) NOT NULL COMMENT 'not null',
  `nation` varchar(20) NOT NULL,
  `politics` varchar(20) DEFAULT NULL COMMENT '党员 团员 群众 其他',
  `graduation` varchar(20) DEFAULT NULL COMMENT '2015-12-10',
  `school` varchar(50) NOT NULL COMMENT '全称',
  `major` varchar(50) DEFAULT NULL,
  `education` varchar(20) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `phone` varchar(40) DEFAULT NULL,
  `foreignlanguage` varchar(50) DEFAULT NULL,
  `hobby` text,
  `practice` text,
  `position` text,
  `honor` text,
  `research` text,
  `selfevaluation` text,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `resume` */

insert  into `resume`(`sid`,`sname`,`gender`,`birthdate`,`nation`,`politics`,`graduation`,`school`,`major`,`education`,`email`,`phone`,`foreignlanguage`,`hobby`,`practice`,`position`,`honor`,`research`,`selfevaluation`) values (1,'sf','sffs','sgs','sg','s','?','?','?','?','?','?','?','?','?','?','?','?','?'),(5,'yuan','女','2018-12-5','苗','tuanyuan','2018-12-14','yangjiangzhiyejishuxueyuan','jisuanjiyingyonhjishu','本科','158454545@qq.com','6596556658','fsfsfs','fsfhfh','fdf','frewhf','fwef','fwe','fwe'),(7,'女神','女','1996-9-12','汉','tuanyuan','2018-12-31','阳江职业技术学院','计算机应用技术','本科','1085623683@qq.com','15768597917','b','唱歌','当过人贩子','学委','……','ε=(´ο｀*)))唉','还可以'),(10,'鱼头','男','1999-5-1','汉','团员','2018-12-28','浙江大学','养殖','本科','1245465696@qq.com','11011011011','五星级哦','养鱼卖鱼','卖鱼','渔夫','卖鱼大赛一等奖','鱼头钓鱼愿者上钩，做了姜太公的梦','哈哈，鲨鱼小能手');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` int(11) NOT NULL,
  `sname` varchar(50) NOT NULL COMMENT '真实姓名与高考通知书上一致',
  `gender` varchar(2) NOT NULL COMMENT 'not null',
  `idnumber` varchar(20) NOT NULL COMMENT 'not null',
  `school` varchar(50) DEFAULT NULL COMMENT '必须为全称',
  `department` varchar(50) DEFAULT NULL COMMENT '必须为全称 如软件工程系',
  `major` varchar(50) DEFAULT NULL COMMENT '必须为全称',
  `education` varchar(10) DEFAULT NULL COMMENT '专科 本科 硕士研究生 博士研究生',
  `entrancedate` varchar(10) NOT NULL COMMENT 'not null',
  `nativeplace` varchar(200) DEFAULT NULL COMMENT '按实际内容填写，填写要求要一致',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`sid`,`sname`,`gender`,`idnumber`,`school`,`department`,`major`,`education`,`entrancedate`,`nativeplace`) values (4,'abcd','女','5352626564564','阳江职业技术学院','信工系','电子商务','专科','2018-11-4','广东'),(5,'yuan','女','44088249799598965969','yangjiangzhiyejishuxueyuan','xingongxi','jisuanjiyingyonhjishu','本科','','广东'),(7,'女神','女','46158684164769479479','阳江职业技术学院','信息工程系','计算机应用技术','本科','2018-11-1','广东'),(8,'aa','女','154662956593556959','阳江职业技术学院','阳江职业技术学院','计算机',NULL,'2018-11-4',NULL),(10,'鱼头','男','45454548168923566236','浙江大学','养殖系','养殖','本科','2016-12-1','广东'),(32,'qq','女','2525252352','bfdhsb','bfdbsdg','bdfshh',NULL,'2018-11-11','ggr');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `usertypes` varchar(20) NOT NULL,
  `verify` varchar(1) CHARACTER SET gb2312 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`usertypes`,`verify`) values (1,'ee','11','admin','2'),(2,'aa','22','student','2'),(3,'bb','22','company','2'),(4,'abcd','123','student','2'),(5,'yuan','0209','student','2'),(6,'11','11','admin','2'),(7,'女神','123','student','2'),(8,'三只松鼠','123','company','2'),(9,'5t','44','student','2'),(10,'鱼头','123','student','2'),(11,'网易','12','company','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
