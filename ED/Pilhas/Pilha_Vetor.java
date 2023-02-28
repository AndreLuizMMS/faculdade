package Pilhas;

public class Pilha_Vetor {
  final int SUCESSO = 0;
  final int PILHA_CHEIA = 1;
  final int PILHA_VAZIA = 2;
  static final int m = 7;
  int topo;
  static int[] elem = new int[m];

  public static void main(String[] args) {
    Pilha_Vetor pilha = new Pilha_Vetor(); // pilha[0] == marca o inicio dos elementos

    pilha.create();

    pilha.push(1);
    pilha.push(2);
    pilha.push(3);
    pilha.print();

    pilha.pop();
    pilha.print();

    pilha.lastElement();

  }

  // ------------------------------------ criaPilha
  public void create() { // topo indica o index do primeiro elemento
    topo = -1; // -1 == vazio

  }

  // ------------------------------------ push
  public int push(int dado) {
    if (topo == m - 1) {
      return (PILHA_CHEIA);
    }
    topo++;
    elem[topo] = dado;
    return (SUCESSO);

  }

  // -------------------------------- pop
  public int pop() {
    if (topo == -1) {
      return (PILHA_VAZIA);
    }
    System.out.println("Pop: " + elem[topo]);
    topo = topo - 1;
    return (SUCESSO);

  }

  // ------------------------------- consultaPilha
  public int lastElement() {
    if (topo == -1) {
      return (PILHA_VAZIA);
    } else {
      System.out.println("Pop: " + elem[topo]);
      return (SUCESSO);
    }
  }

  // ------------------------------- exibePilha
  public void print() {
    System.out.print("Pilha: ");
    if (topo != -1) { // existe alguem na pilha
      for (int i = topo; i >= 0; i--) {
        System.out.print(elem[i] + " ");
      }
      System.out.println();
    }
  }

  // ------------------------------------------ imprimeErro
  public void printError(int erro) {
    switch (erro) {
      case PILHA_CHEIA:
        System.out.println("ERRO: Pilha Cheia");
        break;
      case PILHA_VAZIA:
        System.out.println("ERRO: Pilha Vazia");
        break;
    }
  }

}
