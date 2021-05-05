USE hello;

CREATE table IF not exists users (
    id int,
    name varchar(255),
    password varchar(32),
    birthdate datetime
);

insert into users(id, name, password)
VALUES(1, 'John', 'king');

select * from users;