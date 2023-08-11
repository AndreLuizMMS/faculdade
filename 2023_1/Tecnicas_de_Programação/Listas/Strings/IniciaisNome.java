package Listas.Strings;

import java.util.Scanner;

public class IniciaisNome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite um nome completo: ");
    String nomeCompleto = sc.nextLine();
    String[] partesNome = nomeCompleto.split(" ");

    String iniciais = "";
    for (String parte : partesNome) {
      parte = parte.toLowerCase();
      if (parte.equals("e") || parte.equals("do") || parte.equals("da") || parte.equals("dos") || parte.equals("das")
          || parte.equals("de") || parte.equals("di") || parte.equals("du")) {
        continue;
      }
      iniciais += parte.charAt(0);
    }
    iniciais = iniciais.toUpperCase();
    System.out.println("Iniciais: " + iniciais);
    sc.close();
  }
}
