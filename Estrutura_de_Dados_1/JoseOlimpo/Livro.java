package JoseOlimpo;

public class Livro {
  public String name;
  public String author;
  public int price;

  public Livro(String name, int price, String author) {
    this.name = name;
    this.price = price;
    this.author = author;
  }

  static public void printList(Livro item) {
    System.out.println("Nome: " + item.name);
    System.out.println("autor: " + item.author);
    System.out.println("Preço: " + item.price);
  }
}
