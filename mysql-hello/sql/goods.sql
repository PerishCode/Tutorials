USE hello;

create table if not exists goods (
    id bigint,
    `name` varchar(20),
    price double
);

insert into
    goods (id, `name`, price)
values
(1, "苹果", 10);