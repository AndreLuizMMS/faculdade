import java.util.*;

public class InvertNumber {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    System.out.println(invertNumber(num));

    sc.close();
  }

  public static int invertNumber(int num) {
    if (num < 10) {
      return num;
    }

    int lastDigit = num % 10;
    int remainingDigits = num / 10;
    int invertedRemainingDigits = invertNumber(remainingDigits);


    return Integer.parseInt(String.valueOf(lastDigit) + String.valueOf(invertedRemainingDigits));

  }
}
