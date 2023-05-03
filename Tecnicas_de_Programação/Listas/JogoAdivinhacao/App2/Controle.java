package App2;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Controle {

  public int numeroGerado;

  public int min;
  public int max;
  public int maxTentativas;
  public int numTentativas;
  public int maxJogadores;

  public ArrayList<Jogador> jogadores;

  public Controle(int min, int max, int maxTentativas, int maxJogadores) {
    this.maxTentativas = maxTentativas;
    this.max = max;
    this.min = min;
    this.maxJogadores = maxJogadores;
    numeroGerado = (int) (Math.random() * (max - min + 1)) + min;

    jogadores = new ArrayList<Jogador>();

    for (int i = 0; i < maxJogadores; i++) {
      String nome = JOptionPane.showInputDialog("Digite o nome do jogador " + (i + 1));
      jogadores.add(new Jogador(nome, min, max, maxTentativas, numeroGerado));
    }
  }

  public void iniciaJogo() {

    // Verificando jogadores que acertaram
    String ganhadores = "";
    int maxTentativas = jogadores.get(0).maxTentativas;

    for (int j = 0; j < maxTentativas; j++) {
      // garante que todos os jogadores joguem

      for (int i = 0; i < jogadores.size(); i++) {
        // loop pela lista de jogadores

        if (jogadores.get(i).palpite()) {
          // o jogador tanta acertar e o metodo retorna true ou false para o palpite
          ganhadores += jogadores.get(i).getNome() + ", ";
        }
      }
    }

    // Ganhadores
    JOptionPane.showMessageDialog(null, "Ganhadores: " + ganhadores);

  }

}
