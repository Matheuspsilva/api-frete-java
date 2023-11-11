CREATE TABLE empresa (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    endereco VARCHAR(255),
    telefone VARCHAR(255),
    cnpj VARCHAR(255)
);

CREATE TABLE rota (
    id BIGSERIAL PRIMARY KEY,
    distancia FLOAT,
    nome VARCHAR(255),
    enderecoOrigem VARCHAR(255),
    enderecoDestino VARCHAR(255)
);

CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255)
);

CREATE TABLE frete (
    id BIGSERIAL PRIMARY KEY,
    descricao VARCHAR(255),
    valor FLOAT,
    dataEntrega DATE,
    status_id BIGSERIAL,
    remetente_id BIGSERIAL,
    destinatario_id BIGSERIAL,
    transportadora_id BIGSERIAL,
    rota_id BIGSERIAL,
    FOREIGN KEY (remetente_id) REFERENCES empresa(id),
    FOREIGN KEY (destinatario_id) REFERENCES empresa(id),
    FOREIGN KEY (transportadora_id) REFERENCES empresa(id),
    FOREIGN KEY (rota_id) REFERENCES rota(id)
);
