package herancaSimples.ex01;

public class Animal {

  private String name;
  private double comp;
  private int patas;
  private String cor;
  private String amb;

  Animal(String name, double comp, int patas, String cor, String amb) {
    this.name = name;
    this.comp = comp;
    this.patas = patas;
    this.cor = cor;
    this.amb = amb;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public void setAmb(String amb) {
    this.amb = amb;
  }

  public void setComp(double comp) {
    this.comp = comp;
  }

  public void setName(String name) {
    this.name = name;
  }

  public class Peixe extends Animal {
    private boolean 
  }
}
