create database spring4chapter18;
use spring4chapter18;
drop table if exists t_board;

drop table if exists t_board_manager;

drop table if exists t_post;

drop table if exists t_topic;

drop table if exists t_user;

drop table if exists t_login_log;
create table t_board(
	board_id int not null auto_increment 
    primary key comment '论坛版块ID',
    board_name varchar(150) not null default '' 
    comment '论坛版块名',
    board_desc varchar(255) default null
    comment '论坛版块描述',
    topic_num int not null default 0 
    comment '帖子数目',
	key AK_Board_Name (board_name)
)ENGINE=InnoDB AUTO_InCREMENT=9 default charset=utf8;

insert into t_board values(1, 'SpringMVC', 'Spring 框架提供了构建 Web 应用程序的全功能 MVC 模块\r\n',8);
insert into t_board values(2, '\r\nSpring Boot','简化新Spring应用的初始搭建以及开发过程，让我们一起来深入这个领域吧',0);
insert into t_board values(3, 'Spring 事务管理','本板块将讨论 Spring 庞杂而强大的事务功能,包括编程式事务和声明式事务 ',0);
insert into t_board values(4, ' IOC和AOP ','IOC和AOP讨论板块',3);
insert into t_board values(7, 'dddddddddddd','ddddddddddddddddddddddddddddddd',0);
insert into t_board values(8, 'SpringMVC','SpringMVC经验~~',0);
insert into t_board (board_name)values('SpringMVC');

#delete from t_board where board_id = 10;
create table t_user(
	`user_id` int(11) not null auto_increment primary key comment '用户ID',
    `user_name` varchar(30) not null comment '用户名，该列建立索引',
    `password` varchar(30) not null default '' comment '密码',
	`user_type` tinyint(4) not null default 1 comment '1：普通用户；2：管理员',
    `locked` tinyint(4) not null default 0 comment '0：未锁定；1：锁定',
    `credit` int(11) default null comment '积分',
    key `AK_AK_USER_USER_NAME` (`user_name`),
    `last_visit` datetime default null comment '最后登陆时间',
    `last_ip` varchar(30) default null comment '最后登陆ip'
)engine=InnoDB auto_increment=4 default charset=utf8;

INSERT INTO `t_user` VALUES (1,'tom','1234',2,0,203,NULL,NULL);
INSERT INTO `t_user` VALUES (2,'john','1234',2,1,10,NULL,NULL);
INSERT INTO `t_user` VALUES (3,'ggg','123123',1,0,110,NULL,NULL);

create table t_board_manager(
	`board_id` int not null,
    `user_id` int not null,
    primary key(`board_id`, `user_id`)
)engine=InnoDB default charset=utf8 comment='论坛管理员';

INSERT INTO `t_board_manager` VALUES (1,1);
INSERT INTO `t_board_manager` VALUES (1,2);
INSERT INTO `t_board_manager` VALUES (5,2);
INSERT INTO `t_board_manager` VALUES (5,3);

create table `t_topic`(
	`topic_id` int not null primary key auto_increment comment '帖子ID',
    `board_id` int not null comment '所属论坛',
    `topic_title` varchar(100) not null default '' comment '帖子标题，建立索引',
    `user_id` int not null default 0 comment '发表用户，建立索引',
    `create_name` datetime not null comment '发表时间',
    `last_post` datetime not null comment '最后回复时间',
    `topic_views` int not null default 1 comment '浏览数', 
    `topic_replies` int not null default 0 comment '回复数',
    `digest` int not null comment '0：不是精华话题；1：是精华话题',
	KEY `IDX_TOPIC_USER_ID` (`user_id`),
	KEY `IDX_TOPIC_TITLE` (`topic_title`)
)ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='话题';


