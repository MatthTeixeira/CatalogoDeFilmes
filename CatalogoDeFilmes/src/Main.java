import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

class Ator extends Pessoa {
    public Ator(String nome, int idade) {
        super(nome, idade);
    }
}

class Diretor extends Pessoa {
    public Diretor(String nome, int idade) {
        super(nome, idade);
    }
}

class Filme {
    String nome;
    String dataLancamento;
    double orcamento;
    String descricao;
    Diretor diretor;
    List<Ator> atores = new ArrayList<>();

    public Filme(String nome, String dataLancamento, double orcamento, String descricao, Diretor diretor) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.diretor = diretor;
    }

    public void adicionarAtor(Ator ator) {
        atores.add(ator);
    }
}

class CatalogoFilmes {
    List<Filme> filmes = new ArrayList<>();
    Map<String, Filme> filmesPorNome = new HashMap<>();

    public void cadastrarFilme(Filme filme) {
        filmes.add(filme);
        filmesPorNome.put(filme.nome.toLowerCase(), filme);
    }

    public Filme buscarFilmePorNome(String nome) {
        return filmesPorNome.get(nome.toLowerCase());
    }
}

public class Main {
    public static void main(String[] args) {
        CatalogoFilmes catalogo = new CatalogoFilmes();

        Diretor diretor1 = new Diretor("Diretor 1", 50);
        Ator ator1 = new Ator("Ator 1", 30);
        Ator ator2 = new Ator("Ator 2", 25);

        Filme filme1 = new Filme("Filme 1", "01/01/2023", 1000000, "Descrição do Filme 1", diretor1);
        filme1.adicionarAtor(ator1);
        filme1.adicionarAtor(ator2);

        catalogo.cadastrarFilme(filme1);

        Filme filmeEncontrado = catalogo.buscarFilmePorNome("filme 1");

        if (filmeEncontrado != null) {
            System.out.println("Filme encontrado: " + filmeEncontrado.nome);
        } else {
            System.out.println("Filme não encontrado.");
        }
    }
}
