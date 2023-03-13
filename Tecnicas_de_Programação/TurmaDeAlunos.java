
// Lista os dados dos alunos
import java.util.Scanner;

public class TurmaDeAlunos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Pergunta ao usuário a quantidade de alunos
        System.out.print("Digite a quantidade de alunos: ");
        int quantidadeDeAlunos = scanner.nextInt();

        // Cria um vetor para armazenar os alunos
        Aluno[] alunos = new Aluno[quantidadeDeAlunos];

        // Preenche o vetor com as instâncias dos alunos
        for (int i = 0; i < quantidadeDeAlunos; i++) {
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            String nome = scanner.next();
            System.out.print("Digite a idade do aluno " + (i + 1) + ": ");
            int idade = scanner.nextInt();
            System.out.print("Digite a matrícula do aluno " + (i + 1) + ": ");
            int matricula = scanner.nextInt();
            alunos[i] = new Aluno(nome, idade, matricula);
        }

        // Define a turma de cada aluno
        for (int i = 0; i < quantidadeDeAlunos; i++) {
            Aluno aluno = alunos[i];
            if (aluno.getIdade() < 18) {
                aluno.setTurma("Turma A");
            } else if (aluno.getIdade() >= 18 && aluno.getIdade() < 25) {
                aluno.setTurma("Turma B");
            } else {
                aluno.setTurma("Turma C");
            }
        }

        // Lista os dados dos alunos
        System.out.println("Dados dos alunos:");
        for (int i = 0; i < quantidadeDeAlunos; i++) {
            Aluno aluno = alunos[i];
            System.out.println("Nome: " + aluno.getNome() +
                    ", Idade: " + aluno.getIdade() +
                    ", Matrícula: " + aluno.getMatricula() +
                    ", Turma: " + aluno.getTurma());
        }

        scanner.close();
    }

}
