CREATE TABLE roles (
                       id serial4 PRIMARY KEY,
                       name varchar(40) NOT NULL UNIQUE,
)

CREATE TABLE users (
                       id serial4 PRIMARY KEY,
                       first_name varchar(30) NOT NULL,
                       last_name varchar(50) NOT NULL,
                       email varchar(40) NOT NULL UNIQUE,
                       password varchar(20) NOT NULL,
                       user_role FOREIGN KEY REFERENCES roles (id)
)

