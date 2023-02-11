create database study default character set utf8mb4;

create user 'study'@'%' identified by '1234';
create user 'study'@'localhost' identified by '1234';

grant all privileges on study.* to 'study'@'%';
grant all privileges on study.* to 'study'@'localhost';

flush privileges;

show databases;
show tables from study;

select * from cocktail;
select * from reviewsignature;

insert into reviewsignature values("1", "가", "가가가", "2023-02-11", "2023-02-11","1");
insert into reviewsignature values("2", "나", "나나나", "2023-02-11", "2023-02-11","1");
insert into reviewsignature values("3", "다", "다다다", "2023-02-11", "2023-02-11","1");