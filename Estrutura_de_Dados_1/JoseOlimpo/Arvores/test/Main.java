package Arvores.test;

class Node {
  int value;
  Node left;
  Node right;

  public Node(int data) {
    this.value = data;
    left = null;
    right = null;
  }

  public Node() {
    left = null;
    right = null;
  }
}

class Btree {
  Node root;

  public Btree() {
    root = null;
  }

  // verifica se esta vazia
  public boolean isEmpty() {
    if (root == null) {
      return true;
    }
    return false;
  }

  // verifica se valor existe dentro da arvore
  public boolean exists(int data) {
    if (isEmpty()) {
      return false;
    }

    Node aux = root;
    while (aux != null) {
      if (aux.value == data) {
        return true;
      } else {
        if (aux.value < data) { // menor => left
          aux = aux.left;
        } else {// maior => right
          aux = aux.right;
        }
      }
    }
    return false; // não existe
  }

  public void insert(int data) {
    Node aux = new Node(data); // vai entrar na arvore

    if (root == null) { // vazia, estao data sera root, o primeiro
      root = aux;
      return;
    }

    Node current = root; // percorre a arvore a acha o lugar
    Node parent = null; // guarda a posicao anterior pra poder inserir o novo no

    while (current != null) {
      parent = current; // guarda a posicao anterior

      if (current.value < data) { // menor
        current = current.left; // vai pra esquerda
        if (current == null) { // era o ultimo
          parent.left = aux; // entra la
        }

      } else { // maior
        current = current.right; // vai pra diretia
        if (current == null) { // era o ultimo
          parent.right = aux; // entra la
        }
      }
    }

  }


  public class Main {

  }
}
