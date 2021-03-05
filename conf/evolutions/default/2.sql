#Address schema

# --- !Ups
create table address(
                       id bigint auto_increment not null,
                       street varchar(20),
                       city varchar(20),
                       person_id binary(16) default (UUID()),
                       primary key (id),
                       foreign key (person_id) references person(id)
                    );

# --- !Downs
drop table address
