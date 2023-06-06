BEGIN;
--DROP TABLE tab_escolas CASCADE;
CREATE TABLE tab_escolas(
  codigo_escola char(4) NOT NULL,
  nome_escola varchar(40) NOT NULL,
  diretor_escola numeric(5) NOT NULL,
  PRIMARY KEY (codigo_escola),
  UNIQUE (diretor_escola),
  UNIQUE (nome_escola)
);
--DROP TABLE tab_fones_escolas CASCADE;
CREATE TABLE tab_fones_escolas(
  codigo_escola char(4) NOT NULL,
  fone_escola numeric(10) NOT NULL,
  PRIMARY KEY (codigo_escola, fone_escola),
  FOREIGN KEY (codigo_escola) REFERENCES tab_escolas(codigo_escola)
);
--DROP TABLE tab_cursos CASCADE;
CREATE TABLE tab_cursos(
  codigo_curso numeric(3) NOT NULL,
  nome_curso varchar(40) NOT NULL,
  descricao_curso varchar(200) NOT NULL,
  horas_aula_curso numeric(4) NOT NULL,
  escola_curso char(4) NOT NULL,
  coordenador_curso numeric(5) NOT NULL,
  PRIMARY KEY (codigo_curso),
  UNIQUE (nome_curso),
  UNIQUE (coordenador_curso),
  FOREIGN KEY (escola_curso) REFERENCES tab_escolas(codigo_escola)
);
--DROP TABLE tab_alunos CASCADE;
CREATE TABLE tab_alunos(
  id_aluno serial NOT NULL, -- identificador gerado pelo SGBD para o aluno já que ele não tem atributo obrigatório identificador natural
  nome_aluno varchar(40) NOT NULL,
  cart_identidade_aluno varchar(12) NULL,
  cpf_aluno varchar(14) NULL,
  end_aluno varchar(200) NOT NULL,
  sexo_aluno char(1) NOT NULL,
  data_nasc_aluno date NOT NULL,
  PRIMARY KEY (id_aluno),
  UNIQUE (cpf_aluno),
  UNIQUE (cart_identidade_aluno),
  CHECK (sexo_aluno = 'M' OR sexo_aluno = 'F'),
  CHECK (cart_identidade_aluno IS NOT NULL OR cpf_aluno IS NOT NULL)
);
--DROP TABLE tab_fones_alunos CASCADE;
CREATE TABLE tab_fones_alunos(
  id_aluno integer NOT NULL,
  fone_aluno numeric(10) NOT NULL,
  PRIMARY KEY (id_aluno, fone_aluno),
  FOREIGN KEY (id_aluno) REFERENCES tab_alunos(id_aluno)
);
--DROP TABLE tab_funcionarios CASCADE;
CREATE TABLE tab_funcionarios(
  matricula_funcionario numeric(5) NOT NULL,
  nome_funcionario varchar(40) NOT NULL,
  cart_identid_funcionario varchar(12) NULL,
  cpf_funcionario varchar(14) NULL,
  endereco_funcionario varchar(200) NOT NULL,
  sexo_funcionario char(1) NOT NULL,
  data_nasc_funcionario date NOT NULL,
  data_admissao_funcionario date NOT NULL,
  data_demissao_funcionario date NULL,
  escola_funcionario char(4) NOT NULL,
  PRIMARY KEY (matricula_funcionario),
  UNIQUE (cart_identid_funcionario),
  UNIQUE (cpf_funcionario),
  FOREIGN KEY (escola_funcionario) REFERENCES tab_escolas(codigo_escola),
  CHECK (cpf_funcionario IS NOT NULL OR cart_identid_funcionario IS NOT NULL),
  CHECK (sexo_funcionario = 'M' OR sexo_funcionario = 'F')
);
--DROP TABLE tab_fones_funcionarios CASCADE;
CREATE TABLE tab_fones_funcionarios(
  matricula_funcionario numeric(5) NOT NULL,
  fone_funcionario numeric(10) NOT NULL,
  PRIMARY KEY (matricula_funcionario, fone_funcionario),
  FOREIGN KEY (matricula_funcionario) REFERENCES tab_funcionarios(matricula_funcionario)
);
--DROP TABLE tab_professores CASCADE;
CREATE TABLE tab_professores(
  matricula_professor numeric(5) NOT NULL,
  PRIMARY KEY (matricula_professor),
  FOREIGN KEY (matricula_professor) REFERENCES tab_funcionarios(matricula_funcionario)
);
--DROP TABLE tab_tec_administ CASCADE;
CREATE TABLE tab_tec_administ(
  matricula_tecadminist numeric(5) NOT NULL,
  PRIMARY KEY (matricula_tec_administ),
  FOREIGN KEY (matricula_tec_administ) REFERENCES tab_funcionarios(matricula_funcionario)
);
--DROP TABLE tab_disciplinas CASCADE;
CREATE TABLE tab_disciplinas(
  codigo_disciplina char(7) NOT NULL,
  nome_disciplina varchar(40) NOT NULL,
  horas_aula_disciplina numeric(1) NOT NULL,
  escola_disciplina char(4) NOT NULL,
  PRIMARY KEY (codigo_disciplina),
  FOREIGN KEY (escola_disciplina) REFERENCES tab_escolas(codigo_escola),
  CHECK (horas_aula_disciplina IN (2, 4, 6, 8, 10, 12))
);
--DROP TABLE tab_disciplinas_cursos CASCADE;
CREATE TABLE tab_disciplinas_cursos(
  codigo_disciplina char(7) NOT NULL,
  codigo_curso numeric(3) NOT NULL,
  PRIMARY KEY (codigo_disciplina, codigo_curso),
  FOREIGN KEY (codigo_disciplina) REFERENCES tab_disciplinas(codigo_disciplina),
  FOREIGN KEY (codigo_curso) REFERENCES tab_cursos(codigo_curso)
);
--DROP TABLE tab_turmas CASCADE;
CREATE TABLE tab_turmas(
  id_turma serial NOT NULL, -- identificador gerado pelo SGBD para reduzir o tamanhoa da chave primária da tabela e facilitar o tratamento de chaves estrangeiras que referenciam a tabela de Turmas
  codigo_disciplina_turma char(7) NOT NULL,
  codigo_turma char(3) NOT NULL,
  ano_turma numeric(4) NOT NULL,
  semestre_turma numeric(1) NOT NULL,
  PRIMARY KEY (id_turma),
  UNIQUE (codigo_disciplina_turma, codigo_turma, ano_turma, semestre_turma), -- chave natural de turmas (precisa ser mantida para garantir consistência dos dados
  FOREIGN KEY (codigo_disciplina_turma) REFERENCES tab_disciplinas(codigo_disciplina),
  CHECK (semestre_turma = 1 OR semestre_turma = 2)
);
--DROP TABLE tab_tipos_capacitacoes CASCADE;
CREATE TABLE tab_tipos_capacitacoes(
  tipo_capacitacao char(2) NOT NULL,
  descricao_capacitacao varchar(200) NOT NULL,
  titulo_obtido_capacitacao char(1) NULL,
  CHECK (titulo_obtido_capacitacao IN ('BE', 'ES', 'ME', 'DR', 'PD')),
  PRIMARY KEY (tipo_capacitacao)
);
--DROP TABLE tab_capacitacoes_professores CASCADE;
CREATE TABLE tab_capacitacoes_professores(
  matricula_professor numeric(5) NOT NULL,
  numero_capacit_prof integer NOT NULL,
  nome_capacit_prof varchar(50) NOT NULL,
  tipo_capacit_prof numeric(3) NOT NULL,
  responsavel_capacit_prof varchar(50) NULL,
  carga_horaria_capacit_prof numeric(5) NULL,
  data_ini_capacit_prof date NULL,
  data_fim_capacit_prof date NULL,
  observacao_capacit_prof varchar(200) NULL,
  PRIMARY KEY (matricula_professor, numero_capacit_prof),
  FOREIGN KEY (tipo_capacit_prof) REFERENCES tab_tipos_capacitacoes(tipo_capacitacao),
  FOREIGN KEY (matricula_professor) REFERENCES tab_professores(matricula_professor)
);
--DROP TABLE tab_aulas CASCADE;
CREATE TABLE tab_aulas(
  id_turma_aula integer NOT NULL,
  dia_semana_aula char(3) NOT NULL,
  hora_inicio_aula time NOT NULL,
  hora_fim_aula time NOT NULL,
  tipo_aula char(1) NOT NULL,
  professor_aula numeric(5) NULL,
  PRIMARY KEY (id_turma_aula, dia_semana_aula, hora_inicio_aula),
  FOREIGN KEY (id_turma_aula) REFERENCES tab_turmas(id_turma),
  FOREIGN KEY (professor_aula) REFERENCES tab_professores(matricula_professor),
  CHECK (dia_semana_aula IN ('Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab')),
  CHECK (tipo_aula = 'P' OR tipo_aula = 'L')
);
--DROP TABLE tab_alunos_cursos CASCADE;
CREATE TABLE tab_alunos_cursos(
  id_aluno integer NOT NULL,
  codigo_curso numeric(3) NOT NULL,
  matricula_aluno_curso numeric(14) NOT NULL,
  ano_inicio_aluno_curso numeric(4) NOT NULL,
  ano_conclusao_aluno_curso numeric(4) NULL,
  PRIMARY KEY (matricula_aluno_curso),
  UNIQUE (id_aluno, codigo_curso),
  FOREIGN KEY (id_aluno) REFERENCES tab_alunos(id_aluno),
  FOREIGN KEY (codigo_curso) REFERENCES tab_cursos(codigo_curso)
);
--DROP TABLE tab_disciplinas_pre_req CASCADE;
CREATE TABLE tab_disciplinas_pre_req(
  codigo_disciplina char(7) NOT NULL,
  codigo_disciplina_pre_req char(7) NOT NULL,
  PRIMARY KEY (codigo_disciplina, codigo_disciplina_pre_req),
  FOREIGN KEY (codigo_disciplina) REFERENCES tab_disciplinas(codigo_disciplina),
  FOREIGN KEY (codigo_disciplina_pre_req) REFERENCES tab_disciplinas(codigo_disciplina)
);
--DROP TABLE tab_alunos_turmas CASCADE;
CREATE TABLE tab_alunos_turmas(
  matricula_aluno_curso numeric(14) NOT NULL,
  id_turma integer NOT NULL,
  situacao_aluno_turma char(1) NOT NULL DEFAULT 'A',
  n1_aluno_turma numeric(3, 1) NOT NULL DEFAULT 0.0,
  n2_aluno_turma numeric(3, 1) NOT NULL DEFAULT 0.0,
  qtd_frequencia_aluno_turma numeric(3) NOT NULL DEFAULT 0,
  media_final_aluno_turma numeric(3, 1) NOT NULL DEFAULT 0,
  resultado_final_aluno_turma char(3) NULL,
  CHECK (situacao_aluno_turma IN ('A', 'C', 'T')),
  CHECK (resultado_final_aluno_turma IN ('AP', 'RF', 'RN', 'RMF')),
  PRIMARY KEY (matricula_aluno_curso, id_turma),
  FOREIGN KEY (matricula_aluno_curso) REFERENCES tab_alunos_cursos(matricula_aluno_curso),
  FOREIGN KEY (id_turma) REFERENCES tab_turmas(id_turma)
);
--DROP TABLE tab_professores_disciplinas CASCADE;
CREATE TABLE tab_professores_disciplinas(
  matricula_professor numeric(5) NOT NULL,
  codigo_disciplina char(7) NOT NULL,
  PRIMARY KEY (matricula_professor, codigo_disciplina),
  FOREIGN KEY (matricula_professor) REFERENCES tab_professores(matricula_professor),
  FOREIGN KEY (codigo_disciplina) REFERENCES tab_disciplinas(codigo_disciplina)
);
ALTER TABLE tab_escolas
  ADD FOREIGN KEY (diretor_escola) REFERENCES tab_professores(matricula_professor);
ALTER TABLE tab_cursos
  ADD FOREIGN KEY (coordenador_curso) REFERENCES tab_professores(matricula_professor);
END;
