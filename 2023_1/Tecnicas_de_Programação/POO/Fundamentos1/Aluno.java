package POO.Fundamentos1;

public class Aluno {
  private String nome;
  private int idade;
  private String curso;
  private double nota;

  public Aluno(String nome, int idade, String curso, double nota) {
      this.nome = nome;
      this.idade = idade;
      this.curso = curso;
      this.nota = nota;
  }

  public Aluno(String nome, int idade, String curso) {
      this(nome, idade, curso, 0.0);
  }

  public Aluno(String nome, int idade) {
      this(nome, idade, "", 0.0);
  }

  public Aluno(String nome) {
      this(nome, 0, "", 0.0);
  }

  public String getNome() {
      return nome;
  }

  public int getIdade() {
      return idade;
  }

  public String getCurso() {
      return curso;
  }

  public double getNota() {
      return nota;
  }

  public static void main(String[] args) {
      Aluno aluno1 = new Aluno("João da Silva", 20, "Engenharia", 8.5);
      Aluno aluno2 = new Aluno("Maria dos Santos", 19, "Medicina");
      Aluno aluno3 = new Aluno("Pedro Henrique", 22);
      Aluno aluno4 = new Aluno("Ana Carolina");

      System.out.println("Aluno 1: " + aluno1.getNome() + ", " + aluno1.getIdade() + " anos, " + aluno1.getCurso() + ", nota: " + aluno1.getNota());
      System.out.println("Aluno 2: " + aluno2.getNome() + ", " + aluno2.getIdade() + " anos, " + aluno2.getCurso() + ", nota: " + aluno2.getNota());
      System.out.println("Aluno 3: " + aluno3.getNome() + ", " + aluno3.getIdade() + " anos, " + aluno3.getCurso() + ", nota: " + aluno3.getNota());
      System.out.println("Aluno 4: " + aluno4.getNome() + ", " + aluno4.getIdade() + " anos, " + aluno4.getCurso() + ", nota: " + aluno4.getNota());
  }
}
