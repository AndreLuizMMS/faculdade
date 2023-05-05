// package Listas.LeituraSemSep;

import java.util.*;

import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Lertxt
 */
public class Lertxt {

  public ArrayList<Funcionario[]> funcionarios = new ArrayList<Funcionario[]>();

  public static void seedFuncionario() {
    String FileName = "data.md";

    try {

      FileReader file = new FileReader(FileName);
      BufferedReader buffer = new BufferedReader(file);

      String line;
      // buffer.readLine() retorna linha no txt

      while ((line = buffer.readLine()) != null) {
        System.out.println(line);

        // Funcionario data -----------------
        String matricula = line.substring(0, 5);
        String name = getNameFromReader(line);
        String birth = formatData(getBithFromReader(line, name));

        int cpfIndex = matricula.length() + name.length() + birth.length() - 2;
        String cpf = formatCPF(line.substring(cpfIndex, cpfIndex + 11));

        Funcionario tempFuncionario = new Funcionario(matricula, name, birth, cpf);
        tempFuncionario.print();

        // Dependente data -----------------
        String depData = line.substring(cpfIndex + 10, line.length());

        String depName = getDepNameFromReader(depData);
        String depType = depData.substring(depName.length(), depName.length() + 1);

        Dependente tempDep = new Dependente(depName, depType);
        tempFuncionario.addDep(tempDep);

        return;
      }

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  // GET DATA FROM READER -----------------------------------------
  public static String getBithFromReader(String line, String name) {
    // brith == 8 char MAX
    return line.substring(name.length() + 4, name.length() + 4 + 8);
  }

  public static String getNameFromReader(String line) {
    String nameFiled = line.substring(5, 35);
    String name = "";

    for (int i = 0; i < nameFiled.length(); i++) {
      char letter = nameFiled.charAt(i);
      if (isName(letter)) {
        name += letter;
      }
    }
    return name;
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

  public static int countDependents(String line) {
    // Extrai as informações da linha

    int index = 53; // Começa na posição do primeiro dependente
    int count = 0; // Contador de dependentes

    while (index < line.length()) {
      char tipoDependente = line.charAt(index + 25);
      index += 26; // Avança para a próxima posição de dependente

      if (tipoDependente != '5') { // Não contar outros
        count++;
      }
    }

    return count;
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

  public static void main(String[] args) {
    seedFuncionario();
  }

}