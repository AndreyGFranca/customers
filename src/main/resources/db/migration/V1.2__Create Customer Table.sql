create table customer
(
    id         bigint(20) auto_increment primary key,
    name       varchar2,
    gender     varchar2,
    birth_date date,
    age        int,
    city_id    bigint(20),

    foreign key (city_id) references city (id)
)
