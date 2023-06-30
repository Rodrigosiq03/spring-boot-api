create table doctors(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    speciality varchar(100) not null,
    street varchar(100) not null,
    neighbourhood varchar(100) not null,
    postal_code varchar(9) not null,
    complement varchar(100),
    numero varchar(20),
    uf char(2) not null,
    city varchar(100) not null,

    primary key(id)

);