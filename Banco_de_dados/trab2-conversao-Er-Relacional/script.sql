CREATE TABLE ESCOLA (
        codigo char(11) primary key not null,
        nome varchar(40) not null,
        telefone char(10) not null,
        email varchar(30) not null,
        website varchar(50) not null
);
CREATE TABLE curso(
        codigo char(3) primary key not null,
        nome varchar(40) not null,
        decsricao varchar(100) not null,
        carga_horaria int(3) not null,
);
CREATE TABLE disciplina(
        codigo varchar(7) primary key not null,
        nome varchar(40) not null,
        horas_semana INT CHECK (horasSemana IN (2, 4, 6, 8, 10, 12)),
        carga_hporaria int(2) not null,
);
CREATE TABLE turma(
        -- id_turma varchar(20) not null PRIMARY key,
        codigo varchar(3) not null,
        ano int(4) not null,
        semestre int(1) not null,
        vagas_disp int(2) not null,
        vagas_ocup int(2) not null,
);
create table aula (
        -- id_aula varchar()
        dia_semana varchar(3) not null,
        horario_inicio time not null,
        horario_fim time not null,
        tipo_aula varchar(1) not null,
);
CREATE TABLE aluno (
        -- doc_identificacao varchar(12) NOT NULL PRIMARY KEY,
        identidade varchar(12),
        cpf varchar(14),
        endereco varchar(200) NOT NULL,
        sexo varchar(1) NOT NULL CHECK (sexo IN ('M', 'F')),
        data_nascimento date NOT NULL,
        telefone_contato varchar(10),
        email_contato varchar(30)
);
CREATE TABLE Funcionario (
        matricula INT PRIMARY KEY,
        -- docIdentificacao VARCHAR(50) NOT NULL,
        identidade varchar(12) not null,
        cpf varchar(14),
        endereco VARCHAR(200) NOT NULL,
        sexo varchar(1) NOT NULL CHECK (sexo IN ('M', 'F')),
        dataNascimento DATE NOT NULL,
        telefoneContato int(10),
        emailContato VARCHAR(30),
        dataAdmissao DATE NOT NULL,
        dataDemissao DATE
);

