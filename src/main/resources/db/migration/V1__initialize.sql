create table users(
    id bigserial primary key,
    username varchar(255) not null
);

create table reminds(
    id bigserial primary key,
    user_id bigserial,
    message varchar (255),
    remind_date timestamp,
   foreign key (user_id) references users(id)
);

insert into users (id, username) values
(23343, 'Roma'),
(343443, 'Katia');

insert into reminds (user_id, message, remind_date) values
(23343, 'hello roma', current_timestamp),
(343443, 'hello katya', current_timestamp);