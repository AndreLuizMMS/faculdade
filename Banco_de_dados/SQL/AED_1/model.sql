CREATE TABLE tab_produto(
  cod_produto int NOT NULL AUTO_INCREMENT,
  nome_produto varchar(50) NOT NULL,
  unidade varchar(2),
  valor_unit int,
  CHECK (unidade = 'un' OR unidade = 'ml' OR unidade = 'g'),
  PRIMARY KEY (cod_produto)
);

