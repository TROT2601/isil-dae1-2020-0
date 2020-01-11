create table accounts (
                          id serial,
                          name varchar(100) not null,
                          balance double precision not null,
                          primary key (id)
);

insert into accounts(name, balance) values ('Edwin', 1000);
insert into accounts(name, balance) values ('Jeremy', 0);

create function transfer(
    idFrom INTEGER,
    idTo INTEGER,
    amount double precision)
    returns BOOLEAN
BEGIN

UPDATE accounts
SET balance = balance - amount
WHERE id = idFrom;

UPDATE accounts
SET balance = balance + amount
WHERE id = idTo;

return true;
END;


select transfer(2, 1, 100);
