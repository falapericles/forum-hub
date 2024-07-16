CREATE TABLE usuario (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         senha VARCHAR(255) NOT NULL
);

CREATE TABLE curso (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL
);

CREATE TABLE topico (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        titulo VARCHAR(255) NOT NULL,
                        mensagem TEXT NOT NULL,
                        data_criacao DATETIME NOT NULL,
                        status VARCHAR(255) NOT NULL,
                        autor_id BIGINT NOT NULL,
                        curso_id BIGINT NOT NULL,
                        CONSTRAINT fk_autor FOREIGN KEY (autor_id) REFERENCES usuario(id),
                        CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES curso(id)
);
