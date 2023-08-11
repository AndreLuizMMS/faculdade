package Pilhas.PilhaDinamica;

public class Pilha {

  private Nodo top; // nó mais recente

  public void create() {
    top = null;
  }

  public void push(int value) {
    Nodo current = new Nodo();

    current.value = value;
    current.next = top;
    top = current;

    System.out.println(value + " adicionado");
  }

  public void pop() { // só apaga o valor do ultimo node
    if (top == null) {
      System.out.println("Pilha vazia");
      return;
    }
    Nodo current = new Nodo();

    current = top;
    System.out.println("top removido: " + current.value);
    top = current.next; // top = null;
  }

  public void print() {
    if (top == null) {
      System.out.println("Pilha vazia");
      return;
    }

    Nodo current = top;
    System.out.println("Pilha:");

    while (current != null) {
      System.out.print(current.value + " ");
      current = current.next;
    }
    System.out.println();
  }

  // public void t() {
  // System.out.println(top.next.next.value);
  // }

}
