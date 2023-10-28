# jiu-dian-guan-li-System


**这是一个小型酒店管理系统**
系统包括酒店前台管理和经理的员工管理两个部分。酒店前台管理主要实现了顾客管理、房间信息查看、退房操作、服务员信息查看、事件查看和日志功能。经理的员工管理主要实现了前台员工和服务员工的新增、开除和修改功能。本课程设计采用了JavaWeb技术，使用了Servlet、JSP、JDBC等技术和工具，基于MVC模式进行了系统的分层设计和实现。本课程设计通过对酒店管理系统的需求分析、可行性分析、系统设计、系统实现、系统测试等阶段的详细论述，展示了系统的功能和特点，验证了系统的可行性和有效性。

**软件版本**
JDK8，
Eclipse，
Tomcat v8.0 Server at localhost-config，
Javax.servlet-api-3.0.1，
MySQL-connector-java-5.0.4-bin，
Navicat 8.0 Lite MySQL





**数据库设计**
要想开发一个比较完善的系统离不开数据库的支持，只有选择了正确、强大的数据库，才能够存储大量的数据信息，实现更多的数据功能。

 
经理登录密码实体
 
房间实体
 
服务员实体
 
前台员工实体
 
顾客实体
 
日志实体
 
事件实体
 
酒店管理系统E-R图






**数据库逻辑设计**

1)	经理 （管理员ID，管理员账号，管理员密码，经理姓名）
2)	房间表 （房间ID，房间号，房间状态，房间类型，房间价格，）
3)	服务员 （ID，员工姓名，员工身份证号，员工电话，员工职位，员工位置fk，员工需求，备注）
4)	前台员工 （ID，前台账号，前台姓名，前台登录密码，前台性别，前台身份证号，前台工资）
5)	顾客 （ID，顾客姓名，顾客电话，顾客身份证，房间号fk，预约状态，入住时间，离店时间，房间状态，支付状态，备注，花费）
6)	日志 （ID，顾客姓名，顾客电话，顾客身份证，房间号，预约状态，入住时间，最后操作时间，房间状态，支付状态，备注，花费 ）
7)	事件 （ID，事件，要求，备注，房间号fk）






**数据库物理设计**


经理表
字段名	数据类型	长度	允许空	主键	外键	描述
adminid	int	19	否	是	否	管理员ID
adminsno	varchar	20	否	否	否	管理员账号
adminpass	varchar	20	否	否	否	管理员密码
jlname	varchar	30	否	否	否	经理姓名
 


房间表
字段名	数据类型	长度	允许空	主键	外键	描述
id	int	11	否	是	否	房间ID
fno	int	22	否	否	否	房间号
zhuang_tai 	Varchar	40	否	否	否	房间状态
lei_xing	Varchar	40	否	否	否	房间类型
jiange	varchar	40	否	否	否	房间价格
 
服务员表
字段名	数据类型	长度	允许空	主键	外键	描述
yid	int	11	否	是	否	ID
yname	varchar	20	否	否	否	员工姓名
yidc	varchar	30	否	否	否	员工身份证号
ytel	varchar	30	否	否	否	员工电话
yzhiwei	varchar	30	否	否	否	员工职位
weizhi	int	40	否	否	是	员工位置
xuqiu	varchar	100	否	否	否	员工需求
beizhu	varchar	100	否	否	否	备注

 
 
前台表
字段名	数据类型	长度	允许空	主键	外键	描述
qid	int	16	否	是	否	ID
qsno	varchar	30	否	否	否	前台账号
qname	Varchar	30	否	否	否	前台姓名
qdlpass	Varchar	30	否	否	否	前台登陆密码
qsex	Varchar	30	否	否	否	前台性别
qage	Varchar	30	否	否	否	前台年龄
qidc	Varchar	30	否	否	否	前台身份证号
gongzhi	varchar	30	否	否	否	前台工资
 

顾客表
字段名	数据类型	长度	允许空	主键	外键	描述
gid	int	16	否	是	否	ID
gname	varchar	40	否	否	否	顾客姓名
gtel	varchar	30	否	否	否	顾客电话
gidc	varchar	30	否	否	否	顾客身份证
ghsno	int	20	否	否	是	房间号
gyystate	varchar	30	否	否	否	预约状态
gruzhutime	date	0	否	否	否	入住时间
gouttime	date	030	否	否	否	离店时间
ghstate	varchar	30	否	否	否	房间状态
zhifustate	varchar	30	否	否	否	支付状态
beizhu	varchar	100	否	否	否	备注
huafei	int	30	否	否	否	花费
 
 
日志表
字段名	数据类型	长度	允许空	主键	外键	描述
gid	int	16	否	是	否	ID
gname	varchar	40	否	否	否	顾客姓名
gtel	varchar	30	否	否	否	顾客电话
gidc	varchar	30	否	否	否	顾客身份证
ghsno	int	20	否	否	是	房间号
gyystate	varchar	30	否	否	否	预约状态
gruzhutime	date	0	否	否	否	入住时间
gouttime	date	030	否	否	否	最后操作时间
ghstate	varchar	30	否	否	否	房间状态
zhifustate	varchar	30	否	否	否	支付状态
beizhu	varchar	100	否	否	否	备注
huafei	int	30	否	否	否	花费

 


