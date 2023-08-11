package FilaArranjos;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("digite o tamanho da fila: ");
    int n = sc.nextInt();

    Fila fila = new Fila();
    fila.setMaxTam(n);

    for (int i = 1; i <= n; i++) {
      System.out.print("Nome do Cliente " + i + ": ");
      String nome = sc.next();

      System.out.println("Idade do Cliente " + i + ": ");
      int idade = sc.nextInt();

      Cliente entrar = new Cliente(nome, idade);
      fila.push(entrar);

    }

    fila.printFila();
    sc.close();
  }
}
