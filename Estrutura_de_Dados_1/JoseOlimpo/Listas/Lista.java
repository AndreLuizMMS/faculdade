package Listas;

public class Lista {
  public Nodo head = null;
  public Nodo tail = null;
  public int length = 0;

  public void create() {
    head.next = tail;

  }

  public void print() {
    if (head == null) { // primeiro elemento
      System.out.println("Lista vazia");
      return;
    }

    Nodo current = new Nodo();
    current = head;
    System.out.println();

    while (current != null) {
      System.out.print(current.value);
      current = current.next;
      if (current != null) {
        System.out.print(" -> ");
      }
    }

  }

  public void push(int value) {
    Nodo current = new Nodo();
    current.value = value;

    if (head == null) { // primeiro elemento
      head = current;
      tail = current;
      length++;
      System.out.println(value + " adicionado");
      return;
    }

    tail.next = current;
    length++;
    tail = current;
    current.next = null;
    System.out.println(current.value + " adicionado ");

  }

  public void gpt() {
    if (head == null) { // lista vazia
      System.out.println("Lista vazia");
      return;
    }

    if (head == tail) { // lista com um único elemento
      head = null;
      tail = null;
      length--;
      System.out.println("Elemento removido");
      return;
    }

    Nodo current = head;

    while (current.next != tail) { // percorre a lista até o penúltimo elemento
      current = current.next;
    }

    tail = current; // atualiza a referência para o penúltimo elemento
    tail.next = null;
    length--;
    System.out.println("Elemento removido");
  }

  // public static void main(String[] args) {
  // Lista list = new Lista();

  // list.print();
  // list.push(1);
  // list.push(1);
  // list.push(1);
  // list.push(1);
  // list.push(1);
  // list.print();
  // }
}
