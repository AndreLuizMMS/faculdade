package Listas.HerancaSimples;

public class Animal {
  private String nome;
  private double comprimento;
  private int numPatas;
  private String cor;
  private String ambiente;

  public Animal(String nome, double comprimento, String cor, String ambiente) {
      this.nome = nome;
      this.comprimento = comprimento;
      this.numPatas = 4;
      this.cor = cor;
      this.ambiente = ambiente;
  }

  public String getNome() {
      return nome;
  }

  public double getComprimento() {
      return comprimento;
  }

  public int getNumPatas() {
      return numPatas;
  }

  public String getCor() {
      return cor;
  }

  public String getAmbiente() {
      return ambiente;
  }

  public void setNumPatas(int numPatas) {
      this.numPatas = numPatas;
  }

  public void setCor(String cor) {
      this.cor = cor;
  }

  public void setAmbiente(String ambiente) {
      this.ambiente = ambiente;
  }
}

 class Peixe extends Animal {
  private String barbatanas;
  private String calda;
  private String escamas;

  public Peixe(String nome, double comprimento, String cor) {
      super(nome, comprimento, cor, "mar");
      this.setNumPatas(0);
      this.barbatanas = "não possui";
      this.calda = "não possui";
      this.escamas = "possui";
  }

  public String getBarbatanas() {
      return barbatanas;
  }

  public void setBarbatanas(String barbatanas) {
      this.barbatanas = barbatanas;
  }

  public String getCalda() {
      return calda;
  }

  public void setCalda(String calda) {
      this.calda = calda;
  }

  public String getEscamas() {
      return escamas;
  }

  public void setEscamas(String escamas) {
      this.escamas = escamas;
  }
}

 class Mamifero extends Animal {
  public Mamifero(String nome, double comprimento, String cor) {
      super(nome, comprimento, cor, "terra");
  }
}

 class Urso extends Mamifero {
  private String alimentoPreferido;

  public Urso(String nome, double comprimento) {
      super(nome, comprimento, "castanho");
      this.alimentoPreferido = "mel";
  }

  public String getAlimentoPreferido() {
      return alimentoPreferido;
  }

  public void setAlimentoPreferido(String alimentoPreferido) {
      this.alimentoPreferido = alimentoPreferido;
  }
}

