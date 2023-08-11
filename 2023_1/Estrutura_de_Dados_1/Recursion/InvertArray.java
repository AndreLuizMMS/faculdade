public class InvertArray {

  final static int max = 100;

  public static void main(String[] args) {
    int vet[] = new int[max];
    for (int i = 0; i < max; i++) {
      vet[i] = i;
    }

    int vetInvert[] = new int[max];

    print(invertArray(vet, 0, vetInvert));
  }

  public static int[] invertArray(int[] vet, int index, int[] vetInvert) {
    // vet == vetor original
    // vetInvert == vetor invertido
    // index = index de vet
    
    if (index < max) { // não excede o max
      vetInvert[max - 1 - index] = vet[index];
      invertArray(vet, index + 1, vetInvert);
    }
    return vetInvert;
  }

  public static void print(int[] vet) {
    System.out.println("Vet: ");
    for (int i = 0; i < vet.length; i++) {
      System.out.print(vet[i] + " ");
    }
  }
}
