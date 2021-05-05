use hello;

drop table if exists department;

create table if not exists department(
    id int not null,
    `name` varchar(100),
    `location` varchar(200)
);

insert into
    department (id, name, location)
values
    (1, 'Services', 'Kyra'),
    (2, 'Support', 'Piekielnik'),
    (3, 'Accounting', 'Creighton'),
    (4, 'Legal', 'Marcovia'),
    (5, 'Engineering', 'Jinta');

select
    *
from
    department;