package Listas.Strings;

import java.util.Scanner;

public class NumerosPorExtenso {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Digite um número: ");
    int numero = sc.nextInt();

    String[] numerosPorExtenso = { "zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove" };

    String numeroString = Integer.toString(numero);
    int tamanho = numeroString.length();

    for (int i = 0; i < tamanho; i++) {
      int digito = Character.getNumericValue(numeroString.charAt(i));
      System.out.print(numerosPorExtenso[digito]);
      if (i < tamanho - 1) {
        System.out.print(", ");
      }
    }

    sc.close();
  }
}
