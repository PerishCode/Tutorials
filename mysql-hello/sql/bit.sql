USE hello;

drop table IF EXISTS bit_example;

create table if not exists bit_example (
    a bit(2)
);

insert into bit_example values(3);

select * from bit_example;