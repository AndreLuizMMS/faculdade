package Pilhas.dynamic;

import java.util.*;

/**
 * PilhaDinamica
 */
public class PilhaDinamica {
  final int SUCESSO = 0;
  final int PILHA_VAZIA = 2;
  private Nodo top;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

  }

  public void create() {
    top = null;
  }

  public void push(int value) {
    Nodo p = new Nodo();
    p.value = value;
    p.next = top;
    top = p;

  }
}