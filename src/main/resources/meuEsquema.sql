create database moments


CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(200) NOT NULL,
  senha VARCHAR(200) NOT NULL,
  nome VARCHAR(200) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (email)
);

CREATE TABLE EMAIL_USUARIO_SUCCESS (
  emailId BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  dataa DATETIME NOT NULL,
  status varchar(20) NOT NULL,
  PRIMARY KEY (emailId)
);


CREATE TABLE Foto (
    id INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    data DATE NOT NULL,
    localizacao VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    album_id INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_album FOREIGN KEY (album_id) REFERENCES Album(id)
);

CREATE TABLE Album (
  id INT NOT NULL AUTO_INCREMENT,
  nome_Album VARCHAR(255) NOT NULL,
  descricao VARCHAR(255),
  data_criacao DATE NOT NULL,
  PRIMARY KEY (id)
);