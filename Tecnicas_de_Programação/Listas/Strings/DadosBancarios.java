package Listas.Strings;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class DadosBancarios {

  public static void main(String[] args) {
    String linhaDados = "10423547000003587253007202202082022";

    String banco = linhaDados.substring(0, 3);
    String moeda = linhaDados.substring(3, 4);
    String agencia = linhaDados.substring(4, 9);
    String valorBoleto = linhaDados.substring(9, 19) + "." + linhaDados.substring(19, 21);
    String dataVencimento = linhaDados.substring(21, 29);
    String dataPagamento = linhaDados.substring(29, 37);

    switch (moeda) {
      case "1":
        moeda = "Real";
        break;
      case "2":
        moeda = "Dólar";
        break;
      case "3":
        moeda = "Euro";
        break;
      case "4":
        moeda = "Peso";
        break;
      case "5":
        moeda = "Libra";
        break;
      default:
        moeda = "Moeda inválida";
        break;
    }

    DecimalFormat df = new DecimalFormat("#,##0.00");
    String valorBoletoFormatado = "R$ " + df.format(Double.parseDouble(valorBoleto));

    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println("Banco ............... " + banco + "\n"
        + "Moeda .............. " + moeda + "\n"
        + "Agência ............ " + agencia + "\n"
        + "Valor do boleto ..... " + valorBoletoFormatado + "\n"
        + "Dt. Vencimento ...... " + sdf2.format(dataVencimento) + "\n"
        + "Dt. Pagamento ....... " + sdf2.format(dataPagamento));
  }
}
