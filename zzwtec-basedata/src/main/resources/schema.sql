use db_base;
drop table users;
create table users (id bigint,username varchar(255), age int, primary key (id));