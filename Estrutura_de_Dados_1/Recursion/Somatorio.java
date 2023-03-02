import java.util.*;

public class Somatorio {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    System.out.println(somatorio(n));
    sc.close();

  }

  static public int somatorio(int n) {
    if (n < 1) {
      return 1;
    }
    return n + somatorio(n - 1);
  }
}
