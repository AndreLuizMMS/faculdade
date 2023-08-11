package POO.Polimorfismo;

public class Abstract {

  abstract class Produto {
    int codigo;
    String descricao;
    float preco;

    abstract void vender();
    // método abstrato 
    // deve ser instanciado na subclasse

    void concreteMethod() {
      // metodo pronto pra ser usado nas subclasses
    }
  }

  class Cd extends Produto {
    Cd() {
    }

    void vender() {
      this.codigo = 1;
      this.descricao = "cd internacional";
      this.preco = 30.00f;
    }
  }

  class Livro extends Produto {
    Livro() {
    }

    void vender() {
      this.codigo = 111;
      this.descricao = "Livro Nacional";
      this.preco = 55.00f;
    }
  }
}
