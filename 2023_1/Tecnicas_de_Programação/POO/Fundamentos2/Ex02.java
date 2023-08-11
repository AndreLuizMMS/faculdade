package POO.Fundamentos2;

import java.util.Scanner;

public class Ex02 {
  private String nome;
  private int idade;
  private int matricula;
  private String turma;

  public Ex02(String nome, int idade, int matricula, String turma) {
    this.nome = nome;
    this.idade = idade;
    this.matricula = matricula;
    this.turma = turma;
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  public int getMatricula() {
    return matricula;
  }

  public String getTurma() {
    return turma;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Quantidade de alunos: ");
    int quantidadeAlunos = scanner.nextInt();

    Ex02[] alunos = new Ex02[quantidadeAlunos];

    for (int i = 0; i < quantidadeAlunos; i++) {
      System.out.println("Cadastro do aluno " + (i + 1) + ":");
      System.out.print("Nome: ");
      String nome = scanner.next();
      System.out.print("Idade: ");
      int idade = scanner.nextInt();

      String turma;
      if (idade < 12) {
        turma = "Infância";
      } else if (idade < 18) {
        turma = "Adolescência";
      } else {
        turma = "Adulto";
      }

      int matricula = (i + 1) * 1000 + idade; // gerar matrícula única baseada no índice do aluno

      alunos[i] = new Ex02(nome, idade, matricula, turma);
    }

    System.out.println("Alunos cadastrados:");
    for (int i = 0; i < quantidadeAlunos; i++) {
      System.out.println("Aluno " + (i + 1) + ": " + alunos[i].getNome() + ", " + alunos[i].getIdade() + " anos, turma "
          + alunos[i].getTurma() + ", matrícula " + alunos[i].getMatricula());
    }
    scanner.close();
  }
}
