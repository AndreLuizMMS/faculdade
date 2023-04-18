package Listas.HerancaMult;

import javax.swing.JOptionPane;

abstract class Funcionario {
  protected String nome;
  protected double salario;

  public Funcionario(String nome) {
    this.nome = nome;
  } 

  public abstract void calcularSalario();

  public void exibirDados() {
    JOptionPane.showMessageDialog(null, "Nome: " + nome + "\nSalário: R$ " + salario);
  }
}

class FuncionarioAdministrativo extends Funcionario {
  public FuncionarioAdministrativo(String nome) {
    super(nome);
  }

  public void calcularSalario() {
    salario = 1300.0;
  }
}

class Professor extends Funcionario {
  private int horasAula;

  public Professor(String nome, int horasAula) {
    super(nome);
    this.horasAula = horasAula;
  }

  public void calcularSalario() {
    salario = 1300.0 + (horasAula * 25.0);
  }
}

class Medico extends Funcionario {
  private int horasDiarias;

  public Medico(String nome, int horasDiarias) {
    super(nome);
    this.horasDiarias = horasDiarias;
  }

  public void calcularSalario() {
    salario = 2.5 * 1300.0 + (horasDiarias * 2.0 * 55.0);
  }
}

class FolhaPagamento {
  private Funcionario[] funcionarios;

  public FolhaPagamento(Funcionario[] funcionarios) {
    this.funcionarios = funcionarios;
  }

  public void processarFolhaPagamento() {
    for (Funcionario f : funcionarios) {
      f.calcularSalario();
      f.exibirDados();
    }
  }
}

public class Main {
  public static void main(String[] args) {
    Funcionario[] funcionarios = new Funcionario[3];
    funcionarios[0] = new FuncionarioAdministrativo("João");
    funcionarios[1] = new Professor("Maria", 20);
    funcionarios[2] = new Medico("Pedro", 4);

    FolhaPagamento folha = new FolhaPagamento(funcionarios);
    folha.processarFolhaPagamento();
  }
}
