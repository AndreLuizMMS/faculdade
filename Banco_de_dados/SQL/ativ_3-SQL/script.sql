-- 01
SELECT
  codigo_escola,
  nome_escola,
  tab_funcionarios.nome_funcionario
FROM
  tab_escolas
  JOIN tab_funcionarios ON tab_escolas.diretor_escola = tab_funcionarios.matricula_funcionario
ORDER BY
  nome_escola;

-- 02
SELECT
  tab_professores.matricula_professor AS matriculaProf,
  tab_funcionarios.nome_funcionario AS nomeProf,
  tab_capacitacoes_professores.data_fim_capacit_prof,
FROM
  tab_professores
  JOIN tab_funcionarios ON tab_funcionarios.matricula_funcionario = matriculaProf
  JOIN tab_capacitacoes_professores ON tab_capacitacoes_professores.matricula_professor = matriculaProf
  JOIN tab_tipos_capacitacoes ON tab_tipos_capacitacoes.tipo_capacitacao = tab_capacitacoes_professores.tipo_capacit_prof
WHERE
  tab_tipos_capacitacoes.titulo_obtido_capacitacao = 'DR'
  AND tab_funcionarios.escola_funcionario = 'Escola Politécnica'
ORDER BY
  nomeProf,
  matriculaProf;

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
-- nome da disciplina,
-- código da turma,
-- semestre e ano e média obtida
--
--
-- tab_alunos_cursos FOREIGN KEY (id_aluno) REFERENCES tab_alunos(id_aluno)
-- tab_alunos_cursos FOREIGN KEY (codigo_curso) REFERENCES tab_cursos(codigo_curso)
-- tab_turmas FOREIGN KEY (codigo_disciplina_turma) REFERENCES tab_disciplinas(codigo_disciplina),
-- tab_aulas FOREIGN KEY (id_turma_aula) REFERENCES tab_turmas(id_turma),
SELECT
  tab_alunos_cursos.matricula_aluno_curso AS matAluno,
  tab_alunos.nome_aluno AS nomeAluno,
  tab_cursos.nome_curso AS nomeCurso,
  tab_disciplinas.codigo_disciplina AS codDis,
  tab_disciplinas.nome_disciplina AS nomeDis,
  tab_turmas.codigo_turma AS codTurma,
  tab_turmas.ano_turma AS ano,
  tab_turmas.semestre_turma AS semestre,
  tab_alunos_turmas.media_final_aluno_turma AS media
FROM
  tab_alunos_cursos
  JOIN tab_alunos ON tab_alunos_cursos.id_aluno = tab_alunos.id_aluno
  JOIN tab_cursos ON tab_alunos_cursos.codigo_curso = tab_cursos.codigo_curso
  JOIN tab_aulas ON tab_turmas.id_turma = tab_aulas.id_turma_aula
  JOIN tab_turmas ON tab_turmas.codigo_disciplina_turma = tab_disciplinas.codigo_disciplina
WHERE
  matAluno = '20201002500345'
ORDER BY
  matAluno,
  ano,
  semestre,
  codDis;

