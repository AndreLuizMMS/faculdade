package POO.Fundamentos2;

import java.util.*;

public class Aluno {
    private String nome;
    private int idade;
    private int matricula;
    private String turma;

    public Aluno(String nome, int idade, int matricula, String turma) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public static String gerarNome() {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            int index = rand.nextInt(alfabeto.length());
            sb.append(alfabeto.charAt(index));
        }
        return sb.toString();
    }

    public static int gerarIdade() {
        
        Random rand = new Random();
        return rand.nextInt(29) + 7;
    }

    public static int gerarMatricula(ArrayList<Aluno> alunos) {
        Random rand = new Random();
        int matricula = rand.nextInt(8999) + 1000;
        boolean repetido = true;
        while (repetido) {
            repetido = false;
            for (Aluno aluno : alunos) {
                if (aluno.getMatricula() == matricula) {
                    repetido = true;
                    matricula = rand.nextInt(8999) + 1000;
                    break;
                }
            }
        }
        return matricula;
    }

    public static String gerarTurma(int idade) {
        if (idade >= 7 && idade <= 11) {
            return "Infância";
        } else if (idade >= 12 && idade <= 17) {
            return "Adolescência";
        } else {
            return "Adulto";
        }
    }

    public static String gerarSequencia(int sequencia) {
        String zeros = "";
        if (sequencia < 10) {
            zeros = "00";
        } else if (sequencia < 100) {
            zeros = "0";
        }
        return zeros + sequencia;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos alunos deseja cadastrar?");
        int quantidade = sc.nextInt();
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        for (int i = 0; i < quantidade; i++) {
            String nome = gerarNome() + " " + gerarNome();
            int idade = gerarIdade();
            int matricula = gerarMatricula(alunos);
            String turma = gerarTurma(idade);
            Aluno aluno = new Aluno(nome, idade, matricula, turma);
            alunos.add(aluno);
            String sequencia = gerarSequencia(i + 1);
            System.out.println(sequencia + " " + matricula + " " + nome + " " + idade + " " + turma);
        }

        sc.close();
    }
}