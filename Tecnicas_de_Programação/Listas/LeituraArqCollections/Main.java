import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Main {

  public static void main(String[] args) {

    JOptionPane.showMessageDialog(null, formatAllFuncionarios());
  }

  public static String formatAllFuncionarios() {
    LerTxt test = new LerTxt();
    ArrayList<String[]> funcionarios = test.getFuncionarios();

    String listaFuncionarios = "Lista de funcionários\n\n"
        + "==============================================\n\n";

    for (int i = 0; i < funcionarios.size(); i++) {
      String newLine = "";

      for (int j = 0; j < funcionarios.get(i).length; j++) {
        String info = funcionarios.get(i)[j];

        // formatação de MOEDA ---------------
        if (j == 2) {
          int real = Integer.parseInt(info);
          info = formatReal(real);
        }
        if (j == 3) {
          int real = Integer.parseInt(info);
          info = formatReal(real);
        }

        if (j == 4 && info == null) {
          info = "<Sem filhos>";
        }

        // formatação de SEXO---------------
        if (j == 6 && info != null) {
          info = sexoString(info);
        }
        if (j == 9 && info != null) {
          info = sexoString(info);
        }

        // formatação de DATA---------------
        if (j == 5 && info != null) {
          int real = Integer.parseInt(info);
          info = formatData(real);
        }

        if (j == 8 && info != null) {
          int real = Integer.parseInt(info);
          info = formatData(real);
        }

        // garante integridade dos dados
        if (info != null) {
          newLine += " - " + info;
        }
      }
      listaFuncionarios += newLine + "\n\n";
    }
    return listaFuncionarios;
  }

  public static String formatReal(int val) {
    double valorEmReal = (double) val / 100;

    NumberFormat moedaFormato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    return moedaFormato.format(valorEmReal);
  }

  public static String formatData(int data) {
    String dataString = Integer.toString(data);
    String dia = dataString.substring(0, 2);
    String mes = dataString.substring(2, 4);
    String ano = dataString.substring(4);
    return dia + "/" + mes + "/" + ano;
  }

  public static String sexoString(String sexo) {
    if (sexo.equals(" M ")) {
      return "MASCULINO";
    } else if (sexo.equals(" F ")) {
      return "FEMININO";
    } else {
      return " ";
    }
  }

}

// index 0 = Matricula
// index 1 = Nome
// index 2 = salario
// index 3 = Gratificação
// index 4 = Nome do Filho
// index 5 = data de nascimento do filho
// index 6 = Sexo do filho
// index 7 = Nome de outro filho
// index 8 = Data de nascimento do outro filho
// index 9 = Sexo do filho do outro filho
