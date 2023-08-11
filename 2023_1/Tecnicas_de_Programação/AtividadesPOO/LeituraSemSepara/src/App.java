public class App {
    
    public static void main(String[] args) throws Exception {
        Lertxt main = new Lertxt();
        main.seedFuncionario(); // lê o arquivo texto e popula o array de funcionários
        main.displayFuncionarios(main.funcionarios); // mostra os funcionários
    }
}
