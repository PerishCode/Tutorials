use hello;

-- create table if not exists b (id int primary key, `name` varchar(32));
-- insert into
--     b
-- values
--     (1, '南大'),
--     (2, '北大');
-- select
--     *
-- from
--     b;
-- create table if not exists a (
--     id int primary key,
--     name varchar(32),
--     school int,
--     foreign key (school) references b(id)
-- );
-- insert into
--     a
-- values
--     (1, '小伙纸', 1);
insert into
    a
values
    (2, '小伙纸', 2);