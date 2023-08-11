package Listas.Strings;

import java.util.Scanner;

public class ContadorPalavras {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite um texto: ");
    String texto = sc.nextLine();
    int numCaracteres = texto.length();
    String[] palavras = texto.split("\\s+");
    int numPalavras = palavras.length;
    System.out.println("Número de caracteres: " + numCaracteres);
    System.out.println("Número de palavras: " + numPalavras);

    sc.close();
  }
}
