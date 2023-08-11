package POO.Polimorfismo;

interface Carro {
  public void acelerar();
}

class Ferrari implements Carro {
  public void acelerar() {
    System.out.println("Ferrari acelerando");
  }
}

class Gol implements Carro {
  public void acelerar() {
    System.out.println("Gol acelerando");
  }
}

public class TestaCarro {

  public static void main(String[] args) {
    Carro gol = new Gol();
    gol.acelerar();

    Carro ferrari = new Ferrari();
    ferrari.acelerar();
  }
}