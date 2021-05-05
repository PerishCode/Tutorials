use hello;

-- 先按部门分组，再按岗位分组
-- select
--     avg(sal),
--     max(sal),
--     deptno,
--     job
-- from
--     emp
-- group by
--     deptno,
--     job;
select
    avg(sal) avg_sal,
    deptno as '部门号'
from
    emp
group by
    deptno
having
    avg_sal > 3000;