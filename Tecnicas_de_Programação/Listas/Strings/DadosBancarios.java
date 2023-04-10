package Listas.Strings;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    SimpleDateFormat sdf1 = new SimpleDateFormat("ddMMyyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
    Date dataVencimentoFormatada = null;
    Date dataPagamentoFormatada = null;
    try {
      dataVencimentoFormatada = sdf1.parse(dataVencimento);
      dataPagamentoFormatada = sdf1.parse(dataPagamento);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    System.out.println("Banco ............... " + banco + "\n"
        + "Moeda .............. " + moeda + "\n"
        + "Agência ............ " + agencia + "\n"
        + "Valor do boleto ..... " + valorBoletoFormatado + "\n"
        + "Dt. Vencimento ...... " + sdf2.format(dataVencimentoFormatada) + "\n"
        + "Dt. Pagamento ....... " + sdf2.format(dataPagamentoFormatada));
  }
}
