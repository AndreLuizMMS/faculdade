package FilaArranjos;

public class Fila {

  public int tamanho = 0;// tamanho da fila
  private int top; // index do topo
  private Cliente bottom; // elemento do bottom
  public Cliente fila[]; // fila em si

  // cria a Fila ----------------------- setMaxTam
  public void setMaxTam(int tamanho) {
    this.tamanho = tamanho + 1;
    top = 0;
    bottom = null;
    this.fila = new Cliente[this.tamanho];

  }

  // adiciona elementos a Fila -----------------------
  public boolean push(Cliente value) {
    if (top == tamanho) {// fila cheia
      System.out.println("fila cheia ");
      return false;
    }

    if (top == 0) { // lista vazia
      System.out.println("primeiro da fila");
      this.top = 1;
      fila[top] = value;
      this.bottom = fila[1];
      return true;
    }

    // elemento adicionado
    top++;
    fila[top] = value;
    System.out.println("adicionado");
    return true;
  }

  public void pop() {
    if (top == 1) { // so tem um elemento
      this.bottom = null;
      this.top = 0;
      return;
    }

    if (top == 0) {
      System.out.println("fila vazia");
      return;
    }

    Cliente fora = fila[top]; // quem vai sair

    fila[top] = null;
    this.top--;
    System.out.print("Saiu ");
    fora.getCliente();
    return;
  }

  public boolean filaVazia() {
    if (top < 1) {
      System.out.println("Fila vazia");
      return true;
    } else {
      return false;
    }
  }

  public boolean filaCheia() {
    if (top >= tamanho) {
      System.out.println("Fila cheia");
      return true;
    } else {
      return false;
    }
  }

  public int getMaxTam() {
    System.out.println(tamanho);
    return tamanho;
  }

  public void printFila() {

    for (int i = 1; i < this.tamanho; i++) {
      Cliente atual = fila[i];
      String print = atual.getCliente();
      System.out.print(print);
      System.out.println();
    }
  }
}
