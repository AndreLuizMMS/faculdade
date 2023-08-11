import javax.swing.JOptionPane;

public class Jogo {

  public static void main(String[] args) {

    int min = 0, max = 0, maxTentativas = 0, maxJogadores = 0;

    // INTERVALO DE NÚMEROS
    int flag = 1;

    do {
      try {
        min = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor mínimo do intervalo:"));

        flag = 0;
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Insira somente números");
      }

    } while (flag != 0);

    flag = 1;
    do {
      try {
        max = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor máximo do intervalo:"));

        if (max - min < 50) {
          JOptionPane.showMessageDialog(null, "O intervalo mínimo entre os números deve ser 50");
        } else {
          flag = 0;
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Insira somente números");
      }
    } while (flag != 0);

    // TENTATIVAS
    flag = 1;
    do {
      try {
        maxTentativas = Integer
            .parseInt(JOptionPane.showInputDialog("Digite número máximo de tentativas de cada jogador:"));
        if (maxTentativas > 4 || maxTentativas < 1) {
          JOptionPane.showMessageDialog(null, "O número de palpites deve ser de 1 - 4");
        } else {
          flag = 0;
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Insira somente números");
      }
    } while (flag != 0);

    // NUMERO DE JOGADORES
    flag = 1;
    do {
      try {
        maxJogadores = Integer.parseInt(JOptionPane.showInputDialog("Digite o número jogadores:"));

        if (maxJogadores < 3) {
          JOptionPane.showMessageDialog(null, "O deve ter no mínimo 3 jogadores");
        } else {
          flag = 0;
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Insira somente números");
      }
    } while (flag != 0);

    Controle jogo = new Controle(min, max, maxTentativas, maxJogadores);
    jogo.iniciaJogo();
  }

}
