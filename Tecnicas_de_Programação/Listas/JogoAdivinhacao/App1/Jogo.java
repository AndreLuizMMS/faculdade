import javax.swing.JOptionPane;

public class Jogo {

  public static void main(String[] args) {

    int min, max, maxTentativas, maxJogadores;

    // INTERVALO DE NÚMEROS
    int flag = 1;
    do {
      min = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor mínimo do intervalo:"));
      max = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor máximo do intervalo:"));

      if (max - min < 50) {
        JOptionPane.showMessageDialog(null, "O intervalo mínimo entre os números deve ser 50");
      } else {
        flag = 0;
      }

    } while (flag != 0);

    // TENTATIVAS
    flag = 1;
    do {
      maxTentativas = Integer
          .parseInt(JOptionPane.showInputDialog("Digite número máximo de tentativas de cada jogador:"));
      if (maxTentativas > 4 || maxTentativas < 1) {
        JOptionPane.showMessageDialog(null, "O número de palpites deve ser de 1 - 4");
      } else {
        flag = 0;
      }
    } while (flag != 0);

    // NUMERO DE JOGADORES
    flag = 1;
    do {
      maxJogadores = Integer.parseInt(JOptionPane.showInputDialog("Digite o número jogadores:"));

      if (maxJogadores < 3) {
        JOptionPane.showMessageDialog(null, "O deve ter no mínimo 3 jogadores");
      } else {
        flag = 0;
      }
    } while (flag != 0);

    Controle jogo = new Controle(min, max, maxTentativas, maxJogadores);
    jogo.iniciaJogo();
  }

}
