import javax.swing.JOptionPane;
import java.util.Random;

public class Jogador {

  public String nome;
  public int nTentativas = 0;
  public int maxTentativas;
  public int numeroGerado;

  public static String randomName() {
    String name = "";
    Random rand = new Random();

    for (int i = 0; i < 6; i++) {
      char letter = (char) (rand.nextInt(26) + 'A');
      name += letter;
    }
    return name;
  }

  public Jogador(int min, int max, int maxTentativas, int numeroGerado) {
    this.nome = randomName();
    this.maxTentativas = maxTentativas;
    this.numeroGerado = numeroGerado;
    System.out.println(numeroGerado);
  }

  // @formatter:off
    public boolean palpite() {
      if (nTentativas >= maxTentativas) {
        JOptionPane.showMessageDialog(null, "Máximo de tentativas !");
        return false;
      }
  
      nTentativas++;
      int tentativa = Integer.parseInt(JOptionPane.showInputDialog("Tentativa " + nTentativas + " de " + nome + ":"));
  
      if (tentativa == numeroGerado) { // acerta o numero 
        JOptionPane.showMessageDialog(null, "Correto, você acertou o número ");
        return true;
        
      } else {
        JOptionPane.showMessageDialog(null, "Errado, esse não é o número ");
      }
      return false;
    }
  // @formatter:on

  public String getNome() {
    return nome;
  }

}
