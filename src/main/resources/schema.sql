CREATE TABLE IF NOT EXISTS contacts
(
    id         uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name varchar(100) NOT NULL,
    last_name  varchar(100) NOT NULL,
    phone      varchar(100) NOT NULL,
    email      varchar(100)     DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id       uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    username varchar(100) NOT NULL,
    password varchar(100) NOT NULL
);