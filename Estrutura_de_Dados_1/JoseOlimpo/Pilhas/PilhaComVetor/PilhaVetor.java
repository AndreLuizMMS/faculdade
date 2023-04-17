package Pilhas.PilhaComVetor;

/**
 * PilhaVetor
 */
public class PilhaVetor {

  private final int m = 7;
  private int top; // [0] no array, indica o index do ultimo elemento
  private int[] pilha = new int[m];

  public void create() {
    top = 0;
  }

  public void push(int value) {
    if (top == m - 1) {// Pilha cheia
      System.out.println("Pilha cheia");
      return;
    }
    top += 1;
    pilha[top] = value;
    System.out.println(value + " adicionado na posição " + top);
  }

  public void pop() {
    if (top == 0) {
      System.out.println("Lista vazia");
      return;
    }
    top--;
    System.out.println(pilha[top] + " Removido");
  }

  public void print() {
    if (top == 0) {
      System.out.println("Pilha vazia");
      return;
    }

    for (int i = 0; i < pilha.length; i++) {
      if (i == 0) {
        System.out.println("Total: " + top + " elementos ");
      } else {
        System.out.println("| " + pilha[i] + " |");
      }
    }
    System.out.println();

  }
}