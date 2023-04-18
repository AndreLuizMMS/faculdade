
public class Lista {

  public int ultimo;
  public int maxTam;
  public Contato[] contato;

  public void setMaxTam(int tamanho) {
    if (tamanho > 1) {
      this.maxTam = tamanho;
    }
    contato = new Contato[tamanho];
  }

  public int getMaxtamanho() {
    return maxTam;
  }

  public boolean listaVazia() {
    if (contato[0] == null) {
      return true;
    }
    return false;
  }

  public boolean listaCheia() {
    if (contato[maxTam - 1] != null) {
      System.out.println("Lista cheia ");
      return true;
    }

    System.out.println("Lista ");
    return false;
  }

  public boolean insereFinal(Contato cont) {
    for (int i = 0; i < contato.length; i++) {
      if (contato[i] == null) {
        // acha a posição vazia e insere cont
        contato[i] = cont;
        return true;
      }
    }
    System.out.println(("Lista cheia"));
    return false;
  }

  public void retiraContato(int cont) {
    Contato deleted = new Contato();
    for (int i = 0; i < contato.length; i++) {// acha cont dentro da lista
      if (i == cont) {
        // apaga o contato passado no parametro
        deleted = contato[i];
        contato[i] = null;

        for (int j = i - 1; j < contato.length; j++) {
          // remaneja todos os elementos
          contato[i] = contato[j];
        }

      }
    }
    System.out.print("deletado: ");
    deleted.getContato();
    System.out.println();

  }

  public void pesquisa(int cont) {

    for (int i = 0; i < contato.length; i++) {
      if (i == cont && contato[i] != null) {
        System.out.print(i + " -> ");
        contato[i].getContato();
      } else {
        System.out.println("[ERROR] Não encontrado ");
        return;

      }

    }
  }

  public void getLista() {
    for (int i = 0; i < contato.length; i++) {
      if (contato[i] != null) {
        System.out.print(i + " -> ");
        contato[i].getContato();
        System.out.println();
      }
    }
  }

}
