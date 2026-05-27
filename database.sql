create database electricitydb;

use electricitydb;

create table customer(
    customer_id int primary key,
    customer_name varchar(50),
    address varchar(100)
);

create table bill(
    bill_id int auto_increment primary key,
    customer_id int,
    units int,
    amount double,
    foreign key(customer_id)
    references customer(customer_id)
);