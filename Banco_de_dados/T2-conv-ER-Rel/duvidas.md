# III - Tipos de Relacionamento
  » III.6 
    como representar? 
       - aluno so tem matrícula se vinculado a um curso
       - criar tabela *aluno_curso* sendo: 
          `CREATE TABLE aluno_curso(
            matricula numeric(5) NOT NULL,
            anoInicio numeric(4) NOT NULL,
            anoConclusao numeric(4) NOT NULL,
          );`
          
        
