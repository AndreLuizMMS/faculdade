package Listas.RevisaoMetodos;

import java.util.Scanner;

public class Calculadora {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Solicitação dos valores a serem operados
    System.out.print("Digite o primeiro valor: ");
    int valor1 = scanner.nextInt();

    System.out.print("Digite o segundo valor: ");
    int valor2 = scanner.nextInt();

    int opcao;
    do {
      // Apresentação do menu de opções
      System.out.println("\nMenu de opções:");
      System.out.println("1 - Somar");
      System.out.println("2 - Subtrair");
      System.out.println("3 - Multiplicar");
      System.out.println("4 - Dividir");
      System.out.println("5 - Fim");

      // Leitura da opção escolhida pelo usuário
      System.out.print("\nDigite a opção desejada: ");
      opcao = scanner.nextInt();

      // Realização da operação escolhida pelo usuário
      switch (opcao) {
        case 1:
          System.out.println("Resultado: " + somar(valor1, valor2));
          break;
        case 2:
          System.out.println("Resultado: " + subtrair(valor1, valor2));
          break;
        case 3:
          System.out.println("Resultado: " + multiplicar(valor1, valor2));
          break;
        case 4:
          System.out.println("Resultado: " + dividir(valor1, valor2));
          break;
        case 5:
          System.out.println("Fim do programa.");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    } while (opcao != 5);

    scanner.close();
  }

  public static int somar(int valor1, int valor2) {
    return valor1 + valor2;
  }

  public static int subtrair(int valor1, int valor2) {
    return valor1 - valor2;
  }

  public static int multiplicar(int valor1, int valor2) {
    return valor1 * valor2;
  }

  public static double dividir(int valor1, int valor2) {
    return (double) valor1 / valor2;
  }

}
