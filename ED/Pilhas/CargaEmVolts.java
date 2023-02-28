package Pilhas;

import java.util.*;

public class CargaEmVolts {

  int topo;
  static final int m = 7;
  static double[] elem = new double[m];
  double total = 0;

  public static void main(String[] args) {

    CargaEmVolts pilha = new CargaEmVolts();

    pilha.create();
    pilha.push(2.1);
    pilha.push(5.9);
    pilha.print();
    pilha.printTotal();

  }

  public void printTotal() {
    for (int i = 0; i < elem.length; i++) {
      total = total + elem[i];
    }
    System.out.println(total);
    System.out.println("topo: " + elem[0]);
  }

  // ------------------------------------ criaPilha
  public void create() { // topo indica o index do primeiro elemento
    topo = -1; // -1 == vazio

  }

  // ------------------------------------ push
  public void push(double dado) {
    if (topo == m - 1) {
      return;
    }

    topo++;
    elem[topo] = dado;
    return;

  }

  // -------------------------------- pop
  public void pop() {
    if (topo == 0) {
      return;
    }
    System.out.println("Pop: " + elem[topo]);
    topo = topo - 1;
    return;

  }

  // ------------------------------- consultaPilha
  public void lastElement() {
    if (topo == -1) {
      return;
    } else {
      System.out.println("Pop: " + elem[topo]);
      return;
    }
  }

  // ------------------------------- exibePilha
  public void print() {
    System.out.print("Pilha: ");
    if (topo != -1) { // existe alguem na pilha
      for (int i = topo; i >= 0; i--) {
        System.out.print(elem[i] + " ");
      }
      System.out.println();
    }
  }

}
