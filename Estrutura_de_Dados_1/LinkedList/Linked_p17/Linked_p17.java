package LinkedList.Linked_p17;

import java.util.*;
import LinkedList.Custom_LinkedDescritor.LinkedDescritor;

public class Linked_p17 {

  public static void main(String[] args) {
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
    sc.close();
  }
}
