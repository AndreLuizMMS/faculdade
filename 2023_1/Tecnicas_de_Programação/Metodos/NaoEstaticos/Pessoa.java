package Metodos.NaoEstaticos;

import java.util.Scanner;

public class Pessoa {
  private int matricula;
  private String nome;
  private String cpf;
  private double salario;

  public Pessoa() {
    this.matricula = lerMatricula();
    this.nome = lerNome();
    this.cpf = lerCpf();
    this.salario = lerSalario();
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

  public int lerMatricula() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite a matrícula: ");
    scanner.close();
    return scanner.nextInt();
  }

  public String lerNome() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o nome: ");
    scanner.close();
    return scanner.nextLine();
  }

  public String lerCpf() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o CPF: ");
    scanner.close();
    return scanner.nextLine();
  }

  public double lerSalario() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o salário: ");
    scanner.close();
    return scanner.nextDouble();
  }

  public void escreverDados() {
    System.out.println("Matrícula: " + matricula);
    System.out.println("Nome: " + nome);
    System.out.println("CPF: " + cpf);
    System.out.println("Salário: " + salario);
  }

  public static void main(String[] args) {
    Pessoa pessoa1 = new Pessoa();
    Pessoa pessoa2 = new Pessoa();
    Pessoa pessoa3 = new Pessoa();

    pessoa1.escreverDados();
    pessoa2.escreverDados();
    pessoa3.escreverDados();
  }
}
