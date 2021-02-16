#Person schema

#--- !Ups
create table person(
    id binary(16) default (uuid()) primary key not null,
    username varchar(20),
    email varchar(20));

#--- !Downs
drop table person

