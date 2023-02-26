import java.util.*;

public class Lista_p07 {
  final static int SUCESSO = 0;
  final static int LISTA_CHEIA = 1;
  final static int LISTA_VAZIA = 2;

  // -------------------------------------------------- criaLista
  static void create(int[] nEle) {
    nEle[0] = 0;
  }

  // -------------------------------------------------- adiciona no fim
  static int push(int vLength, int[] v, int valor) {
    int n = v[0]; // n° de elementos
    if (n < vLength - 1) { // se existe espaço na lista
      v[0]++;
      v[v[0]] = valor;
      return (SUCESSO);
    }
    return (LISTA_CHEIA);
  }

  // -------------------------------------------------- adiciona no inicio
  static int unshift(int vLength, int[] v, int valor) {
    int n = v[0]; // n° de elementos
    if (n < vLength - 1) { // se existe espaço na lista
      v[0]++;
      for (int i = n + 1; i >= 2; i--) {
        // i = n + 1 -> loop inicia da última posição vazia;
        // i >= 2 -> 2 é a primeira posição;
        // i-- -> começa do fim e ta voltando;
        v[i] = v[i - 1]; // muda cada um de posição pra 1° ficar vazia
      }
      v[1] = valor; // valor entra na primeira
      return (SUCESSO);
    }
    return (LISTA_CHEIA);
  }

  // -------------------------------------------------- adiciona pela posição
  static int incluiPos(int vLength, int[] v, int valor, int pos) {
    int n = v[0];

    if (n < vLength - 1) { // se existe espaço na lista
      v[0]++;
      if (pos == n) { // se a posição é a mesma do ultimo elemento;
        v[v[0]] = v[pos]; // último elemento anda uma pra frente;
        v[pos] = valor; // casa vazia recebe valor;
      } else {
        for (int i = n + 1; i >= pos; i--) { // mesma lógica do unshift
          v[i] = v[i - 1];
          // System.out.println("Valor: " + v[i]);
        }
        v[pos] = valor;
      }
      return (SUCESSO);
    }
    return (LISTA_CHEIA);
  }

  // -------------------------------------------------- numeroDeElementos
  static int numeroDeElementos(int[] v) {
    return (v[0]);
  }

  // ------------------------------------- insere na posição correta de ordenação
  static int verificaPos(int m, int[] v, int valor) {

    for (int i = 1; i <= v[0]; i++) {
      if (valor < v[i]) {
        return (incluiPos(m, v, valor, i));
      }
    }
    return (push(m, v, valor));
  }

  // -------------------------------------------------- exibeLista
  static void exibeLista(int[] v) {

    if (v[0] == 0) {
      System.out.println("Lista Vazia");
    } else {
      String s = "";
      for (int i = 1; i <= v[0]; i++) {
        s = s + v[i] + " ";
      }
      System.out.println("Lista: " + s);
    }
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int m = 7;
      int[] v = new int[m];

      int erro;
      create(v);
      int valor = sc.nextInt();
      if (valor != 0) {
        erro = unshift(m, v, valor);
        while (valor != 0) {
          valor = sc.nextInt();
          if (valor != 0) {
            erro = verificaPos(m, v, valor);
            if (erro == LISTA_CHEIA) {
              System.out.println("lista Cheia ");
              exibeLista(v);
              return;
            }
          }
        }
      }
      exibeLista(v);
    }
  }
}
