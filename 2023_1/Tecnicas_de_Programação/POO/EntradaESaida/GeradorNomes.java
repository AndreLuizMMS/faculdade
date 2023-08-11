package POO.EntradaESaida;

import javax.swing.JOptionPane;

public class GeradorNomes {

  public static void main(String[] args) {
    int qtdNomes = lerQuantidadeNomes();
    String[] nomes = gerarNomes(qtdNomes);
    exibirNomes(nomes);
  }

  private static int lerQuantidadeNomes() {
    int qtd = 0;
    while (qtd < 5 || qtd > 30) {
      String strQtd = JOptionPane.showInputDialog("Digite a quantidade de nomes (entre 5 e 30):");
      if (strQtd == null) { // usuário clicou em "Cancelar"
        System.exit(0); // encerra o programa
      }
      try {
        qtd = Integer.parseInt(strQtd);
        if (qtd < 5 || qtd > 30) {
          exibirMensagem("Quantidade inválida. Digite um número entre 5 e 30.");
        }
      } catch (NumberFormatException e) {
        exibirMensagem("Valor inválido. Digite um número inteiro.");
      }
    }
    return qtd;
  }

  private static String[] gerarNomes(int qtd) {
    String[] nomes = new String[qtd];
    for (int i = 0; i < qtd; i++) {
      String nome = gerarNome();
      String sobrenome = gerarSobrenome();
      nomes[i] = String.format("%03d %s %s", i + 1, nome, sobrenome);
    }
    return nomes;
  }

  private static String gerarNome() {
    String nome = "";
    for (int i = 0; i < 10; i++) {
      nome += (char) (Math.random() * 26 + 65);
    }
    return nome;
  }

  private static String gerarSobrenome() {
    String sobrenome = "";
    for (int i = 0; i < 15; i++) {
      sobrenome += (char) (Math.random() * 26 + 65);
    }
    return sobrenome;
  }

  private static void exibirNomes(String[] nomes) {
    String mensagem = "SEQ NOME SOBRENOME\n";
    for (String nome : nomes) {
      mensagem += nome + "\n";
    }
    exibirMensagem(mensagem);
  }

  private static void exibirMensagem(String mensagem) {
    JOptionPane.showMessageDialog(null, mensagem);
  }

}
