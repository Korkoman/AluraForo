CREATE TABLE usuario
(
    id       INT AUTO_INCREMENT primary key not null,
    nombre   VARCHAR(100)                   NOT NULL,
    password VARCHAR(100)                   NOT NULL,
    usuario  VARCHAR(100) UNIQUE            NOT NULL,
    email    VARCHAR(100)                   NOT NULL
)