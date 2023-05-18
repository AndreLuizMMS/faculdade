CREATE TABLE Escola(
        codigo char(11) PRIMARY KEY NOT NULL,
        nome varchar(40) NOT NULL,
        telefone char(10) NOT NULL,
        email varchar(30) NOT NULL,
        website varchar(50) NOT NULL
);

CREATE TABLE Curso(
        codigo char(3) PRIMARY KEY NOT NULL,
        nome varchar(40) NOT NULL,
        descricao varchar(100) NOT NULL,
        carga_hr numeric(3) NOT NULL,
        escola_codigo char(11),
        FOREIGN KEY (escola_codigo) REFERENCES Escola(codigo)
);

CREATE TABLE Disciplina(
        codigo varchar(7) PRIMARY KEY NOT NULL,
        nome varchar(40) NOT NULL,
        hr_semana numeric CHECK (hr_semana IN (2, 4, 6, 8, 10, 12)),
        carga_hr numeric(2) NOT NULL,
        escola_codigo char(11) NOT NULL,
        curso_codigo char(11) NOT NULL,
        FOREIGN KEY (escola_codigo) REFERENCES Escola(codigo),
        FOREIGN KEY (curso_codigo) REFERENCES Curso(codigo)
);

-- Turma é Fraco de Disciplina
CREATE TABLE Turma(
        idTurma varchar,
        codigo varchar(3) NOT NULL,
        ano numeric(4) NOT NULL,
        semestre numeric(1) NOT NULL,
        vagasDisp numeric(2) NOT NULL,
        vagasOcup numeric(2) NOT NULL,
        PRIMARY KEY (idTurma, codigo, ano, semestre),
        FOREIGN KEY (codigo) REFERENCES Disciplina(codigo)
);

-- Aula, é fraco de turma
CREATE TABLE Aula(
        idAula varchar NOT NULL,
        diaSem varchar(3) CHECK (diaSem IN ('seg', 'ter', 'qua', 'qui', 'sex', 'sab')) NOT NULL,
        hrInicio time NOT NULL,
        hrFim time NOT NULL,
        tipoAula varchar(1) CHECK (tipoAula IN ('P', 'L')) NOT NULL,
        FOREIGN KEY (idAula) REFERENCES Turma(idTurma),
        PRIMARY KEY (idAula, diaSem, hrInicio),
);

CREATE TABLE Aluno(
        identidade varchar(12) NOT NULL,
        cpf varchar(14) NOT NULL PRIMARY KEY,
        doc_id varchar(26) GENERATED ALWAYS AS (identidade || cpf),
        endereco varchar(200) NOT NULL,
        sexo varchar(1) NOT NULL CHECK (sexo IN ('M', 'F')),
        dtNasc date NOT NULL,
        tel_contato varchar(10),
        email varchar(30)
);

CREATE TABLE Curso_aluno(
        matricula numeric(5) NOT NULL,
        anoInicio numeric(4) NOT NULL,
        anoConclusao numeric(4) NOT NULL,
);

CREATE TABLE Funcionario(
        matricula numeric(5) NOT NULL,
        identidade varchar(12),
        cpf varchar(14),
        doc_id varchar(26) GENERATED ALWAYS AS (identidade || cpf),
        endereco varchar(200) NOT NULL,
        sexo varchar(1) NOT NULL CHECK (sexo IN ('M', 'F')),
        dtNasc date NOT NULL,
        tel_contato varchar(10),
        email varchar(30),
        dtAdm date NOT NULL,
        dtDem date
);

