package projeto;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final Catalogo catalogo = new Catalogo();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.run();
    }

    public void run() {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarFilme();
                case 2 -> cadastrarAtor();
                case 3 -> cadastrarDiretor();
                case 4 -> associarFilmeAtoresDiretor();
                case 5 -> pesquisarFilme();
                case 6 -> continuar = false;
                default -> System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("Selecione uma opção:");
        System.out.println("1. Cadastrar Filme");
        System.out.println("2. Cadastrar Ator");
        System.out.println("3. Cadastrar Diretor");
        System.out.println("4. Associar Filme com Atores e Diretor");
        System.out.println("5. Pesquisar Filme");
        System.out.println("6. Sair");
    }

    private void cadastrarAtor() {
        System.out.println("Digite o nome do ator:");
        String nome = scanner.nextLine();

        System.out.println("Digite a idade do ator:");
        String idade = scanner.next();
        scanner.nextLine();

        Ator ator = new Ator(nome, idade);
        catalogo.cadastrarAtor(ator);

        System.out.println("Ator cadastrado com sucesso!");
    }

    private void cadastrarDiretor() {
        System.out.println("Digite o nome do diretor:");
        String nome = scanner.nextLine();

        System.out.println("Digite a idade do diretor:");
        String idade = scanner.next();
        scanner.nextLine();

        Diretor diretor = new Diretor(nome, idade);
        catalogo.cadastrarDiretor(diretor);

        System.out.println("Diretor cadastrado com sucesso!");
    }

    private void cadastrarFilme() {
        System.out.println("Digite o nome do filme:");
        String nome = scanner.nextLine();

        System.out.println("Digite a descrição do filme:");
        String descricao = scanner.nextLine();

        System.out.println("Digite a data de lançamento do filme:");
        String dataLancamento = scanner.nextLine();

        System.out.println("Digite o orçamento do filme:");
        String orcamento = scanner.nextLine();

        System.out.println("Digite o nome do diretor do filme:");
        String nomeDiretor = scanner.nextLine();
        Diretor diretor = catalogo.buscarDiretorPorNome(nomeDiretor);

        Filme filme = new Filme(nome, dataLancamento, orcamento, descricao, diretor);
        catalogo.cadastrarFilme(filme);

        System.out.println("Filme cadastrado com sucesso!");
    }