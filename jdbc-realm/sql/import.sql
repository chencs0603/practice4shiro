drop database if exists shiro;
create database shiro;
use shiro;

create table users(username varchar(20), password varchar(20));

insert into users(username, password) values('chencs', '123456');

grant all on shiro.* to 'shiro'@'%' identified by '123456';