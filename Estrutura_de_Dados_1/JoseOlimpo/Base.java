package JoseOlimpo;

import java.util.*;

public class Base {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Quantidade de Livros: ");
    int n = sc.nextInt();
    Livro[] lista = new Livro[n];

    for (int i = 0; i < n; i++) {
      System.out.print("Nome do livro :");
      String nome = sc.next();

      System.out.print("Autor do livro :");
      String autor = sc.next();

      System.out.println("Preço: ");
      int preco = sc.nextInt();

      Livro livro = new Livro(nome, preco, autor);
      lista[i] = livro;

      if (i + 2 <= n) {
        System.out.println("Príximo Livro");
        System.out.println();
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.println("Lirvo " + i + " ");
      Livro.printList(lista[i]);
      System.out.println();
      System.out.println();
    }
  }
}
