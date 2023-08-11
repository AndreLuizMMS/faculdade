package Listas.RevisaoMetodos;

import java.util.Scanner;

public class CadastroPessoas {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int idade, grauInstrucao = 0, codigoSexo, contMascMedio = 0, contFemFundamental = 0, contFemSuperior = 0;
    float somaIdades = 0;
    double percFemSuperior;

    System.out.println("Entre com as informações das pessoas: ");
    do {
      System.out.println("Idade (0 para sair): ");
      idade = leInteiro(sc);

      if (idade != 0) {
        System.out.println("Grau de instrução (1-Fundamental, 2-Médio, 3-Superior, 4-Pós): ");
        grauInstrucao = leInteiro(sc);
        System.out.println("Código do sexo (1-Fem, 2-Masc): ");
        codigoSexo = leInteiro(sc);

        if (codigoSexo == 2 && grauInstrucao == 2) {
          contMascMedio++;
        }

        if (codigoSexo == 1 && grauInstrucao == 1) {
          contFemFundamental++;
        }

        if (grauInstrucao == 4) {
          somaIdades += idade;
        }

        if (codigoSexo == 1 && grauInstrucao == 3) {
          contFemSuperior++;
        }
      }
    } while (idade != 0);

    if (contMascMedio > 0) {
      System.out.println("Quantidade de homens com grau médio: " + contMascMedio);
    } else {
      System.out.println("Não há homens com grau médio.");
    }

    if (contFemFundamental > 0) {
      System.out.println("Quantidade de mulheres com grau fundamental: " + contFemFundamental);
    } else {
      System.out.println("Não há mulheres com grau fundamental.");
    }

    if (contFemSuperior > 0) {
      percFemSuperior = (double) contFemSuperior / (contMascMedio + contFemSuperior) * 100;
      System.out.println("Porcentagem de mulheres com grau superior: " + percFemSuperior + "%");
    } else {
      System.out.println("Não há mulheres com grau superior.");
    }

    if (somaIdades > 0) {
      System.out.println("Média das idades com grau pós: " + somaIdades / contagem(grauInstrucao, 4));
    } else {
      System.out.println("Não há pessoas com grau pós.");
    }

    sc.close();
  }

  public static int leInteiro(Scanner sc) {
    while (!sc.hasNextInt()) {
      System.out.println("Valor inválido. Digite um valor inteiro: ");
      sc.next();
    }
    return sc.nextInt();
  }

  public static int contagem(int grauInstrucao, int valor) {
    int cont = 0;
    if (grauInstrucao == valor) {
      cont++;
    }
    return cont;
  }
}
