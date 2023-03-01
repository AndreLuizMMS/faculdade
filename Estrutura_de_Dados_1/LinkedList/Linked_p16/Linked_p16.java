
package LinkedList.Linked_p16;

import java.util.*;
import LinkedList.Custom_LinkedList.MyLinkedList;

public class Linked_p16 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    MyLinkedList list = new MyLinkedList();

    // added peekHead in '/LinkedList/Custom_LinkedList/MyLinkedList'

    int dado = sc.nextInt();

    while (dado != 0) {
      list.push(dado);
      dado = sc.nextInt();
    }

    list.deleteHead();
    list.print();

    sc.close();
  }
}