INSERT INTO `t_topic` VALUES (1,1,'test',1,'2016-03-07','2016-04-18',0,1,1);
INSERT INTO `t_topic` VALUES (2,1,'test2',1,'2016-03-07','2016-03-07',0,0,1);
INSERT INTO `t_topic` VALUES (3,1,'test3',1,'2016-03-16','2016-03-16',0,0,0);
INSERT INTO `t_topic` VALUES (4,1,'test5',1,'2016-03-16','2016-03-16',0,0,0);
INSERT INTO `t_topic` VALUES (5,4,'AOP背后的故事',1,'2016-03-16','2016-03-16',0,1,1);
INSERT INTO `t_topic` VALUES (6,4,'IOC的原理一',1,'2016-03-16','2016-03-16',0,0,0);
INSERT INTO `t_topic` VALUES (7,4,'IOC的原理二',1,'2016-03-16','2016-03-16',0,0,0);
INSERT INTO `t_topic` VALUES (14,5,'d',1,'2016-04-12','2016-04-12',0,0,0);
INSERT INTO `t_topic` VALUES (15,5,'dad',1,'2016-04-12','2016-04-12',0,0,0);
INSERT INTO `t_topic` VALUES (20,1,'测试。。。。',1,'2016-04-17','2016-04-17',0,0,0);
INSERT INTO `t_topic` VALUES (21,1,'测试。。。。',1,'2016-04-17','2016-04-17',0,0,0);
INSERT INTO `t_topic` VALUES (22,1,'SpringMVC集成',1,'2016-04-18','2016-04-18',0,0,0);
INSERT INTO `t_topic` VALUES (23,1,'SpringMVC集成',1,'2016-04-18','2016-04-18',0,0,0);

create table `t_post`(
	`post_id` int not null auto_increment primary key comment '帖子ID',
    `board_id` int not null default 0 comment '论坛ID',
    `topic_id` int not null default 0 comment '话题ID',
    `user_id` int not null default 0 comment '发表者ID',
    `post_type` tinyint not null default 2 comment '帖子类型。1：主题帖子，2：回复帖子',
    `post_title` varchar(50) not null comment '帖子标题',
    `post_text` text not null comment '帖子内容',
    `create_time` datetime not null comment '创建时间',
KEY `IDX_POST_TOPIC_ID` (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='帖子';

INSERT INTO `t_post` VALUES (1,1,1,1,1,'SpringMVC','Spring Web MVC是一种基于Java的实现了Web MVC设计模式的请求驱动类型的轻量级Web框架\r\n','2016-03-07');
INSERT INTO `t_post` VALUES (2,1,2,1,1,'配置\r\详解','谁能告诉我SpringMVC的详细配置呢','2016-03-07');
INSERT INTO `t_post` VALUES (3,1,3,1,1,'test3','http://localhost/forum/boardManage.do?method=addTopicPage&boardId=1','2016-03-16');
INSERT INTO `t_post` VALUES (4,1,4,1,1,'test5','http://localhost/forum/boardManage.do?method=addTopicPage&boardId=1','2016-03-16');
INSERT INTO `t_post` VALUES (5,4,5,1,1,'AOP背后的故事','AOP背后的故事\r\n','2016-04-16');
INSERT INTO `t_post` VALUES (6,0,5,1,2,'铁杵磨成针','铁杵磨成针............\r\n','2016-04-16');
INSERT INTO `t_post` VALUES (7,4,6,1,1,'IOC的原理一','IOC的原理深入讲解\r\n','2016-04-16');
INSERT INTO `t_post` VALUES (8,4,7,1,1,'IOC的原理二','IOC的原理深入讲解','2016-04-16');
INSERT INTO `t_post` VALUES (14,5,14,1,1,'d','dddddddddddddd','2016-04-12');
INSERT INTO `t_post` VALUES (15,5,15,1,1,'dad','sdfffffffffffffffffff','2016-04-12');
INSERT INTO `t_post` VALUES (20,1,20,1,1,'测试。。。。','测试。。。。','2016-04-17');
INSERT INTO `t_post` VALUES (21,1,21,1,1,'测试。。。。','测试。。。。','2016-04-17');
INSERT INTO `t_post` VALUES (22,1,22,1,1,'SpringMVC集成','SpringMVC集成！！','2016-04-18');
INSERT INTO `t_post` VALUES (23,1,23,1,1,'SpringMVC集成','SpringMVC集成！！','2016-04-18');
INSERT INTO `t_post` VALUES (24,1,1,1,2,'SpringMVC集成','SpringMVC集成！！','2016-04-18');

create table `t_login_log`(
	`login_log_id` int not null primary key auto_increment comment '日志ID',
    `user_id` int not null default 0 comment '发表者ID',
    `ip` varchar(30) not null default ''  comment '登陆IP',
    `login_datetime` datetime not null comment '登陆时间'
)engine=InnoDb default charset=utf8 
