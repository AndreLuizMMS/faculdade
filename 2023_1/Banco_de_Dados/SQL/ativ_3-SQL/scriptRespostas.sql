-- 01
SELECT
  tab_escolas.codigo_escola,
  tab_escolas.nome_escola,
  tab_funcionarios.nome_funcionario
FROM
  tab_escolas
  JOIN tab_funcionarios ON tab_escolas.diretor_escola = tab_funcionarios.matricula_funcionario
ORDER BY
  tab_escolas.nome_escola;

-- 02
SELECT
  tab_professores.matricula_professor,
  tab_funcionarios.nome_funcionario AS nome_professor,
  tab_capacitacoes_professores.data_fim_capacit_prof AS ano_conclusao_doutorado
FROM
  tab_professores
  JOIN tab_funcionarios ON tab_professores.matricula_professor = tab_funcionarios.matricula_funcionario
  JOIN tab_capacitacoes_professores ON tab_professores.matricula_professor = tab_capacitacoes_professores.matricula_professor
  JOIN tab_tipos_capacitacoes ON tab_capacitacoes_professores.tipo_capacit_prof = tab_tipos_capacitacoes.tipo_capacitacao
  JOIN tab_escolas ON tab_funcionarios.escola_funcionario = tab_escolas.codigo_escola
WHERE
  tab_tipos_capacitacoes.titulo_obtido_capacitacao = 'DR'
  AND tab_escolas.nome_escola = 'Escola Politécnica'
ORDER BY
  tab_funcionarios.nome_funcionario,
  tab_professores.matricula_professor;

-- 03
SELECT
  tab_professores.matricula_professor AS matriculaProf,
  tab_funcionarios.nome_funcionario AS nome,
  tab_cursos.codigo_curso AS codCurso,
  tab_escolas.codigo_escola AS codigo_escola
FROM
  tab_professores
  JOIN tab_funcionarios ON tab_funcionarios.matricula_funcionario = matriculaProf
  LEFT JOIN tab_cursos ON tab_cursos.coordenador_curso = matriculaProf
  LEFT JOIN tab_escolas ON tab_escolas.diretor_escola = matriculaProf
ORDER BY
  matriculaProf;

-- 04
SELECT
  tab_alunos_cursos.matricula_aluno_curso AS matAluno,
  tab_alunos.nome_aluno AS nomeAluno,
  tab_cursos.nome_curso AS nomeCurso,
  tab_disciplinas.codigo_disciplina AS codDis,
  tab_disciplinas.nome_disciplina AS nomeDis,
  tab_turmas.codigo_turma AS codTurma,
  tab_turmas.ano_turma AS ano,
  tab_turmas.semestre_turma AS semestre,
  at.media_final_aluno_turma AS media
FROM
  tab_alunos_turmas at
  JOIN tab_alunos_cursos ON at.matricula_aluno_curso = tab_alunos_cursos.matricula_aluno_curso
  JOIN tab_alunos ON tab_alunos_cursos.id_aluno = tab_alunos.id_aluno
  JOIN tab_turmas ON at.id_turma = tab_turmas.id_turma
  JOIN tab_disciplinas ON tab_turmas.codigo_disciplina_turma = tab_disciplinas.codigo_disciplina
  JOIN tab_cursos ON tab_alunos_cursos.codigo_curso = tab_cursos.codigo_curso
WHERE
  tab_alunos_cursos.matricula_aluno_curso = '20201002500345'
ORDER BY
  tab_alunos_cursos.matricula_aluno_curso,
  tab_turmas.ano_turma,
  tab_turmas.semestre_turma,
  tab_disciplinas.codigo_disciplina;

-- 05
SELECT
  tab_professores.matricula_professor AS matProfessor,
  tab_professores.nome_professor AS nomeProfessor,
  tab_escolas.nome_escola AS nomeEscola
FROM
  tab_professores
  JOIN tab_escolas ON tab_professores.escola_professor = tab_escolas.codigo_escola
