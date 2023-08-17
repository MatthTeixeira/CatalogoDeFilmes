package projeto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Deseja adicionar um filme? \n1-Sim 2-Não");
            int escolhaFilme = sc.nextInt();
            if (escolhaFilme == 1) {
                adicionarFilme(sc, catalogo);
            } else {
                break;
            }
        }

        sc.close();
    }

    private static void adicionarFilme(Scanner sc, Catalogo catalogo) {
    }
}