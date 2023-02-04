create database study default character set utf8mb4;

create user 'study'@'%' identified by '1234';
create user 'study'@'localhost' identified by '1234';

grant all privileges on study.* to 'study'@'%';
grant all privileges on study.* to 'study'@'localhost';

flush privileges;

show databases;
show tables;
show tables from study;