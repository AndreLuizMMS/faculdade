/**
 * Contato
 */
public class Contato {

  String nome;
  String endereco;
  long cpf;

  Contato() {
  }

  Contato(String nome, String endereco, long cpf) {
    this.nome = nome;
    this.endereco = endereco;
    this.cpf = cpf;
  }

  public void getContato() {
    System.out.println("Nome: " + nome);
    System.out.println("CPF: " + cpf);
    System.out.println("Endereço: " + endereco);
  }
}