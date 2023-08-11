package Pilhas.PilhaComVetor;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PilhaVetor pilha = new PilhaVetor();

    pilha.create();

    int flag = 0;
    int value;
    do {
      System.out.println("-1 => Sair");
      System.out.println(" 1 => Push()");
      System.out.println(" 2 => Pop()");
      flag = sc.nextInt();

      if (flag == -1)
        return;

      if (flag == 1) {
        System.out.println("Valor a ser adicionado");
        value = sc.nextInt();
        pilha.push(value);
        pilha.print();
      }
      if (flag == 2) {
        pilha.pop();
        pilha.print();
      }

    } while (flag != -1);
    sc.close();
  }
}
