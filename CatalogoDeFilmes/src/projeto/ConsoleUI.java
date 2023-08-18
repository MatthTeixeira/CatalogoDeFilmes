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

    private void associarFilmeAtoresDiretor() {
        System.out.println("Digite o nome do filme ao qual deseja associar atores e diretor:");
        String nomeFilme = scanner.nextLine();

        Filme filme = catalogo.buscarFilmePorNome(nomeFilme);
        if (filme == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        System.out.println("Digite o nome do diretor do filme:");
        String nomeDiretor = scanner.nextLine();
        Diretor diretor = catalogo.buscarDiretorPorNome(nomeDiretor);
        if (diretor == null) {
            System.out.println("Diretor não encontrado.");
            return;
        }

        filme.setDiretor(diretor);

        System.out.println("Digite o número de atores que deseja associar ao filme:");
        int numAtores = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numAtores; i++) {
            System.out.println("Digite o nome do ator:");
            String nomeAtor = scanner.nextLine();
            Ator ator = catalogo.buscarAtorPorNome(nomeAtor);
            if (ator == null) {
                System.out.println("Ator não encontrado.");
                return;
            }
            filme.adicionarAtor(ator);
        }

        System.out.println("Filme associado com sucesso!");
    }

    private void pesquisarFilme() {
        System.out.println("Digite o nome do filme que deseja pesquisar:");
        String nomeFilme = scanner.nextLine().toLowerCase();

        Filme filme = catalogo.buscarFilmePorNome(nomeFilme);
        if (filme == null) {
            System.out.println("Filme não encontrado.");
        } else {
            System.out.println("\nInformações do Filme:\n");

            System.out.println("Nome: " + filme.getNome());
            System.out.println("Descrição: " + filme.getDescricao());
            System.out.println("Data de Lançamento: " + filme.getDataLancamento());

            Diretor diretor = filme.getDiretor();
            if (diretor != null) {
                System.out.println("Diretor: " + diretor.getNome() + " (Idade: " + diretor.getIdade() + ")");
            } else {
                System.out.println("Diretor não associado a este filme.");
            }

            System.out.println("Orçamento: " + filme.getOrcamento());

            List<Ator> atores = filme.getAtores();
            if (!atores.isEmpty()) {
                System.out.println("Atores associados:");
                for (Ator ator : atores) {
                    System.out.println(" - " + ator.getNome() + " (Idade: " + ator.getIdade() + ")");
                }
            } else {
                System.out.println("Não há atores associados a este filme.");
            }

            System.out.println("\n");

            try {
                Thread.sleep(20000); //esperar 20 segundos e perguntar se deseja voltar ao menu ou encerrar o programa
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("\nDeseja voltar ao menu ou encerrar as buscas?\n");
            System.out.println("1 - Voltar ao menu");
            System.out.println("2 - Encerrar as buscas");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 2) {
                encerrarPrograma();
            }
        }
    }

    private void encerrarPrograma() {
        System.out.println("Encerrando as buscas, obrigado por utilizar.");
        System.exit(0);
    }
}