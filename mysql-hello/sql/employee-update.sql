USE hello;

-- update
--     employee
-- set
--     salary = 5000;
update
    employee
set
    salary = salary + 10000,
    job = "董事"
where
    `name` = "张三";

select
    *
from
    employee;