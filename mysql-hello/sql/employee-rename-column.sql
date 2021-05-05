USE hello;

ALTER table
    employee_example change image image_path varchar(40) not null default "";

select
    *
from
    employee_example;