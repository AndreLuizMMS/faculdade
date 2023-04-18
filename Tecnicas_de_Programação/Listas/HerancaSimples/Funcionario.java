package Listas.HerancaSimples;

public class Funcionario {
  private String nome;
  private String cpf;
  private String rg;
  private double salario;

  public Funcionario(String nome, String cpf, String rg, double salario) {
    this.nome = nome;
    this.cpf = cpf;
    this.rg = rg;
    this.salario = salario;
  }

  public void receberAumento() {
    this.salario *= 1.10;
  }

  public void exibeDados() {
    System.out.println("Nome: " + nome);
    System.out.println("CPF: " + cpf);
    System.out.println("RG: " + rg);
    System.out.println("Salário: " + salario);
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }
}

class Gerente extends Funcionario {
  private String nivelGerencia;

  public Gerente(String nome, String cpf, String rg, double salario, String nivelGerencia) {
    super(nome, cpf, rg, salario);
    this.nivelGerencia = nivelGerencia;
  }

  public void receberAumento() {
    this.setSalario(this.getSalario() * 1.15);
  }

}

class Assistente extends Funcionario {
  private int matricula;

  public Assistente(String nome, String cpf, String rg, double salario, int matricula) {
    super(nome, cpf, rg, salario);
    this.matricula = matricula;
  }

  public void exibeDados() {
    super.exibeDados();
    System.out.println("Matrícula: " + matricula);
  }

  // getters e setters
}

class Tecnico extends Assistente {
  private double bonusSalarial;

  public Tecnico(String nome, String cpf, String rg, double salario, int matricula, double bonusSalarial) {
    super(nome, cpf, rg, salario, matricula);
    this.bonusSalarial = bonusSalarial;
  }

  public void exibeDados() {
    super.exibeDados();
    System.out.println("Bônus salarial: " + bonusSalarial);
  }

  // getters e setters
}

class Administrativo extends Assistente {
  private String turno;
  private double adicionalNoturno;

  public Administrativo(String nome, String cpf, String rg, double salario, int matricula, String turno,
      double adicionalNoturno) {
    super(nome, cpf, rg, salario, matricula);
    this.turno = turno;
    this.adicionalNoturno = adicionalNoturno;
  }

  public void exibeDados() {
    super.exibeDados();
    System.out.println("Turno: " + turno);
    System.out.println("Adicional noturno: " + adicionalNoturno);
  }

}
