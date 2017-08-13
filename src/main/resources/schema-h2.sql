drop table Product if exists;
create table IF NOT EXISTS Product (id integer not null auto_increment, name varchar(50), category varchar(10), price REAL);