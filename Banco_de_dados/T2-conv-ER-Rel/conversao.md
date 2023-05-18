<!-- Mapear conjuntos de entidades regulares 
  incluir todos os atributos simples 
  chave primaria = atributo identificador 
  se houver mais de um atributo identificador, criar chave primaria compostas
  reduzir valores dos atributos -->

Mapear conjuntos de entidades fracas
  ent fracas viram tabelas 
  PK da ent forte, é FK da fraca
  se a fraca tiver atr id, esse é uma chave parcial
  chave parcial = parte da chave primaria da tabela 
  chave primária = cmoposição da chave estrangeira + chave parcial (sae houver) 

Mapear conjuntos de relacionamentos binario 1:1
Mapear conjuntos de relacionamentos binario regular 1:n
Mapear conjuntos de relacionamentos binario m:n
Mapear atributos mltivalorados ou compostos
Mapear conjuntos de relacionamento n-ário, n > 2
Relacionamento recursivo 



# Entidades 
  » Entidades regulares viram tabelas, com atributos simples 
  » Escolher chave primaria
  ----------------------------
  » Entidades fracas viram tabelas e a chave primaria de sua entidade forte é colocada como chave estrangeira, junto com a chae da entidade fraca (se houver), forma a chave primaria correspondente 

