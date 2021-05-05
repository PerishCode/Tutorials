use hello;

-- create table if not exists emp_simple_copy (id int, `name` varchar(32));
-- insert into
--     emp_simple_copy (id, `name`)
-- select
--     empno,
--     ename
-- from
--     emp;
-- select
--     *
-- from
--     emp_simple_copy;
create table if not exists emp_complete_copy like emp;

insert into
    emp_complete_copy
select
    *
from
    emp;

select
    *
from
    emp_complete_copy;