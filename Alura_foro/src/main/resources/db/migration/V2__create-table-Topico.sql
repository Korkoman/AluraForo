CREATE TABLE topico(
                        id INT AUTO_INCREMENT primary key not null,
                        topico VARCHAR(100) NOT NULL ,
                        mensaje VARCHAR(1500) NOT NULL,
                        fecha DATETIME NOT NULL,
                        estatus VARCHAR(50) NOT NULL,
                        autor VARCHAR(100) NOT NULL,
                        curso VARCHAR(100) NOT NULL,
                        usuario_id INT not null,

                        constraint fk_topico_usuario_id foreign key (usuario_id) references usuario(id)

)