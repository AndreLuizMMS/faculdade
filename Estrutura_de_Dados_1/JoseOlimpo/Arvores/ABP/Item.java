package Arvores.ABP;

public class Item {

  public String nome, fone;

  public Item(String nome, String fone) {
    this.nome = nome;
    this.fone = fone;
  }

  public String getFone() {
    return fone;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return ("nome: " + nome + ", fone: " + fone);
  }
}
