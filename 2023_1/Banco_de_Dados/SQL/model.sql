-- Criação da tabela Tab_Departamentos
CREATE TABLE Tab_Departamentos(
  codigoDepto int NOT NULL,
  nomeDepto varchar(50) NOT NULL,
  gerenteDepto int,
  PRIMARY KEY (codigoDepto),
  FOREIGN KEY gerenteDepto REFERENCES Tab_Empregados(matriculaEmp),
);

-- Criação da tabela Tab_Empregados
CREATE TABLE Tab_Empregados(
  matriculaEmp int NOT NULL,
  nomeEmp varchar(50) NOT NULL,
  salarioEmp DECIMAL(10, 2) NOT NULL,
  deptoEmp int,
  PRIMARY KEY (matriculaEmp),
  FOREIGN KEY (deptoEmp) REFERENCES Tab_Departamentos(codigoDepto)
);

-- Criação da tabela Tab_Dependentes
CREATE TABLE Tab_Dependentes(
  matriculaEmp int NOT NULL,
  nomeDepend varchar(50) NOT NULL,
  dataNascDepend date NOT NULL,
  GrauParentesco varchar(20) NOT NULL,
  FOREIGN KEY (matriculaEmp) REFERENCES Tab_Empregados(matriculaEmp),
);

-- Criação da tabela Tab_Projetos
CREATE TABLE Tab_Projetos(
  numeroProj int NOT NULL,
  nomeProj varchar(50) NOT NULL,
  localProj varchar(50) NOT NULL,
  deptoProj int,
  PRIMARY KEY (numeroProj),
  FOREIGN KEY (deptoProj) REFERENCES Tab_Departamentos(codigoDepto)
);

CREATE TABLE Tab_HorasAlocadas(
  projeto int NOT NULL,
  empregado varchar(50) NOT NULL,
  horas int NOT NULL,
  PRIMARY KEY (projeto),
  FOREIGN KEY (empregado) REFERENCES Tab_Empregados(matriculaEmp),
  FOREIGN KEY (projeto) REFERENCES Tab_Projetos(numeroProj),
);

