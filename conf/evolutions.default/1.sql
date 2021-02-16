#Person schema

#--- !Ups
create table person(
    id binary(16) default (uuid()) NOT NULL, primary key,
    username varchar(20),
    email varchar(20));

#--- !Downs
drop table person

