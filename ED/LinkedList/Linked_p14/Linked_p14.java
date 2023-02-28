package LinkedList.Linked_p14;

import java.util.*;

import LinkedList.Custom_LinkedList.Lista_encadeda;

public class Linked_p14 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Lista_encadeda lista = new Lista_encadeda();
    int dado = 1;

    while (dado != 0) {
      System.out.print("Dado: ");
      dado = sc.nextInt();
      if (dado != 0) {
        lista.push(dado);
      }
    }

    lista.imprimirLista();
    dado = lista.removeHead();

    while (dado != 0) {
      System.out.println("Dado Removido: " + dado);
      dado = lista.removeHead();
    }
  }

}