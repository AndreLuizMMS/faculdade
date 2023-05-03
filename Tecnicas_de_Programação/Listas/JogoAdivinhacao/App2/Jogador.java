package App2;

import javax.swing.JOptionPane;

public class Jogador {

  public String nome;
  public int nTentativas = 0;
  public int maxTentativas;
  public int numeroGerado;
  public int[] palpites;

  public Jogador(String nome, int min, int max, int maxTentativas, int numeroGerado) {
    this.nome = nome;
    this.maxTentativas = maxTentativas;
    this.numeroGerado = numeroGerado;

    palpites = new int[maxTentativas];

    System.out.println(numeroGerado);
  }

  public boolean palpite() {

    nTentativas++;
    int tentativa = Integer
        .parseInt(JOptionPane.showInputDialog("Tentativa " + nTentativas + " de " + this.nome + ":"));
    addPalpite(tentativa);

    if (tentativa == numeroGerado) { // acerta o numero
      JOptionPane.showMessageDialog(null, "Correto, você acertou o número ");
      return true;

    } else if (tentativa < numeroGerado) {
      JOptionPane.showMessageDialog(null,
          "Palpites: " + printPalpites() + "\n" +
              "Tentativa n°" + nTentativas + " : " + tentativa +
              "\nNúmero muito baixo." +
              "\nTentativas restantes: " + (maxTentativas - nTentativas));
    } else {
      JOptionPane.showMessageDialog(null,
          "Palpites: " + printPalpites() + "\n" +
              "Tentativa n°" + nTentativas + " : " + tentativa +
              "\nNúmero muito alto." +
              "\nTentativas restantes: " + (maxTentativas - nTentativas));
    }
    return false;
  }

  public void addPalpite(int palpite) {
    palpites[this.nTentativas - 1] = palpite;
  }

  public String printPalpites() {
    String list = "[ ";
    for (int i = 0; i < palpites.length; i++) {
      if (this.palpites[i] != 0) {
        list += this.palpites[i] + ", ";
      } else {
        list += "x ";
      }
    }
    list += "]";
    return list;
  }

  public String getNome() {
    return nome;
  }

}
