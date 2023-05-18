package Arvores.ABP;

public class ABP {

  public int tamanho;
  public No raiz;

  // inicializaz arvore
  public void Abp() {
    this.raiz = null;
    this.tamanho = 0;
  }

  public boolean vazia() {
    if (this.raiz == null) {
      return true;
    }
    return false;
  }

  public No consultar(Item obj) {
    No aux = this.raiz;

    while (aux != null) {
      if (obj.getNome().compareTo(aux.value.getNome()) < 0) { // menor q a raiz
        aux = aux.left;
      } else if (obj.getNome().compareTo(aux.value.getNome()) > 0) { // maior q a raiz
        aux = aux.right;
      } else {
        return aux;
      }
    }
    return null;
  }

  public Item pesquisar(Item obj) {
    No aux = consultar(obj);

    if (aux == null) {
      return null; // na encontrado
    }
    return (new Item(aux.value.getNome(), aux.value.getFone()));
  }

  public static void main(String[] args) {

  }
}

class No {

  public No pai = null;
  public No left = null;
  public No right = null;
  public Item value = null;

}
