package LinkedList;

import java.util.*;

public class Linked_p13 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    LinkedList<Integer> lista = new LinkedList<Integer>();

    int nodo = 1;
    int last = 0;

    while (nodo != 0) {
      System.out.print("Nodo: ");
      nodo = sc.nextInt();
      if (nodo != 0) {
        last = nodo;
        lista.add(nodo);
      } else {
        System.out.println("Último elemento: " + last);
      }
    }

    System.out.println("Lista: " + lista);

    sc.close();

  }
}