WHERE
  NOT (
    SELECT
      1
    FROM
      tab_aulas
      JOIN tab_disciplinas ON tab_aulas.codigo_disciplina_turma = tab_disciplinas.codigo_disciplina
    WHERE
      tab_aulas.professor_aula = tab_professores.matricula_professor
      AND tab_disciplinas.nome_disciplina = 'Projeto de Banco de Dados')
ORDER BY
  tab_escolas.nome_escola,
  tab_professores.nome_professor;

-- 06
SELECT
  tab_disciplinas.codigo_disciplina,
  tab_turmas.codigo_turma,
  tab_aulas.dia_semana_aula,
  tab_aulas.hora_inicio_aula
FROM
  tab_disciplinas
  JOIN tab_disciplinas_cursos ON tab_disciplinas.codigo_disciplina = tab_disciplinas_cursos.codigo_disciplina
  JOIN tab_cursos ON tab_disciplinas_cursos.codigo_curso = tab_cursos.codigo_curso
  JOIN tab_turmas ON tab_disciplinas_cursos.codigo_disciplina = tab_turmas.codigo_disciplina_turma
  LEFT JOIN tab_aulas ON tab_turmas.id_turma = tab_aulas.id_turma_aula
WHERE
  tab_cursos.nome_curso = 'Ciência da Computação'
  AND tab_turmas.semestre_turma = 2
  AND tab_turmas.ano_turma = 2023
  AND (tab_aulas.professor_aula IS NULL
    OR tab_aulas.professor_aula = 0)
ORDER BY
  tab_disciplinas.codigo_disciplina,
  tab_turmas.codigo_turma,
  tab_aulas.dia_semana_aula,
  tab_aulas.hora_inicio_aula;

-- 07
SELECT
  tab_professores.matricula_professor,
  tab_funcionarios.nome_funcionario,
  COUNT(tab_turmas.id_turma) AS quantidade_turmas
FROM
  tab_professores
  JOIN tab_funcionarios ON tab_professores.matricula_professor = tab_funcionarios.matricula_funcionario
  JOIN tab_aulas ON tab_professores.matricula_professor = tab_aulas.professor_aula
  JOIN tab_turmas ON tab_aulas.id_turma_aula = tab_turmas.id_turma
  JOIN tab_disciplinas ON tab_turmas.codigo_disciplina_turma = tab_disciplinas.codigo_disciplina
  JOIN tab_cursos ON tab_disciplinas.codigo_disciplina = tab_cursos.codigo_curso
  JOIN tab_escolas ON tab_cursos.escola_curso = tab_escolas.codigo_escola
WHERE
  tab_escolas.nome_escola = 'Escola Politecnica'
  AND tab_turmas.semestre_turma = 2
  AND tab_turmas.ano_turma = 2023
GROUP BY
  tab_professores.matricula_professor,
  tab_funcionarios.nome_funcionario
HAVING
  COUNT(tab_turmas.id_turma) < 3
ORDER BY
  quantidade_turmas DESC,
  tab_professores.matricula_professor ASC;

-- 08
SELECT
  tab_professores.matricula_professor,
  tab_professores.nome_professor,
  COUNT(tab_turmas.id_turma) AS quantidade_turmas
FROM
  tab_professores
  JOIN tab_aulas ON tab_professores.matricula_professor = tab_aulas.professor_aula
  JOIN tab_turmas ON tab_aulas.id_turma_aula = tab_turmas.id_turma
  JOIN tab_disciplinas ON tab_aulas.codigo_disciplina_turma = tab_disciplinas.codigo_disciplina
  JOIN tab_escolas ON tab_disciplinas.escola_disciplina = tab_escolas.codigo_escola
WHERE
  tab_escolas.nome_escola = 'Escola Politécnica'
  AND tab_turmas.semestre_turma = 2
  AND tab_turmas.ano_turma = 2023
GROUP BY
  tab_professores.matricula_professor,
  tab_professores.nome_professor
HAVING
  COUNT(tab_turmas.id_turma) < 3
ORDER BY
  quantidade_turmas DESC,
  tab_professores.matricula_professor ASC;

