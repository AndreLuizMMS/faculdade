package com.example.Objs;

import java.util.Scanner;

public class Pessoa {
  String nome;
  int profissao;

  public Pessoa(String nome, int profissao) {
    this.nome = nome;
    this.profissao = profissao;
  }

  public static Pessoa LerPessoa() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o nome da pessoa: ");
    String nome = sc.nextLine();
    System.out.println("Digite o id da profissão: ");
    int profissao = sc.nextInt();
    sc.nextLine();

    Pessoa temp = new Pessoa(nome, profissao);
    return temp;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getProfissao() {
    return profissao;
  }

  public void setProfissao(int profissao) {
    this.profissao = profissao;
  }
}
