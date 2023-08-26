-- 01
SELECT
  codigo_escola,
  nome_escola,
  diretor_escola
FROM
  tab_escolas
  JOIN tab_funcionarios ON tab_escolas.diretor_escola = tab_funcionarios.matricula_funcionario
ORDER BY
  nome_escola;

-- 02
SELECT
  matricula_professor,
  nome_funcionario AS nome_professor,
  EXTRACT(YEAR FROM data_fim_capacit_prof) AS ano_conclusao
FROM
  tab_professores
  JOIN tab_funcionarios ON tab_professores.matricula_professor = tab_funcionarios.matricula_funcionario
  JOIN tab_capacitacoes_professores ON tab_professores.matricula_professor = tab_capacitacoes_professores.matricula_professor
  JOIN tab_tipos_capacitacoes ON tab_capacitacoes_professores.tipo_capacit_prof = tab_tipos_capacitacoes.tipo_capacitacao
WHERE
  tab_tipos_capacitacoes.titulo_obtido_capacitacao = 'DR'
  AND tab_funcionarios.escola_funcionario = 'POLI'
ORDER BY
  nome_professor,
  matricula_professor;

-- 03
SELECT
  tab_professores.matricula_professor,
  tab_funcionarios.nome_funcionario,
  tab_cursos.codigo_curso,
  tab_escolas.codigo_escola
FROM
  tab_professores
  JOIN tab_funcionarios ON tab_professores.matricula_professor = tab_funcionarios.matricula_funcionario
  LEFT JOIN tab_coordenacoes ON tab_professores.matricula_professor = tab_coordenacoes.matricula_professor
  LEFT JOIN tab_direcoes ON tab_professores.matricula_professor = tab_direcoes.matricula_professor
  LEFT JOIN tab_cursos ON tab_coordenacoes.codigo_curso = tab_cursos.codigo_curso
  LEFT JOIN tab_escolas ON tab_direcoes.codigo_escola = tab_escolas.codigo_escola
ORDER BY
  tab_professores.matricula_professor;

-- 04
SELECT
  tab_alunos.matricula_aluno,
  tab_alunos.nome_aluno,
  tab_cursos.nome_curso,
  tab_disciplinas.codigo_disciplina,
  tab_disciplinas.nome_disciplina,
  tab_turmas.codigo_turma,
  tab_turmas.semestre,
  tab_turmas.ano,
  tab_historico_escolar.media_obtida
FROM
  tab_alunos
  JOIN tab_cursos ON tab_alunos.codigo_curso = tab_cursos.codigo_curso
  JOIN tab_historico_escolar ON tab_alunos.matricula_aluno = tab_historico_escolar.matricula_aluno
  JOIN tab_turmas ON tab_historico_escolar.codigo_turma = tab_turmas.codigo_turma
  JOIN tab_disciplinas ON tab_turmas.codigo_disciplina = tab_disciplinas.codigo_disciplina
WHERE
  tab_alunos.matricula_aluno = '20201002500345'
ORDER BY
  tab_alunos.matricula_aluno,
  tab_turmas.ano,
  tab_turmas.semestre,
  tab_disciplinas.codigo_disciplina;

-- 05
SELECT
  tab_professores.matricula_professor,
  tab_professores.nome_professor,
  tab_escolas.nome_escola
FROM
  tab_professores
  JOIN tab_escolas ON tab_professores.codigo_escola = tab_escolas.codigo_escola
WHERE
  tab_professores.matricula_professor NOT IN ( SELECT DISTINCT
      tab_historico_lecionamento.matricula_professor
    FROM
      tab_historico_lecionamento
      JOIN tab_disciplinas ON tab_historico_lecionamento.codigo_disciplina = tab_disciplinas.codigo_disciplina
    WHERE
      tab_disciplinas.nome_disciplina = 'Projeto de Banco de Dados')
ORDER BY
  tab_escolas.nome_escola,
  tab_professores.nome_professor;

-- 06
SELECT
  tab_disciplinas.codigo_disciplina,
  tab_turmas.codigo_turma,
  tab_aulas.dia_semana,
  tab_aulas.horario
FROM
  tab_disciplinas
  JOIN tab_turmas ON tab_disciplinas.codigo_disciplina = tab_turmas.codigo_disciplina
  JOIN tab_aulas ON tab_turmas.codigo_turma = tab_aulas.codigo_turma
WHERE
  tab_disciplinas.nome_curso = 'Ciência da Computação'
  AND tab_turmas.semestre = '2023'
  AND tab_turmas.codigo_turma NOT IN (
    SELECT
      tab_historico_lecionamento.codigo_turma
    FROM
      tab_historico_lecionamento
    WHERE
      tab_historico_lecionamento.codigo_turma = tab_turmas.codigo_turma)
ORDER BY
  tab_disciplinas.codigo_disciplina,
  tab_turmas.codigo_turma,
  tab_aulas.dia_semana,
  tab_aulas.horario;

-- 07 /googleFotos 14/04 21:01
SELECT
  tab_professores.matricula, -- matricula professor
  tab_professores.nome, -- nome professor
  COUNT(tab_historico_lecionamento.codigo_turma) AS quantidade_turmas
FROM
  tab_professores
  JOIN tab_historico_lecionamento ON tab_professores.matricula = tab_historico_lecionamento.matricula_professor --
  JOIN tab_turmas ON tab_historico_lecionamento.codigo_turma = tab_turmas.codigo_turma
WHERE
  tab_turmas.semestre = '2023'
  AND tab_professores.escola = 'Escola Politécnica'
GROUP BY
  tab_professores.matricula,
  tab_professores.nome
HAVING
  quantidade_turmas < 3
ORDER BY
  quantidade_turmas DESC,
  tab_professores.matricula ASC;

-- 08
SELECT
  tab_alunos.matricula,
  tab_alunos.nome,
  tab_historico_reprovacoes.ano,
  tab_historico_reprovacoes.semestre,
  COUNT(tab_historico_reprovacoes.codigo_disciplina) AS quantidade_reprovacoes
FROM
  tab_alunos
  JOIN tab_historico_reprovacoes ON tab_alunos.matricula = tab_historico_reprovacoes.matricula_aluno
  JOIN tab_cursos ON tab_alunos.curso = tab_cursos.codigo_curso
WHERE
  tab_cursos.escola = 'Escola Politécnica'
GROUP BY
  tab_alunos.matricula,
  tab_alunos.nome,
  tab_historico_reprovacoes.ano,
  tab_historico_reprovacoes.semestre
HAVING
  quantidade_reprovacoes > 2
ORDER BY
  tab_historico_reprovacoes.ano,
  tab_historico_reprovacoes.semestre,
  tab_alunos.matricula;

