USE hello;

-- select
--     count(*) as '学生总数'
-- from
--     students;
-- select
--     sum(math + chinese + english) as '全部总成绩'
-- from
--     students;
-- select
--     sum(chinese) / count(*)
-- from
--     students;
-- select
--     avg(chinese)
-- FROM
--     students;
select
    max(chinese + math + english),
    min(chinese + math + english)
from
    students;