package  LinkedList.Custom_LinkedList;

public class Lista_encadeda {
  private Nodo head = null;
  private Nodo tail = null;

  // ------------------------------- add node
  public void push(int value) {
    Nodo node = new Nodo();
    node.value = value;

    if (head == null) {
      head = node;
    } else {
      tail.next = node;
    }
    node = tail;
  }

  // ------------------------------- remove head
  public int removeHead() {
    Nodo aux, tmp;
    aux = head;
    tmp = head;

    if (aux != null) {
      head = aux.next;
      if (head == null) {
        tail = null;
      }
      return (tmp.value);
    }

    return (0);
  }

  // ------------------------------- imprimirLista
  public void imprimirLista() {
    Nodo aux;
    aux = head;
    System.out.print("Lista Encadeada: ");
    if (aux != null) {
      while (aux != null) {
        System.out.print(aux.value + " ");
        aux = aux.next;
      }
    } else {
      System.out.print("Vazia");
    }
    System.out.println();
  }
}
