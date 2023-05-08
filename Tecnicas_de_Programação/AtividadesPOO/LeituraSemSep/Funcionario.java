package AtividadesPOO.LeituraSemSep;

import java.util.*;

import javax.swing.JOptionPane;

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

  public String getBirth() {
    return birth;
  }

  public String getCpf() {
    return cpf;
  }

  public ArrayList<Dependente> getDependentes() {
    return dependentes;
  }

  public String getMatricula() {
    return matricula;
  }
  public String getName() {
    return name;
  }

  public void print() {

  }

  public void addDep(Dependente dep) {
    dependentes.add(dep);

  }

}
