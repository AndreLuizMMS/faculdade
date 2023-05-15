package LeituraTxt;

import java.io.*;

public class Main {

  public static void main(String[] args) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("LeituraTxt//data.txt"));
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }

  }

}
