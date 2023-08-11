package Listas.HerancaSimples;

public class Transporte {
  private boolean ligado;
  private int velocidade;

  public void liga() {
    this.ligado = true;
  }

  public void desliga() {
    this.ligado = false;
    this.velocidade = 0;
  }

  public boolean isLigado() {
    return ligado;
  }

  public void setVelocidade(int velocidade) {
    if (velocidade >= 0) {
      this.velocidade = velocidade;
    }
  }

  public int getVelocidade() {
    return velocidade;
  }
}

class Carro extends Transporte {
  private int quilometragem;

  public void setQuilometragem(int quilometragem) {
    if (quilometragem >= 0 && quilometragem <= 99999) {
      this.quilometragem = quilometragem;
    }
  }

  public int getQuilometragem() {
    return quilometragem;
  }

  public void setVelocidade(int velocidade) {
    if (velocidade >= 0 && velocidade <= 200) {
      super.setVelocidade(velocidade);
    }
  }

  public static void main(String[] args) {
    Carro carro = new Carro();

    carro.setQuilometragem(50000);
    System.out.println("Quilometragem do carro: " + carro.getQuilometragem());

    carro.setVelocidade(100);
    System.out.println("Velocidade do carro: " + carro.getVelocidade());

    carro.liga();
    System.out.println("O carro está ligado? " + carro.isLigado());

    carro.setVelocidade(-50);
    System.out.println("Velocidade do carro: " + carro.getVelocidade());

    carro.setVelocidade(300);
    System.out.println("Velocidade do carro: " + carro.getVelocidade());

    carro.desliga();
    System.out.println("O carro está ligado? " + carro.isLigado());
  }
}