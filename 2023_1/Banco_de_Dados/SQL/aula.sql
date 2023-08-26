-- 2 & 3
JOIN ON;

-- INNER JOIN & OUTER JOIN
-- 4
EXCEPT
;

-- 5
SELECT
  nomeEmp
FROM
  Tab_Empregados
  JOIN Tab_Departamentos ON
WHERE
  matriculaEmp = gerenteDepto



  -- 6 respostacerta
 
  SELECT matriculaEmp, nomeEmp
  FROM Tab_Empregados
  WHERE matriculaEmp IN (
      SELECT empregado
      FROM Tab_HorasAlocadas)
  UNION
  SELECT matriculaEmp, nomeEmp
  FROM Tab_Empregados
  WHERE matriculaEmp IN (
      SELECT gerenteDepto
      FROM Tab_Departamentos, Tab_Projetos
      WHERE codigoDepto = deptoProj);



--  7 & 8 funcao de grupo
