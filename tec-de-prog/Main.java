
public class Main {

  public static void main(String[] args) {
    Pessoa p = new Pessoa();
    p.setSalaray(4500);

    // System.out.println(p.getSalaray());

    UpperCase met = new UpperCase();
    String newName = met.toUpperCase(p.nome);
    System.out.println(newName);

  }

}
