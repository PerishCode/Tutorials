USE hello;

drop table IF EXISTS employee;

create table if not exists employee (
    id int,
    `name` varchar(32),
    `status` varchar(32),
    senior int,
    department int,
    salary decimal(20, 2)
);

select
    *
from
    employee;