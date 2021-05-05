USE hello;

ALTER table
    employee_example
add
    image varchar(30) not null default "";

select
    *
from
    employee_example;