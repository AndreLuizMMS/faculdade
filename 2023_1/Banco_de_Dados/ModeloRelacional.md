# Notação Formal
  Esquema de relação: R(A1, A2, ..., An)
  Instância de relação: r(R)
  Tupla: t = <v1, v2, ..., vn>
  Valor do atributo Ai em uma tupla t: t[Ai] ou t.Ai
  Subtupla: t[Av, Aw, ..., Az]
  Nomes de relações: R, S, Q
  Nomes de instâncias de relações: r, s, q
  Nomes de tuplas: t, u, v

# Esquema de relação 
  estrutura que define a forma como os dados podem ser armazenados 
  
# Chaves da Relação
  
  ## Chave 
    atributo que define uma tupla (linha) Ex: Id

  ## Chave candidata:
    cada chave de uma relação é uma chave candidata a ser a chave primária da
    relação

  ## Chave alternativa (chave única)
    chave candidata que não foi designada a chave primária

  ## Chave Primaria
    chave candidata de maior relevância para o contexto modelado 
     A chave primária é um atributo ou conjunto de atributos que identifica exclusivamente cada tupla em uma tabela.

  ## Chave estrangeira (chave externa):
    A chave estrangeira, por sua vez, é um atributo ou conjunto de atributos em uma tabela que faz *referência à chave primária de outra tabela*

  ## Primaria x Estrangeira
    Considere duas tabelas em um banco de dados: "Clientes" e "Pedidos".

    ° Na tabela "Clientes", a chave primária pode ser o "id_cliente".
    ° Na tabela "Pedidos", pode ser necessário incluir uma chave estrangeira que faça referência ao "id_cliente" da tabela "Clientes". Essa chave estrangeira pode ser chamada de "id_cliente_fk".

  ## Chave simples:
     é uma chave composta por um único atributo.
      Ex: "id_cliente"

  ## Chave composta:
     é uma chave composta pela concatenação de mais de um atributo.
       Ex: "id_pedido" e "id_cliente" para garantir que cada pedido seja identificado exclusivamente pelo seu número de pedido e pelo identificador do cliente que fez o pedido

# Restrições

  ## Restrição de unicidade (ou de identificação)
    especificação de chave primária e chave única de entidade

  ## Restrição de domínio
    especificação dos valores que podem ser vinculados aos atributos da relação

  ## Restrição de opcinalidade
    Representada por restrição `NULL` / `NOT NULL` para definir opcionalidade lógica de propriedades (atributos) da relação
  
  ## Restrição referencial:
    restrição de integridade que garante que uma relação possua uma referência válida para outra relação

  ## Restrição dependência funcional:
    relação entre duas ou mais colunas em uma tabela, onde o valor de uma coluna determina o valor de outra.
      EX: colunas "país" e "capital"

  

  
