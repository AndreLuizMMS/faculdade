package LinkedList.Custom_LinkedDescritor;

public class LinkedDescritor {

  public Nodo head = null;
  public int n = 0; // n° de elementos
  public Nodo tail = null;

  // ---------------------------------------------------------------- p_17
  // ------------------- inserir na esquerda
  public void pushLeft(int value) {
    Nodo node = new Nodo();
    node.value = value;

    if (n == 0) { // lista vazia
      // head e tail sao o mesmo elemento
      head = node;
      tail = node;
      // como tem só um, .next == null
      node.next = null;
      n = n + 1;
      return;
    }

    // node entra na esquerda
    node.next = head;
    head = node;

    // +1 elemento
    n++;
  }

  // ------------------- inserir na direita
  public void pushRight(int value) {
    Nodo node = new Nodo();
    node.value = value;

    if (n == 0) {
      head = node;
      tail = node;
      n++;
      return;
    }

    tail.next = node;
    tail = node;
    node.next = null;
    n++;
  }

  // ------------------- print
  public void print() {
    if (n == 0) {
      System.out.println("Lista Vazia");
      return;
    }

    Nodo node = new Nodo();
    node = head;
    System.out.print("Lista: ");
    while (node != null) {
      System.out.print(node.value + " ");
      node = node.next;
    }
    System.out.println();
  }

  // ------------------- quantos elementos
  public void length() {
    System.out.println(n + " elementos no total");
  }

  // ------------------- ultimo elemento
  public int getLast() {
    if (n == 0) {
      System.out.println("Lista Vazia");
      return 0;
    }

    Nodo node = new Nodo();
    node = tail;
    System.out.println("Ultimo nodo: " + node.value);
    return node.value;
  }

  // ------------------- primeiro elemento
  public int getFirst() {
    if (n == 0) {
      System.out.println("Lista Vazia");
      return 0;
    }

    Nodo node = new Nodo();
    node = head;
    System.out.println("Primeiro nodo: " + node.value);
    return node.value;
  }

  // ---------------------------------------------------------------- p_18

  // created remove First
  // created remove Last

  public void removeFirst() {
    if (n == 0) {
      System.out.println("lista Vazia");
      return;
    }

    System.out.println(head.value + " removido");
    head = head.next;
    n--;
  }

  public void removeLast() {
    if (n == 0) {
      System.out.println("lista Vazia");
      return;
    }

    System.out.println(tail.value + " removido");
    tail = null;
    n--;
  }
}
