CREATE IF NOT EXISTS users (
    id int PRIMARY KEY AUTO_INCREMENTS,
    nom varchar(50) not null ,
    prenom varchar(50) not null ,
    email varchar(50) not null ,
    password varchar(50) not null ,
);