CREATE TABLE Profissao (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE Pessoa (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  profissao_id INT NOT NULL,
  FOREIGN KEY (profissao_id) REFERENCES Profissao(id)
);

CREATE TABLE Telefone (
  id INT PRIMARY KEY AUTO_INCREMENT,
  pessoa_id INT NOT NULL,
  numero VARCHAR(20) NOT NULL,
  FOREIGN KEY (pessoa_id) REFERENCES Pessoa(id)
);

