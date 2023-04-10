package Listas.HerancaSimples;

public class Ingresso {
  private double valor;

  public Ingresso(double valor) {
    this.valor = valor;
  }

  public void imprimeValor() {
    System.out.println("Valor do ingresso: R$" + valor);
  }

  public double getValor() {
    return valor;
  }
}

class Vip extends Ingresso {
  private double valorAdicional;

  public Vip(double valor, double valorAdicional) {
    super(valor);
    this.valorAdicional = valorAdicional;
  }

  @Override
  public void imprimeValor() {
    System.out.println("Valor do ingresso VIP: R$" + (getValor() + valorAdicional));
  }
}

class Normal extends Ingresso {
  public Normal(double valor) {
    super(valor);
  }

  public void imprimeTipo() {
    System.out.println("Ingresso Normal");
  }
}

class Principal {
  public static void main(String[] args) {
    Ingresso ingresso = new Ingresso(50.0);
    ingresso.imprimeValor();

    Vip vip = new Vip(100.0, 50.0);
    vip.imprimeValor();

    Normal normal = new Normal(30.0);
    normal.imprimeTipo();
    normal.imprimeValor();
  }
}
