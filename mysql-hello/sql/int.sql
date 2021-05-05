USE hello;

drop table IF EXISTS int_examples;

create table if not exists int_examples (
    a tinyint
);

insert into int_examples values(-128);

select * from int_examples;