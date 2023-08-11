  package Arvores.ABP_;

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

  class Item {
    public String nome, fone;

    public Item(String nome, String fone) {
      this.nome = nome;
      this.fone = fone;
    }

    public String getFone() {
      return fone;
    }

    public String getNome() {
      return nome;
    }

    @Override
    public String toString() {
      return ("nome: " + nome + ", fone: " + fone);
    }
  }

  public class ABP {
    public int tamanho;
    public Node root;

    // inicializa arvore
    public void Abp() {
      this.root = null;
      this.tamanho = 0;
    }

    public int getTamanho() {
      return tamanho;
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
    public boolean inserir(Item obj) {
      Node aux = new Node(obj); // quem vai entrar na arvore

      if (root == null) { // vazia, estao data sera root, o primeiro
        root = aux;
        return true;
      }

      Node current = root;
      Node parent = null;

      while (current != null) {
        if (obj.getNome().compareTo(current.value.getNome()) < 0) {
          parent = current;
          current = current.left;
        } else if (obj.getNome().compareTo(current.value.getNome()) > 0) {
          parent = current;
          current = current.right;
        } else {
          return false; // erro => obj ja esta na arvore
        }
      }
      aux.pai = parent;
      if (obj.getNome().compareTo(parent.value.getNome()) < 0) {
        parent.left = aux;
      } else {
        parent.right = aux;
      }
      return true;
    }

    private Node maximo(Node obj) {
      if (obj == null) {
        return null;
      }

      Node current = obj; // percorre pra encontrar o máximo

      while (current.right != null) {
        current = current.right;
      }
      return current; // maior valor na árvore
    }

    private Node minimo(Node obj) {
      if (obj == null) {
        return null;
      }

      Node current = obj; // percorre pra encontrar o máximo

      while (current.left != null) {
        current = current.left;
      }
      return current; // maior valor na árvore
    }

    private Node antecessor(Node obj) {
      if (obj == null) {
        return null;
      }
      if (obj.left != null) {
        return (maximo(obj.left));
      }
      Node current = obj.pai;
      Node prev = obj;

      while (current != null && prev == current.left) {
        prev = current;
        current = current.pai;
      }
      return current;
    }

    private Node sucessor(Node obj) {
      if (obj == null) {
        return null;
      }
      if (obj.right != null) {
        return (minimo(obj.right));
      }
      Node current = obj.pai;
      Node prev = obj;

      while (current != null && prev == current.right) {
        prev = current;
        current = current.pai;
      }

      return current;
    }

    public Item remover(Item obj) {
      Item itemRemovido = null;
      Node nodePraSair = consultar(obj);

      if (nodePraSair != null) {
        itemRemovido = nodePraSair.value;
        Node nodeFilho = null;
        Node nodePai = null;

        // Verificar se o nó a ser removido tem pelo menos um filho
        if (nodePraSair.right == null || nodePraSair.left == null) {
          nodeFilho = nodePraSair;
        } else {
          nodeFilho = sucessor(nodePraSair);
        }

        // Determinar o filho do nó a ser removido
        if (nodeFilho.left != null) {
          nodePai = nodeFilho.left;
        } else {
          nodePai = nodeFilho.right;
        }

        // Atualizar a referência do pai do filho
        if (nodePai != null) {
          nodePai.pai = nodeFilho.pai;
        }

        // Verificar se o nó a ser removido é a raiz da árvore
        if (nodeFilho.pai == null) {
          root = nodePai;
          if (nodePai != null) {
            nodePai.pai = null;
          }
        } else {
          if (nodeFilho == nodeFilho.pai.left) {
            nodeFilho.pai.left = nodePai;
          } else {
            nodeFilho.pai.right = nodePai;
          }
        }

        // Substituir o valor do nó removido pelo valor do sucessor
        if (nodeFilho != nodePraSair) {
          nodePraSair.value = nodeFilho.value;
        }
        tamanho--;
      }
      return itemRemovido;
    }
    

  }