use hello;

create table if not exists emp_simple_copy (id int, `name` varchar(32));

insert into
    emp_simple_copy (id, `name`)
select
    empno,
    ename
from
    emp;

select
    *
from
    emp_simple_copy;