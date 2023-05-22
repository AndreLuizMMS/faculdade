9import java.util.*;
import javax.swing.JOptionPane;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Lertxt
 */
public class Lertxt {

  public ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

  public void seedFuncionario() {
    String FileName = "/home/deds/Coding/faculdade/Tecnicas_de_Programação/AtividadesPOO/LeituraSemSepara/src/data.md";

    try {
      FileReader file = new FileReader(FileName);
      BufferedReader buffer = new BufferedReader(file);

      String line;

      // buffer.readLine() retorna linha no txt
      while ((line = buffer.readLine()) != null) {

        // Funcionario data -----------------
        String matricula = line.substring(0, 5); // sempre 5
        String name = getFuncNameFromReader(line); // +1 , espaço no meio
        String birth = formatData(getFuncBithFromReader(line, name)); // +2, '//'

        // index do inicio do cpf, -2 '//'
        int cpfIndex = matricula.length() + name.length() + birth.length() - 1;
        String cpf = formatCPF(line.substring(cpfIndex, cpfIndex + 11));

        Funcionario tempFuncionario = new Funcionario(matricula, name, birth, cpf);
        funcionarios.add(tempFuncionario);

        // index do fim dos dados do funcionário
        int funcDataIndex = matricula.length() + name.length() + birth.length() - 2 + cpf.length() - 2;

        // Dependente data -----------------,
        String depData = line.substring(funcDataIndex, line.length());

        while (depData.length() > 1) {
          String depName = getDepNameFromReader(depData);
          String depBirth = formatData(depData.substring(depName.length() + 2, depName.length() + 10));

          String depType = depData.substring(depName.length(), depName.length() + 1);
          int depTypeInt = Integer.parseInt(depType);

          Dependente tempDep = new Dependente(depName, depTypeInt, depBirth);
          tempFuncionario.addDep(tempDep);

          int newDep = depName.length() + depType.length() + depBirth.length() - 1;
          depData = depData.substring(newDep, depData.length());
        }
      }
      buffer.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  // GET DATA FROM READER -----------------------------------------
  public static String getFuncBithFromReader(String line, String name) {
    // brith == 8 char MAX
    return line.substring(name.length() + 5, (name.length() + 5) + 8);
  }

  public static String getFuncNameFromReader(String line) {
    String nameFiled = line.substring(5, line.length());
    String name = "";

    for (int i = 0; i < nameFiled.length(); i++) {
      char letter = nameFiled.charAt(i);
      if (isName(letter)) {
        name += letter;
      } else {
        return name;
      }
    }
    return name.trim();
  }

  public static String getDepNameFromReader(String line) {
    String nameFiled = line.substring(0, line.length());
    String name = "";

    for (int i = 0; i < nameFiled.length(); i++) {
      char letter = nameFiled.charAt(i);
      if (isName(letter)) {
        name += letter;
      } else {
        return name;
      }
    }
    return name;
  }

  // READER VERIFIERS -----------------------------------------
  public static boolean isName(char letter) {
    if (Character.isWhitespace(letter) || Character.isLetter(letter)) {
      return true;
    }
    return false;
  }

  // FORMATTERS ---------------------------
  public static String formatData(String data) {
    String dia = data.substring(0, 2);
    String mes = data.substring(2, 4);
    String ano = data.substring(4);
    return dia + "/" + mes + "/" + ano;
  }

  public static String formatCPF(String cpf) {
    return cpf.substring(0, 3) + "." +
        cpf.substring(3, 6) + "." +
        cpf.substring(6, 9) + "-" +
        cpf.substring(9);
  }

  public void displayFuncionarios(ArrayList<Funcionario> funcionarios) {
    String msg = "Seq.   Nome do Funcionário   Data Nasc.   Cpf\n";
    msg += "===============================================================\n";

    for (Funcionario funcionario : funcionarios) {
      msg += funcionario.getMatricula() + "   " + funcionario.getName() + "   " +
          funcionario.getBirth() + "   " + funcionario.getCpf() + "\n";

      if (funcionario.dependentes.size() > 0) {
        msg += "\n      Dependentes: Nome           Tipo               Data Nasc.\n";
        for (Dependente dependente : funcionario.dependentes) {
          msg += "     " + dependente.getDepName() + "               " + dependente.getDepType() + "               " +
              dependente.getDepBirth() + "\n";
        }
      } else {
        msg += "       Dependentes: (NÃO POSSUI)";
      }

      msg += "\n.............................................................................................................................\n";

      // Verifica se o número de linhas atingiu 15
      String[] lines = msg.split("\r\n|\r|\n");
      if (lines.length >= 15) {
        JOptionPane.showMessageDialog(null, msg);
        msg = ""; // Limpa a mensagem
      }
    }

    // Exibe a mensagem final, se houver alguma linha restante
    if (!msg.isEmpty()) {
      JOptionPane.showMessageDialog(null, msg);
    }
  }

}
