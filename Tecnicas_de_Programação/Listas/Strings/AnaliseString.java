// package Listas.Strings;

import java.util.Scanner;

public class AnaliseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String str = scanner.nextLine();

        // Número de caracteres da string
        int numCaracteres = str.length();
        System.out.println("Número de caracteres: " + numCaracteres);

        // String com todas as letras em maiúsculo
        String strMaiuscula = str.toUpperCase();
        System.out.println("String em maiúsculo: " + strMaiuscula);

        // Número de vogais da string
        int numVogais = 0;
        for (int i = 0; i < numCaracteres; i++) {
            char c = Character.toLowerCase(str.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                numVogais++;
            }
        }
        System.out.println("Número de vogais: " + numVogais);

        // Verifica se a string começa com "UNI"
        boolean comecaComUni = str.toLowerCase().startsWith("uni");
        System.out.println("Começa com UNI: " + comecaComUni);

        // Verifica se a string termina com "RIO"
        boolean terminaComRio = str.toLowerCase().endsWith("rio");
        System.out.println("Termina com RIO: " + terminaComRio);

        // Número de dígitos na string
        int numDigitos = 0;
        for (int i = 0; i < numCaracteres; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                numDigitos++;
            }
        }
        System.out.println("Número de dígitos: " + numDigitos);

        scanner.close();
    }
}
