package com.example;

import java.util.Scanner;

import com.example.ConexBanco.PessoaConex;
import com.example.ConexBanco.ProfissaoConex;
import com.example.Objs.Pessoa;
import com.example.Objs.Profissao;

public class App {
  public static void main(String[] args) {
    start();
  }

  public static void start() {

    Scanner scanner = new Scanner(System.in);
    int opcao;

    do {
      System.out.println("Escolha uma opção:");
      System.out.println("1 - Incluir Profissão");
      System.out.println("2 - Alterar Profissão");
      System.out.println("3 - Excluir Profissão");
      System.out.println("4 - Listar profissões");
      System.out.println("5 - Incluir Pessoa");
      System.out.println("6 - Alterar Pessoa");
      System.out.println("7 - Excluir Pessoa");
      System.out.println("8 - Listar Pessoas/Telefones");
      System.out.println("9 - Fim");

      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          Profissao profissaoTemp = Profissao.lerProfissao();
          ProfissaoConex.incluirProfissao(profissaoTemp);
          break;
        case 2:
          System.out.println("Digite o id da Profissao que deseja alterar: ");
          int idnovaProf = scanner.nextInt();
          System.out.println("Digite o nome da nova Profissao : ");
          String novaProf = scanner.next();
          ProfissaoConex.alterarProfissao(idnovaProf, novaProf);
          break;
        case 3:
          System.out.println("Digite o id ou nome da profissão que deseja excluir: ");
          String idNome = scanner.next();
          if (idNome.matches("[0-9]+")) {
            ProfissaoConex.excluirProfissao(idNome);
          } else {
            ProfissaoConex.excluirProfissao(idNome);
          }
          break;
        case 4:
          ProfissaoConex.listarProfissoes();
          break;
        case 5:
          Pessoa Pessoatemp = Pessoa.LerPessoa();
          PessoaConex.incluirPessoa(Pessoatemp);
          break;
        case 6:
          System.out.println("Digite o id da Pessoa que deseja alterar: ");
          int idNovoNome = scanner.nextInt();
          System.out.println("Digite o nome da Pessoa que deseja alterar: ");
          String novoNome = scanner.next();

          PessoaConex.alterarPessoa(idNovoNome, novoNome);
          break;
        case 7:
          System.out.println("Digite o id ou nome da Pessoa que deseja excluir: ");
          String idPessoa = scanner.next();
          if (idPessoa.matches("[0-9]+")) {
            PessoaConex.excluirPessoa(idPessoa);
          } else {
            PessoaConex.excluirPessoa(idPessoa);
          }
          break;
        case 8:
          PessoaConex.listarPessoas();
          break;
        case 9:
          System.out.println("Encerrando o programa...");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }

      System.out.println();
    } while (opcao != 9);

    scanner.close();
  }
}
