
public class MinhaFila {

  final int SUCESSO = 0;
  final int FILA_CHEIA = 1;
  final int FILA_VAZIA = 2;

  private final int m = 10;
  // n de elementos

  private int primeiro;
  private int topo;

  private int[] fila = new int[m];

  // create
  public void create() {
    primeiro = 0;
    topo = -1;
  }

  public int push(int val) {
    if (topo == m - 1) { // fila cheia
      return (FILA_CHEIA);
    }
    topo++;
    fila[topo] = val;
    return (SUCESSO);

  }

  public int pop(){
    if(primeiro == -1){ // fila vazia
      return (FILA_VAZIA);
    }
    System.out.println(fila[primeiro] + " popped");

  }

  public static void main(String[] args) {

  }
}