package Listas.HerancaSimples;

public class Equipamento {
  private boolean ligado;

  public Equipamento() {
    this.ligado = false;
  }

  public void liga() {
    this.ligado = true;
  }

  public void desliga() {
    this.ligado = false;
  }

  public boolean estaLigado() {
    return this.ligado;
  }
}

class EquipamentoSonoro extends Equipamento {
  private int volume;
  private boolean stereo;

  public EquipamentoSonoro() {
    super();
    this.volume = 5;
    this.stereo = true;
  }

  public int getVolume() {
    return this.volume;
  }

  public void setVolume(int novoVolume) {
    if (novoVolume >= 0 && novoVolume <= 10) {
      this.volume = novoVolume;
    }
  }

  public boolean getStereo() {
    return this.stereo;
  }

  public void setStereo(boolean novoModo) {
    this.stereo = novoModo;
  }

  public void somMono() {
    this.stereo = false;
  }

  public void somStereo() {
    this.stereo = true;
  }

  public void liga() {
    super.liga();
    this.volume = 5;
  }
}

class TesteEquipamentos {
  public static void main(String[] args) {
    Equipamento equipamento = new Equipamento();
    System.out.println("Equipamento está ligado? " + equipamento.estaLigado());

    equipamento.liga();
    System.out.println("Equipamento está ligado? " + equipamento.estaLigado());

    equipamento.desliga();
    System.out.println("Equipamento está ligado? " + equipamento.estaLigado());

    EquipamentoSonoro equipamentoSonoro = new EquipamentoSonoro();
    System.out.println("EquipamentoSonoro está ligado? " + equipamentoSonoro.estaLigado());
    System.out.println("Volume: " + equipamentoSonoro.getVolume());
    System.out.println("Stereo: " + equipamentoSonoro.getStereo());

    equipamentoSonoro.liga();
    System.out.println("EquipamentoSonoro está ligado? " + equipamentoSonoro.estaLigado());
    System.out.println("Volume: " + equipamentoSonoro.getVolume());
    System.out.println("Stereo: " + equipamentoSonoro.getStereo());

    equipamentoSonoro.setVolume(8);
    equipamentoSonoro.setStereo(false);
    System.out.println("Volume: " + equipamentoSonoro.getVolume());
    System.out.println("Stereo: " + equipamentoSonoro.getStereo());

    equipamentoSonoro.somMono();
    System.out.println("Stereo: " + equipamentoSonoro.getStereo());

    equipamentoSonoro.somStereo();
    System.out.println("Stereo: " + equipamentoSonoro.getStereo());

    equipamentoSonoro.desliga();
    System.out.println("EquipamentoSonoro está ligado? " + equipamentoSonoro.estaLigado());
  }
}
