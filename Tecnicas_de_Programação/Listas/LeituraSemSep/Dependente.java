// package Listas.LeituraSemSep;

public class Dependente {

  public String depType;
  public String depName;
  // public String depBirth;

  Dependente(String depName, String depType) {
    this.depName = depName;
    this.depType = depType;
  }

  public void print() {
    System.out.println(depName);
    System.out.println(depType);
  }

}
