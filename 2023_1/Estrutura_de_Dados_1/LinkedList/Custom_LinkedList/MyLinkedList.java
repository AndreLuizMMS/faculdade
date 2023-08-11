package LinkedList.Custom_LinkedList;

public class MyLinkedList {

  private Nodo head = null;
  private Nodo tail = null;

  public void push(int value) {
    Nodo node = new Nodo();
    node.value = value;

    if (head == null) { // lista vazia
      head = node;
    } else {
      tail.next = node;
    }

    tail = node;

  }

  public void deleteHead() {
    if (head == null) {
      System.out.println("Lista Vazia");
      return;
    }

    System.out.println("Head removed: " + head.value);

    head = head.next;

  }

  public int peekHead() {

    if (head == null) {
      System.out.println("Lista Vazia ");
      return 0;
    }

    System.out.println("Head: " + head.value);
    return head.value;
  }

  public void print() {
    if (head == null) {
      System.out.println("Lista Vazia");
      return;
    }
    System.out.print("Lista: ");
    System.out.print("[");
    Nodo node = new Nodo();
    node = head;
    while (node != null) {
      if (node.next == null) {
        System.out.print(node.value);
        System.out.print("]");
        return;
      }
      System.out.print(node.value + ", ");
      node = node.next;
    }
    System.out.println();

  }
}
