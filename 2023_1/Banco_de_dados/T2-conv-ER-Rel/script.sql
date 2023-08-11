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
        identidade varchar(12),
        cpf varchar(14),
        doc_id varchar(26) NOT NULL,
        endereco varchar(200) NOT NULL,
        sexo varchar(1) NOT NULL CHECK (sexo IN ('M', 'F')),
        dtNasc date NOT NULL,
        tel_contato varchar(10),
        email varchar(30),
        PRIMARY KEY (doc_id),
        CONSTRAINT doc_id_constraint CHECK ((identidade IS NOT NULL AND cpf IS NOT NULL AND doc_id =(identidade || cpf)) OR (identidade IS NULL AND cpf IS NULL AND doc_id IS NOT NULL))
);

CREATE TABLE Aluno_Curso(
        doc_id varchar(26),
        matricula numeric(5) NOT NULL,
        anoInicio numeric(4) NOT NULL,
        anoConclusao numeric(4) NOT NULL,
        FOREIGN KEY (doc_id) REFERENCES Aluno(doc_id),
        PRIMARY KEY (matricula)
);
CREATE TABLE Aluno_Turma(
    idTurma varchar,
    codigo varchar(3),
    doc_id varchar(26),
    semestre numeric(1),
    situacao char(1) CHECK (situacao IN ('A', 'T', 'C')),
    nota1 numeric(4,2),
    nota2 numeric(4,2),
    mediaFinal numeric(4,2) GENERATED ALWAYS AS ((nota1 + nota2) / 2) STORED,
    frequenciaFinal numeric(3),
    resultadoFinal varchar(3) GENERATED ALWAYS AS (
        CASE
            WHEN mediaFinal >= 6.0 AND frequenciaFinal >= 75 THEN 'AP'
            WHEN mediaFinal < 6.0 AND frequenciaFinal < 75 THEN 'RFM'
            WHEN mediaFinal < 6.0 THEN 'RM'
            WHEN frequenciaFinal < 75 THEN 'RF'
        END
    ) STORED,
    FOREIGN KEY (idTurma, codigo,  semestre) REFERENCES Turma(idTurma, codigo, semestre),
    FOREIGN KEY (doc_id) REFERENCES Aluno(doc_id),
    PRIMARY KEY (idTurma, codigo,  semestre, doc_id)
);


CREATE TABLE Funcionario(
        id varchar(31) NOT NULL,
        matricula numeric(5) NOT NULL,
        identidade varchar(12),
        cpf varchar(14),
        doc_id varchar(26) NOT NULL,
        endereco varchar(200) NOT NULL,
        sexo varchar(1) NOT NULL CHECK (sexo IN ('M', 'F')),
        dtNasc date NOT NULL,
        tel_contato varchar(10),
        email varchar(30),
        dtAdm date NOT NULL,
        dtDem date,
        PRIMARY KEY (doc_id),
        CONSTRAINT doc_id_constraint CHECK ((identidade IS NOT NULL AND cpf IS NOT NULL AND doc_id =(identidade || cpf)) OR (identidade IS NULL AND cpf IS NULL AND doc_id IS NOT NULL))
);

CREATE TABLE Professor(
        id varchar(31),
        PRIMARY KEY (id),
        FOREIGN KEY (id) REFERENCES Funcionario(id),
);

CREATE TABLE Tipo_capacit(
        id varchar(31) NOT NULL,
        FOREIGN KEY (id) REFERENCES Professor(id),
        PRIMARY KEY (id, tipo_capacit),
        tipo_capacit varchar(2) NOT NULL,
        descricao varchar(200) NOT NULL,
        titulacao varchar(1) CHECK (titulacao IN ('B', 'E', 'M', 'D'))
        -- Titulação: Bacharel, Especialista, Mestre, Doutor
);

CREATE TABLE Capacit_professor(
        id varchar(31) NOT NULL,
        FOREIGN KEY (id) REFERENCES Professor(id),
        PRIMARY KEY (numItem),
        numItem numeric(3) NOT NULL,
        nome varchar(50) NOT NULL,
        instituicao varchar(50),
        carga_hr numeric(5),
        dtInicio date,
        dtTermino date,
        observ varchar(200)
);

CREATE TABLE Tec_adm(
        doc_id varchar(26),
        PRIMARY KEY (doc_id),
        FOREIGN KEY (doc_id) REFERENCES Funcionario(doc_id),
);

'