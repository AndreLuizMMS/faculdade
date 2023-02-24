public class Fila {

  // --------------------- Error handilng
  final int SUCESSO = 0;
  final int FILA_CHEIA = 1;
  final int FILA_VAZIA = 2;

  private final int m = 7;
  private int primeiro;
  private int ultimo;

  private int[] elem = new int[m];

  // ------------------------------------ criaFila
  public void criaFila() {
    primeiro = 0;
    ultimo = -1;
  }

  // ------------------------------------ insereFila
  public int push(int dado) {
    if (ultimo == m - 1) {
      return (FILA_CHEIA);
    } else {
      ultimo++;
      elem[ultimo] = dado;
      return (SUCESSO);
    }
  }

  // ------------------------------------ exlcuiLista
  public int pop() {
    if (ultimo == -1) {
      return (FILA_VAZIA);
    } else {
      System.out.println("Dado Excluído: " + elem[primeiro]);
      primeiro++;
      if (primeiro > ultimo) {
        primeiro = 0;
        ultimo = -1;
      }
      return (SUCESSO);
    }
  }

  // ------------------------------- consultaFila
  public int peek() {
    if (ultimo == -1) {
      return (0);
    } else {
      return (elem[primeiro]);
    }
  }

  // ------------------------------- exibeFila
  public void exibeFila() {
    System.out.print("Fila: ");
    if (ultimo != -1) {
      for (int i = primeiro; i <= ultimo; i++) {
        System.out.print(elem[i] + " ");
      }
      System.out.println();
    }
  }

  // ------------------------------------------ imprimeErro
  public void imprimeErro(int erro) {
    switch (erro) {
      case FILA_CHEIA:
        System.out.println("ERRO: Fila Cheia");
        break;
      case FILA_VAZIA:
        System.out.println("ERRO: Fila Vazia");
        break;
    }
  }

  public static void main(String[] args) {

    Fila fila = new Fila();
    fila.criaFila();


    fila.push(2);
    fila.push(1);

    fila.pop();

    fila.exibeFila();
  }
}
