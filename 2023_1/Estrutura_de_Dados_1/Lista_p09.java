import java.util.*;

public class Lista_p09 {
  final static int SUCESSO = 0;
  final static int LISTA_CHEIA = 1;
  final static int LISTA_CHEIA_direita = 11;
  final static int LISTA_CHEIA_esquerda = -11;
  final static int LISTA_VAZIA = 2;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final int m = 4;
    int[] v = new int[m + 2];

    int valor;

    boolean dirVazio = true;
    boolean esqVazio = true;
    int ch;

    criaLista(v);

    int erro = SUCESSO;
    do {
      exibeLista(v);

      System.out.println(" Valor: ");
      valor = sc.nextInt();

      if (valor != 0) {
        System.out.println(" 0 = Início | 1 = Fim ");
        ch = sc.nextInt();

        if (ch == 0 && esqVazio) {
          erro = incluiInicio(v, valor);
        }
        if (ch == 1 && dirVazio) {
          erro = incluiFim(v, valor);
        }

      }

      imprimeErro(erro);

      if (!dirVazio && !esqVazio) {
        System.out.println();
        System.out.println("LISTA COMPLETAMENTE CHEIA");
        break;
      }
      if (erro == LISTA_CHEIA_direita) {
        dirVazio = false;
      }
      if (erro == LISTA_CHEIA_esquerda) {
        esqVazio = false;
      }

    } while (valor != 0 && erro != LISTA_CHEIA);

    exibeLista(v);
    sc.close();

  }

  // ---------------------------------------------- criaLista
  static void criaLista(int[] v) {
    int inic = 0;
    int fim = v.length - 1; // index da última casa

    // -1 nas extremidades == lista vazia
    // [inic] 0 , [fim] m - 1 == lista cheia / existe algum elemento
    v[inic] = -1;
    v[fim] = -1;
  }

  // ---------------------------------------------- incluiInicio
  static int incluiInicio(int[] v, int dado) {
    int inic = v[0];
    int fim = v[v.length - 1];

    // index do último elemento
    int m = v.length - 2;

    // index do elemento do meio
    int metade = (m / 2) + 1;

    if (inic == -1) {
      // se a lista estiver vazia, dado é o 1° a entrar;
      // inserido sempre no meio

      // apontam pra casa onde dado entra
      inic = metade;
      fim = inic;

      // v[no meio] = dado
      v[inic] = dado;

      // v[0] aponta o index do início da lista
      v[0] = inic;
      // v[última casa] aponta o index do fim da lista
      v[v.length - 1] = fim;

      return (SUCESSO);

    }

    if (v[0] == 1) { // 1° casa ocupada
      return (LISTA_CHEIA_esquerda);
    }

    inic--; // inicio marca um a menos;
    v[inic] = dado; // dado entra na primeira casa;
    v[0] = inic; // v[0] aponta o inicio da lista;
    return (SUCESSO);

  }

  // ---------------------------------------------- incluiFim
  static int incluiFim(int[] v, int dado) {
    int inic = v[0];
    int fim = v[v.length - 1];

    int m = v.length - 2;

    int metade = (m / 2) + 1;

    if (fim == -1) {
      // se a lista estiver vazia, dado é o 1° a entrar;
      // inserido sempre no meio

      // apontam pra casa onde dado entra
      inic = metade;
      fim = inic;

      // v[no meio] = dado
      v[inic] = dado;

      // v[0] aponta o index do início da lista
      v[0] = inic;
      // v[última casa] aponta o index do fim da lista
      v[v.length - 1] = fim;

      return (SUCESSO);
    }

    if (fim == m) { // fim aponta pro último elemento
      return (LISTA_CHEIA_direita);
    }

    fim++;
    v[fim] = dado;
    v[v.length - 1] = fim;

    return (SUCESSO);
  }

  // ---------------------------------------------- imprimeErro
  static void imprimeErro(int erro) {
    switch (erro) {
      case LISTA_VAZIA:
        System.out.println("ERRO: Lista Vazia");
        break;
      case LISTA_CHEIA_direita:
        System.out.println("ERRO: Lista cheia na direita");
        break;
      case LISTA_CHEIA_esquerda:
        System.out.println("ERRO: Lista cheia na esquerda");
        break;
      case LISTA_CHEIA:
        System.out.println("ERRO: Lista cheia ");
        break;

    }
  }

  // ---------------------------------------------- exibeLista
  static void exibeLista(int[] v) {
    int inic = v[0];
    int fim = v[v.length - 1];

    System.out.println("inic: " + inic);
    System.out.println(" fim: " + fim);
    System.out.print("indices: ");
    for (int i = 0; i < v.length; i++) {
      System.out.print(" " + i);
    }
    System.out.println();
    System.out.print("Lista:   ");
    for (int i = 0; i < v.length; i++) {
      System.out.print(" " + v[i]);
    }
    System.out.println();

  }
}