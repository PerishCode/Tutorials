USE hello;

-- select
--     `name`,
--     english
-- from
--     students;
-- select
--     distinct english
-- from
--     students;
-- select
--     name,
--     (english + chinese + math) as '总分'
-- from
--     students;
-- select
--     *
-- from
--     students
-- where
--     name = 'Linda';
-- select
--     *
-- from
--     students
-- where
--     english > 90;
-- select
--     *
-- from
--     students
-- where
--     (english + chinese + math) > 230;
select
    *,
    (chinese + english + math) as sum
from
    students
where
    chinese > 60
    AND math > 70
order by
    sum;