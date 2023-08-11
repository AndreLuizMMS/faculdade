package LinkedList.Linked_p14_p15;

import java.util.*;

import LinkedList.Custom_LinkedList.MyLinkedList;

public class Linked_p14_p15 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MyLinkedList lista = new MyLinkedList();
    int dado = 1;

    while (dado != 0) {
      System.out.print("Dado: ");
      dado = sc.nextInt();
      if (dado != 0) {
        lista.push(dado);
      }
    }

    lista.print();
    sc.close();

  }

}