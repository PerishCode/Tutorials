-- select
--     *
-- from
--     hello.emp
-- where
--     hiredate > '1981-01-01';
-- select
--     *
-- from
--     hello.emp
-- order by
--     deptno,
--     sal DESC
-- limit
--     0, 2;
-- select
--     count(*),
--     avg(sal),
--     deptno
-- from
--     hello.emp
-- group BY
--     deptno;
-- select
--     count(IF(comm is null, '', null))
-- from
--     hello.emp;
-- select
--     count(distinct mgp)
-- from
--     hello.emp;
select
    deptno,
    avg(sal) avg_sal
from
    emp
group by
    deptno
having
    avg_sal > 3000
order by
    avg_sal
limit
    1, 2;