事件表
字段名	数据类型	长度	允许空	主键	外键	描述
sid	int	11	否	是	否	ID
shijian	varchar	100	否	否	否	事件
yaoqiu	varchar	200	否	否	否	要求
beizhu	varchar	100	否	否	否	备注
sfno	int	20	否	否	是	房间号
 
 

**数据库代码**
SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admintable
-- ----------------------------
DROP TABLE IF EXISTS `admintable`;
CREATE TABLE `admintable` (
  `adminid` int(19) NOT NULL,
  `adminsno` varchar(20) NOT NULL,
  `adminpass` varchar(20) NOT NULL,
  `jlname` varchar(30) NOT NULL,
  PRIMARY KEY  (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fang_jian_table
-- ----------------------------
DROP TABLE IF EXISTS `fang_jian_table`;
CREATE TABLE `fang_jian_table` (
  `id` int(11) NOT NULL auto_increment,
  `fno` int(22) NOT NULL,
  `zhuang_tai` varchar(40) NOT NULL default '',
  `lei_xing` varchar(40) NOT NULL default '',
  `jiange` varchar(40) NOT NULL default '',
  PRIMARY KEY  (`id`),
  KEY `fno` (`fno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jiudian_fuwuyuan
-- ----------------------------
DROP TABLE IF EXISTS `jiudian_fuwuyuan`;
CREATE TABLE `jiudian_fuwuyuan` (
  `yid` int(11) NOT NULL auto_increment,
  `yname` varchar(20) NOT NULL,
  `yidc` varchar(30) NOT NULL,
  `ytel` varchar(30) NOT NULL,
  `yzhiwei` varchar(30) NOT NULL,
  `weizhi` int(40) NOT NULL,
  `xuqiu` varchar(100) NOT NULL,
  `beizhu` varchar(100) NOT NULL,
  PRIMARY KEY  (`yid`),
  KEY `weizhi` (`weizhi`),
  CONSTRAINT `jiudian_fuwuyuan_ibfk_1` FOREIGN KEY (`weizhi`) REFERENCES `fang_jian_table` (`fno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qiantaiadmintablie
-- ----------------------------
DROP TABLE IF EXISTS `qiantaiadmintablie`;
CREATE TABLE `qiantaiadmintablie` (
  `qid` int(16) NOT NULL auto_increment,
  `qsno` varchar(30) NOT NULL,
  `qname` varchar(30) NOT NULL,
  `qdlpass` varchar(30) NOT NULL,
  `qsex` varchar(30) NOT NULL,
  `qage` varchar(30) NOT NULL,
  `qidc` varchar(30) NOT NULL,
  `gongzhi` varchar(30) NOT NULL,
  PRIMARY KEY  (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qiantaiguanli
-- ----------------------------
DROP TABLE IF EXISTS `qiantaiguanli`;
CREATE TABLE `qiantaiguanli` (
  `gid` int(16) NOT NULL auto_increment,
  `gname` varchar(40) NOT NULL,
  `gtel` varchar(30) NOT NULL,
  `gidc` varchar(30) NOT NULL,
  `ghsno` int(20) NOT NULL,
  `gyystate` varchar(30) NOT NULL,
  `gruzhutime` date NOT NULL,
  `gouttime` date NOT NULL,
  `ghstate` varchar(30) NOT NULL,
  `zhifustate` varchar(30) NOT NULL,
  `beizhu` varchar(100) NOT NULL,
  `huafei` int(30) NOT NULL,
  PRIMARY KEY  (`gid`),
  KEY `ghsno` (`ghsno`),
  CONSTRAINT `qiantaiguanli_ibfk_1` FOREIGN KEY (`ghsno`) REFERENCES `fang_jian_table` (`fno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rizhi
-- ----------------------------
DROP TABLE IF EXISTS `rizhi`;
CREATE TABLE `rizhi` (
  `gid` int(16) NOT NULL auto_increment,
  `gname` varchar(40) NOT NULL,
  `gtel` varchar(30) NOT NULL,
  `gidc` varchar(30) NOT NULL,
  `ghsno` int(20) NOT NULL,
  `gyystate` varchar(30) NOT NULL,
  `gruzhutime` date NOT NULL,
  `gouttime` date NOT NULL,
  `ghstate` varchar(30) NOT NULL,
  `zhifustate` varchar(30) NOT NULL,
  `beizhu` varchar(100) NOT NULL,
  `huafei` int(30) NOT NULL,
  PRIMARY KEY  (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shi_jian_table
-- ----------------------------
DROP TABLE IF EXISTS `shi_jian_table`;
CREATE TABLE `shi_jian_table` (
  `sid` int(11) NOT NULL auto_increment,
  `shijian` varchar(100) NOT NULL,
  `yaoqiu` varchar(200) NOT NULL,
  `beizhu` varchar(100) NOT NULL,
  `sfno` int(20) NOT NULL,
  PRIMARY KEY  (`sid`),
  KEY `sfno` (`sfno`),
  CONSTRAINT `shi_jian_table_ibfk_1` FOREIGN KEY (`sfno`) REFERENCES `fang_jian_table` (`fno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;








 
