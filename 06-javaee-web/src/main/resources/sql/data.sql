create table tbl_users
(
    id int auto_increment,
    login varchar(20) null,
    password varchar(20) null,
    constraint tbl_users_pk
        primary key (id)
);

insert into tbl_users (login, password)
    values ('admin','1234');
