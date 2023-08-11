public class Naturais_n {

  public static void main(String[] args) {
    System.out.println(naturaisAteN(10));
  }

  public static int naturaisAteN(int n) {
    if (n < 1) {
      return 0;
    }

    return naturaisAteN(n);
  }
}
