public class Dependente {

  private int depType;
  private String depName;
  private String depBirth;

  Dependente(String depName, int depType, String depBirth) {
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

    String result;

    switch (this.depType) {
      case 1:
        result = "Pai";
        break;
      case 2:
        result = "Mãe";
        break;
      case 3:
        result = "Cônjuge";
        break;
      case 4:
        result = "Filho";
        break;
      case 5:
        result = "Outros";
        break;
      default:
        result = " ";
        break;
    }

    return result;
  }

}
