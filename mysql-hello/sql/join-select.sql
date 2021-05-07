use hello;

/*右连接*/
-- select
--     *
-- from
--     emp
--     right join dept on emp.deptno = dept.deptno;
/*等价形式*/
-- select
--     *
-- from
--     emp,
--     dept
-- where
--     emp.deptno = dept.deptno
--     or (
--         dept.deptno is not null
--         and emp.deptno is null
--     );
/*左连接*/
-- select
--     *
-- from
--     emp,
--     dept
-- where
--     emp.deptno = dept.deptno
--     or (
--         dept.deptno is null
--         and emp.deptno is not null
--     );