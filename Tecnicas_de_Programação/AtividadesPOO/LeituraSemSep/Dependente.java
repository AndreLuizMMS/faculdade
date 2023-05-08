package AtividadesPOO.LeituraSemSep;

public class Dependente {

  public String depType;
  public String depName;
  public String depBirth;

  Dependente(String depName, String depType, String depBirth) {
    this.depName = depName;
    this.depType = depType;
    this.depBirth = depBirth;
  }

  public String getDepBirth() {
    return depBirth;
  }

  public String getDepName() {
    return depName;
  }

  public String getDepType() {
    return depType;
  }

  public void print() {
    System.out.println("Nome: " + depName);
    System.out.println("tipo: " + depType);
    System.out.println("ano: " + depBirth);
    System.out.println();
  }

}
