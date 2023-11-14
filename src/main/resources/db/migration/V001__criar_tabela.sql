CREATE TABLE empresa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    endereco VARCHAR(255),
    telefone VARCHAR(255),
    cnpj VARCHAR(255)
);

CREATE TABLE rota (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    distancia FLOAT,
    nome VARCHAR(255),
    enderecoOrigem VARCHAR(255),
    enderecoDestino VARCHAR(255)
);

CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255)
);

CREATE TABLE frete (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255),
    valor DOUBLE,
    data_entrega DATE,
    status VARCHAR(255),
    remetente_id BIGINT,
    destinatario_id BIGINT,
    transportadora_id BIGINT,
    rota_id BIGINT,

    FOREIGN KEY (remetente_id) REFERENCES empresa(id),
    FOREIGN KEY (destinatario_id) REFERENCES empresa(id),
    FOREIGN KEY (transportadora_id) REFERENCES empresa(id),
    FOREIGN KEY (rota_id) REFERENCES rota(id)
);
