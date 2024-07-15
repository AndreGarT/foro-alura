
CREATE TABLE usuarios(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre varchar(100) NOT NULL UNIQUE,
    correo varchar(100) NOT NULL UNIQUE,
    contrasena varchar(300) NOT NULL,

    primary key(id)
);

CREATE TABLE topicos(
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensaje VARCHAR(300) NOT NULL,
    fecha DATETIME NOT NULL,
    estado tinyint NOT NULL,
    curso VARCHAR(100),
    usuario_id BIGINT NOT NULL,

    primary key(id),
    constraint fk_topicos_usuario_id foreign key (usuario_id) references usuarios(id)
);