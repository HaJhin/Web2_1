drop database if exists kiosk;
create database kiosk;
use kiosk;
create table product(category text,pname text,price int);
create table ordercount(pname text,pcount int,ordernumber int);
create table kioskorder(ordernumber int,orderdate datetime);
show tables;
select * from product;
insert into product(category,pname,price) values ('coffee','americano',3000);