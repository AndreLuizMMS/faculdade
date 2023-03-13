class Aluno {
  private String nome;
  private int idade;
  private int matricula;
  private String turma;

  public Aluno(String nome, int idade, int matricula) {
    this.nome = nome;
    this.idade = idade;
    this.matricula = matricula;
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  public int getMatricula() {
    return matricula;
  }

  public String getTurma() {
    return turma;
  }

  public void setTurma(String turma) {
    this.turma = turma;
  }
}