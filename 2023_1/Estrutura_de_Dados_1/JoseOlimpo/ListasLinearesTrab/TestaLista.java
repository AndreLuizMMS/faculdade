import java.util.*;

public class TestaLista {

  public void criaContato() {

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Lista list = new Lista();

    int task = 99;
    int initList = 0;

    String nome = "";

    do {
      if (initList == 0) {
        System.out.print("digite o tamanho da lista: ");
        int length = sc.nextInt();
        list.setMaxTam(length);
        initList = 1;
      }

      System.out.println("[0] - Encerrar");
      System.out.println("[1] - Adicionar contato");
      System.out.println("[2] - Deletar contato");
      System.out.println("[3] - Pesquisar contato");
      System.out.println("[4] - Imprimir lista");

      task = sc.nextInt();
      sc.nextLine();
      if (task == 0) {
        return;
      }

      if (task == 1) {
        System.out.print("Nome: ");
        nome = sc.nextLine();

        System.out.print("CPF: ");
        long cpf = sc.nextLong();
        sc.nextLine();

        System.out.print("Enedereço: ");
        String endereco = sc.nextLine();

        Contato current = new Contato(nome, endereco, cpf);
        list.insereFinal(current);
      }

      if (task == 2) {
        if (list.listaVazia()) {
          System.out.println("lista vazia");
        } else {
          list.getLista();
          System.out.println("Deletar contsato na posição: ");
          int d = sc.nextInt();
          list.retiraContato(d);
        }
      }

      if (task == 3) {
        if (list.listaVazia()) {
          // nao procura nada se a lista estiver vazia
        } else {
          System.out.println("Pesquisar na posição: ");
          int index = sc.nextInt();
          list.pesquisa(index);
        }

      }

      if (task == 4) {
        list.getLista();
        System.out.println();
      }

    } while (task != 0);

    System.out.println("------- FIM -------");

  }
}
