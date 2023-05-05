// package Listas.LeituraSemSep;

import java.util.*;

public class Funcionario {

  public String matricula;
  public String name;
  public String birth;
  public String cpf;
  public ArrayList<Dependente> dependentes = new ArrayList<Dependente>();

  Funcionario(String matricula, String name, String birth, String cpf) {
    this.matricula = matricula;
    this.name = name;
    this.birth = birth;
    this.cpf = cpf;

  }

  public void print() {
    System.out.println(matricula);
    System.out.println(name);
    System.out.println(birth);
    System.out.println(cpf);

    for (Dependente data : dependentes) {
      data.print();
    }
  }

  public void addDep(Dependente dep) {
    dependentes.add(dep);
  }

}
