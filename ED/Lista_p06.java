

import java.util.*;

public class Lista_p06 {

  final static int SUCESSO = 0;
  final static int LISTA_CHEIA = 1;
  final static int LISTA_VAZIA = 2;

  // -------------------------------------------------- criaLista
  static void create(int[] nEl) { // cria a,lista e armazena quantos elemsntos possui
    nEl[0] = 0;
  }

  // -------------------------------------------------- incluiFim
  static int incluiFim(int m, int[] v, int valor) { // m = n° de elem, v = a lista em si
    // String s;
    int n = v[0];
    if (n < m - 1) {
      v[0]++;
      v[v[0]] = valor;

      return (SUCESSO);
    }

    return (LISTA_CHEIA);
  }

  // -------------------------------------------------- exibeLista

  static void showList(int[] v) {
    int n = v[0];
    if (n == 0) {
      System.out.println("lista vazia");
    } else {
      System.out.print("Lista original: ");
      for (int i = 1; i <= n; i++) { // i = 1 pq v[0] é o numero de elementos na lista
        System.out.print(v[i] + " ");
      }
      System.out.println();
      // bubble sort
      boolean swap = true;
      while (swap) {
        swap = false;
        for (int i = 1; i < n; i++) {
          int temp;
          if (v[i + 1] != 0 && i < n) {
            if (v[i] > v[i + 1]) {
              temp = v[i];
              v[i] = v[i + 1];
              v[i + 1] = temp;
              swap = true;
            }
          }

        }
      }
      System.out.print("Lista ordenanda: ");
      for (int i = 1; i <= n; i++) { // i = 1 pq v[0] é o numero de elementos na lista
        System.out.print(v[i] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // cria a lista
    int m = 11;
    int[] v = new int[m];
    create(v);

    int valor; // valor a ser lido
    int erro = 0;

    // le valores a serem pushados
    valor = 1;
    int nLidos = 0;
    System.out.println("digite os valores: ");
    while (valor != 0 && nLidos < m - 1) {
      valor = sc.nextInt();
      nLidos++;

      if (valor != 0) {
        // erro retorna se é possivel pushar
        erro = incluiFim(m, v, valor); // m = n° de elem, v = a lista em si
        if (erro == LISTA_CHEIA)
          System.out.println("lista cheia");
      }
    }

    showList(v);
    sc.close();
  }
}
