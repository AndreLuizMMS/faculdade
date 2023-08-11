package LinkedList.Linked_p18;

import java.util.*;
import LinkedList.Custom_LinkedDescritor.LinkedDescritor;

public class Linked_p18 {

  public static void main(String[] args) {

    // created remove Lirst
    // created remove Last
    Scanner sc = new Scanner(System.in);
    LinkedDescritor list = new LinkedDescritor();

    int value;
    while (true) {
      System.out.println("0-Inserir na Direita 1-Inserir na Esquerda");
      int loc = sc.nextInt();

      System.out.print("Nodo: ");
      value = sc.nextInt();

      if (value == 0) {
        break;
      }

      if (loc == 1) {
        list.pushLeft(value);
        System.out.println("pushLeft()");
      } else if (loc == 0) {
        list.pushRight(value);
        System.out.println("pushRight()");
      }
    }
    list.print();

    list.removeFirst();
    list.print();

    list.removeLast();
    list.print();

    sc.close();

  }
}