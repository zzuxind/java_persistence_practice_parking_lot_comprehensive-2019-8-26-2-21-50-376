-- create table employee (
--     id varchar(100) ,
--     name varchar (100),
--     age varchar (100),
--     vocation varchar (100)
-- )

create table user (
    id varchar(100),
    username varchar (100),
    password varchar (100),
    password_expired varchar (100),
    role varchar (100),
    create_time timestamp default current_timestamp
)