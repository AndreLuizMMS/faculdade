import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LerTxt {

  public static ArrayList<String[]> funcionarios = new ArrayList<String[]>();

  public void seedFuncionarios() {
    String nomeArquivo = "data.MD";

    try {
      FileReader arquivo = new FileReader(nomeArquivo);
      BufferedReader buffer = new BufferedReader(arquivo);

      String linha;

      while ((linha = buffer.readLine()) != null) {
        String[] partes = linha.split("-");

        for (int i = 0; i < partes.length; i++) {
          if (partes[i].length() < 2) {
            partes[i] = null;
          }
        }
        funcionarios.add(partes);
      }

      buffer.close();
      arquivo.close();

    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo " + nomeArquivo + ": " + e.getMessage());
    }
  }

  public ArrayList<String[]> getFuncionarios() {
    seedFuncionarios();
    return funcionarios;
  }

  public void lerFuncionarios(ArrayList<String[]> list) {
    for (String[] funcionario : list) {
      for (String info : funcionario) {
        System.out.println(info);
      }
    }
  }

}
