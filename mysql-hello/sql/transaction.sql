use hello;

create table if not exists transaction_test (id int, `name` varchar(32));

-- start transaction; 或者 set autocommit=off;
-- savepoint a;
-- insert into transaction_test(1, '哈哈');
-- rollback to a;
-- commit;
-- select @@transaction_isolation;
-- set session transaction isolation level read uncommitted;