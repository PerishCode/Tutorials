USE hello;

ALTER table
    employee_example
MODIFY
    image varchar(40) not null default "";

select
    *
from
    employee_example;