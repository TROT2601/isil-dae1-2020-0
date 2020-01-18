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

create table tbl_products
(
    id int auto_increment,
    name varchar(20) null,
    category varchar(20) null,
    price numeric null,
    constraint tbl_products_pk
        primary key (id)
);

insert into tbl_products (name, category, price)
values ('Arroz','Comestibles', 100.0);
