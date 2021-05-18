create table users(
    id bigserial primary key,
    username varchar(255) not null
);

create table reminds(
    id bigserial primary key,
    user_id bigserial,
    message varchar (255),
    date timestamp,
   foreign key (user_id) references users(id)
);
--
--insert into users (id, username) values
--(952461996, 'Roma');
--(1, 'Katia');
--
--insert into reminds (user_id, message, date) values
--(952461996, 'hello roma', current_timestamp);
--(1, 'hello katya', current_timestamp);