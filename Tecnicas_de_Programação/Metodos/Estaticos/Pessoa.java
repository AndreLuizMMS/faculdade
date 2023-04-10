package Metodos.Estaticos;

import java.util.Scanner;

public class Pessoa {
  private int matricula;
  private String nome;
  private String cpf;
  private double salario;

  public Pessoa(int matricula, String nome, String cpf, double salario) {
    this.matricula = matricula;
    this.nome = nome;
    this.cpf = cpf;
    this.salario = salario;
  }

  public int getMatricula() {
    return matricula;
  }

  public String getNome() {
    return nome;
  }

  public String getCpf() {
    return cpf;
  }

  public double getSalario() {
    return salario;
  }

  public static int lerMatricula() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite a matrícula: ");
    return scanner.nextInt();
  }

  public static String lerNome() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o nome: ");
    return scanner.nextLine();
  }

  public static String lerCpf() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o CPF: ");
    return scanner.nextLine();
  }

  public static double lerSalario() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o salário: ");
    return scanner.nextDouble();
  }

  public void escreverDados() {
    System.out.println("Matrícula: " + matricula);
    System.out.println("Nome: " + nome);
    System.out.println("CPF: " + cpf);
    System.out.println("Salário: " + salario);
  }

  public static void main(String[] args) {
    Pessoa pessoa1 = new Pessoa(lerMatricula(), lerNome(), lerCpf(), lerSalario());
    Pessoa pessoa2 = new Pessoa(lerMatricula(), lerNome(), lerCpf(), lerSalario());
    Pessoa pessoa3 = new Pessoa(lerMatricula(), lerNome(), lerCpf(), lerSalario());

    pessoa1.escreverDados();
    pessoa2.escreverDados();
    pessoa3.escreverDados();
  }
}
