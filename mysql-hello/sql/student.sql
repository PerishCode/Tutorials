USE hello;

drop table IF EXISTS students;

create table if not exists students (
    id int not null,
    `name` varchar(10) not null default '',
    chinese int not null default 0,
    english int not null default 0,
    math int not null default 0
);

insert into
    students
values
    (1, 'Linda', 70, 80, 90),
    (2, 'Steven', 80, 80, 90),
    (3, 'Mike', 60, 82, 91),
    (4, 'Anta', 57, 91, 72),
    (5, 'Puma', 63, 80, 90),
    (6, 'Lining', 80, 82, 90),
    (7, 'Jobs', 32, 61, 70);

select
    *
from
    students;