use hello;

create table if not exists test_key (
    id int,
    `name` varchar(32),
    primary key (id, `name`)
);