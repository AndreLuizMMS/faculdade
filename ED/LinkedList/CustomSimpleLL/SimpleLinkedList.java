package LinkedList.CustomSimpleLL;

import LinkedList.Custom_LinkedList.Nodo;

public class SimpleLinkedList {
  private Nodo head = null;

  // ------------------------------- inserirLista
  public void push(int valor) {
    Nodo aux = new Nodo();
    Nodo tmp;
    aux.value = valor;
    if (head == null) { // lista vazia
      head = aux; // primeiro el
    } else {
      tmp = head;
      aux.next = tmp; // paramentro aponta pro q era head
      head = aux; // parametro vira head
    }
  }

  // ------------------------------- removerLista
  public int shift() {
    Nodo aux;
    int value;
    aux = head;
    if (aux != null) {
      value = head.value;
      head = head.next;
      return (value);
    }
    return (0);
  }

  public void print() {

    if (head == null) {
      System.out.println(" Lista vazia ");
    } else {
      Nodo aux = new Nodo();
      aux = head;
      System.out.print("lista: ");
      while (aux != null) {
        System.out.print(" " + aux.value + "");
        aux = aux.next;
      }
    }

  }
}
