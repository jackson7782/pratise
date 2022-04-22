create table if not exists PERSON
(
    id      int not null AUTO_INCREMENT,
    name    varchar(64),
    age     varchar(64),
    address varchar(64),
    sex     varchar(64),
    primary key (id)
)
/
create table if not exists PERSON2
(
    id      int not null AUTO_INCREMENT,
    name    varchar(64),
    age     varchar(64),
    address varchar(64),
    sex     varchar(64),
    primary key (id)
)
/