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
    System.out.print("Nome: " + nome);
    System.out.print(" CPF: " + cpf);
    System.out.print(" Endereço: " + endereco);
  }

}