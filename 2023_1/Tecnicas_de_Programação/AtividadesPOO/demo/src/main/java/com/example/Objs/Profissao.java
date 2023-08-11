package com.example.Objs;

import java.util.Scanner;

public class Profissao {
  String nome;

  public Profissao(String nome) {
    this.nome = nome;
  }

  public static Profissao lerProfissao() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o nome da profissão: ");
    String nome = sc.nextLine();

    Profissao temp = new Profissao(nome);
    return temp;
  }

  public String getNome() {
    return nome;
  }

}
