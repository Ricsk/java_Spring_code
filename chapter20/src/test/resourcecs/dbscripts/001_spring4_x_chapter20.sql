drop database if exists spring4_x_chapter20;
create database spring4_x_chapter20;
use spring4_x_chapter20;

drop table if exists t_user;
create table t_user(
	user_id INT auto_increment primary key,
    user_name varchar(30),
    password varchar(32),
    credit int,
    last_visit datetime,
    last_ip varchar(23)
)ENGine=InnoDb;

drop table if exists t_login_log
create table t_login_log(
	login_log_id int auto_increment primary key,
    user_id int,
    ip varchar(23),
    login_datetime datetime
)engine=InnoDB;