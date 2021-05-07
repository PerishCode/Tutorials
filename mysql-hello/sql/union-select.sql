use hello;

select
    count(*)
from
    (
        select
            ename,
            sal
        from
            emp
        where
            sal > 5000
        union
        select
            ename,
            sal
        from
            emp
        where
            deptno in(20, 30)
    ) temp;