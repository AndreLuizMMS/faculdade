-- 1
SELECT
  matriculaEmp,
  nomeEmp
FROM
  Tab_Empregados
WHERE
  deptoEmp = '10';

-- 2
SELECT
  nomeEmp,
  matriculaEmp
FROM
  Tab_Empregados
WHERE
  deptoEmp =(
    SELECT
      codigoDepto
    FROM
      Tab_Departamentos
    WHERE
      nomeDepto = 'Tecnologia da Informação')
  AND salarioEmp < 1000;

-- 3
SELECT
  projeto
FROM
  Tab_HorasAlocadas
WHERE
  empregado =(
    SELECT
      matriculaEmp
    FROM
      Tab_Empregados
    WHERE
      nomeEmp = 'João da Silva Vieira')
  AND horas > 30;

-- 4
SELECT
  nomeEmp
FROM
  Tab_Empregados
WHERE
  matriculaEmp =(
    SELECT
      matriculaEmp
    FROM
      Tab_Dependentes
    WHERE
      nomeDepend = NULL);

-- 5
SELECT
  nomeEmp
FROM
  Tab_Empregados
WHERE
  matriculaEmp =(
    SELECT
      gerenteDepto
    FROM
      Tab_Departamentos)
  AND matriculaEmp =(
    SELECT
      matriculaEmp
    FROM
      Tab_Dependentes);

-- 6
SELECT
  nomeEmp,
  matriculaEmp
FROM
  Tab_Empregados
WHERE
  -- trabalhou no projeto
  matriculaEmp =(
    SELECT
      empregado
    FROM
      Tab_HorasAlocadas)
  OR matriculaEmp =(
    -- mesma matricula de gerente
    SELECT
      gerenteDepto
    FROM
      Tab_Departamentos
    WHERE
      codigoDepto =(
        SELECT
          deptoProj
        FROM
          Tab_Projetos));

-- 7
SELECT
  nomeDepto
FROM
  Tab_Departamentos
WHERE
  codigoDepto =(
    SELECT
      AVG(salarioEmp) AS salarioMedio
    FROM
      Tab_Empregados
    WHERE
      AVG(salarioEmp) > 1000);

-- 8
SELECT
  matriculaEmp
FROM
  Tab_Empregados
WHERE
  deptoEmp =(
    SELECT
      codigoDepto
    FROM
      Tab_Departamentos
    WHERE
      nomeDepto = 'Tecnologia da Informação')
  AND matriculaEmp =(
    SELECT
      empregado
    FROM
      Tab_Projetos);

