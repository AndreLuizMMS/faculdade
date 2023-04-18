
public class Main {

  public static void main(String[] args) {
    Lista list = new Lista();
    Contato cont = new Contato();
    Contato cont2 = new Contato();
    list.setMaxTam(4);
    list.insereFinal(cont);
    list.insereFinal(cont2);
    list.insereFinal(cont);
    // list.retiraContato(cont2);
  }
}
