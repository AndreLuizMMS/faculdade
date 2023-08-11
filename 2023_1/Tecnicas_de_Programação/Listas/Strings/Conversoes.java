package Listas.Strings;

import java.util.Scanner;

public class Conversoes {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Item a
    System.out.print("Digite um valor inteiro: ");
    int num = scanner.nextInt();
    char ch = (char) num;
    System.out.println("O caractere correspondente é: " + ch);

    // Item b
    System.out.print("Digite um caractere: ");
    char ch2 = scanner.next().charAt(0);
    int num2 = (int) ch2;
    System.out.println("O número correspondente é: " + num2);

    // Item c
    System.out.print("Digite um nome com sobrenome em letras minúsculas: ");
    scanner.nextLine();
    String nome1 = scanner.nextLine();
    String nomeMaiusculo = nome1.toUpperCase();
    System.out.println("O nome em maiúsculas é: " + nomeMaiusculo);

    // Item d
    System.out.print("Digite um nome com sobrenome em letras minúsculas: ");
    String nome2 = scanner.nextLine();
    String[] partesNome = nome2.split(" ");
    String novoNome = "";
    for (String parte : partesNome) {
      novoNome += parte.substring(0, 1).toUpperCase() + parte.substring(1) + " ";
    }
    System.out.println("O novo nome é: " + novoNome.trim());

    // Item e
    System.out.print("Digite um nome com sobrenome em letras maiúsculas: ");
    String nome3 = scanner.nextLine();
    String[] partesNome2 = nome3.split(" ");
    String novoNome2 = "";
    for (String parte : partesNome2) {
      novoNome2 += parte.substring(0, 1).toUpperCase() + parte.substring(1).toLowerCase() + " ";
    }
    System.out.println("O novo nome é: " + novoNome2.trim());

    scanner.close();
  }

}
