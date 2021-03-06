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

create table t_board_manager(
	`board_id` int not null,
    `user_id` int not null,
    primary key(`board_id`, `user_id`)
)engine=InnoDB default charset=utf8 comment='论坛管理员';

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

create table `t_login_log`(
	`login_log_id` int not null primary key auto_increment comment '日志ID',
    `user_id` int not null default 0 comment '发表者ID',
    `ip` varchar(30) not null default ''  comment '登陆IP',
    `login_datetime` datetime not null comment '登陆时间'
)engine=InnoDb default charset=utf8 