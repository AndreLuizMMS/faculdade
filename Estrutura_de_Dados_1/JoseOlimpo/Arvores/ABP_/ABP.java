package Arvores.ABP_;

public class ABP {

  public int tamanho;
  public Node root;

  // inicializaz arvore
  public void Abp() {
    this.root = null;
    this.tamanho = 0;
  }

  public boolean vazia() {
    if (this.root == null) {
      return true;
    }
    return false;
  }

  public Node consultar(Item obj) {
    Node aux = this.root;

    while (aux != null) {
      if (obj.getNome().compareTo(aux.value.getNome()) < 0) { // meNoder q a root
        aux = aux.left;
      } else if (obj.getNome().compareTo(aux.value.getNome()) > 0) { // maior q a root
        aux = aux.right;
      } else {
        return aux;
      }
    }
    return null;
  }

  public Item pesquisar(Item obj) {
    Node aux = consultar(obj);

    if (aux == null) {
      return null; // na encontrado
    }
    return (new Item(aux.value.getNome(), aux.value.getFone()));
  }

  // <sring>.compareTo(<string>)
  // Retorna 0 se as strings forem iguais
  // Retorna valor <0 se for alfabeticamente menor
  // Retorna valor >0 se for alfabeticamente maior
  public void inserir(Item obj) {
    Node aux = new Node(obj);

    if (root == null) { // arvore vazia
      root = aux;
      return;
    }

    Node current = root;
    Node parent = null;

    while (current != null) {
      parent = current;

      if (obj.getNome().compareTo(current.value.getNome()) < 0) {
        current = current.left;
        if (current == null) {// ultimo
          parent.left = aux;
        }
      }
    }

  }

  public static void main(String[] args) {

  }
}

class Node {

  public Node pai = null;
  public Node left = null;
  public Node right = null;
  public Item value = null;

  Node(Item obj) {
    this.value = obj;
  }

  Node() {

  }

}
