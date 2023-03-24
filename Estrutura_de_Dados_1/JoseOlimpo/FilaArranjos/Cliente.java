package FilaArranjos;

public class Cliente {

  public int idade;
  public String nome;

  Cliente(String nome, int idade) {
    if (idade < 1) {
      System.out.println("idade inválida");
      return;
    }
    this.nome = nome;
    this.idade = idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCliente() {
    String cliente = " Cliente " + nome + ", idade " + idade;
    return cliente;
  }

}
