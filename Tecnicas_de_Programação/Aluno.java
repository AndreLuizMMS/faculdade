
public class Aluno {

  private String nome;
  private int idade;
  private int media;
  private String facul;

  public void createAluno(String nome, int idade, int media, String facul) {
    this.nome = nome;
    this.idade = idade;
    this.media = media;
    this.facul = facul;

    System.out.println("Aluno: " + this.nome + ", idade: " + this.idade + ", media: " + this.media
        + ", Instituição: " + this.facul);
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }
}
