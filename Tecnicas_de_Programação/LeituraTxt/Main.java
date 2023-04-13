package LeituraTxt;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("LeituraTxt//data.txt"));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split("-");
        System.out.println(line);
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo: " + e.getMessage());
    }

  }

}

class Funcionario {
  private String matricula;
  private String nome;
  private double salario;
  private double gratificacao;
  private List<Filho> filhos;

  public Funcionario(String matricula, String nome, double salario, double gratificacao) {
    this.matricula = matricula;
    this.nome = nome;
    this.salario = salario;
    this.gratificacao = gratificacao;
    this.filhos = new ArrayList<>();
  }

  public void adicionarFilho(Filho filho) {
    this.filhos.add(filho);
  }
}

class Filho {
  private String nome;
  private Date dataNascimento;
  private char sexo;

  public Filho(String nome, Date dataNascimento, char sexo) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.sexo = sexo;
  }

}
