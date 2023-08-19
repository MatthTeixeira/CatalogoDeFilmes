package projeto;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Filme> filmes;
    private List<Ator> atores;
    private List<Diretor> diretores;

    public Catalogo() {
        this.filmes = new ArrayList<>();
        this.atores = new ArrayList<>();
        this.diretores = new ArrayList<>();
    }

    public void cadastrarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void cadastrarAtor(Ator ator) {
        atores.add(ator);
    }

    public void cadastrarDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public Diretor buscarDiretorPorNome(String nomeDiretor) {
        for (Diretor diretor : diretores) {
            if (diretor.getNome().equalsIgnoreCase(nomeDiretor)) {
                return diretor;
            }
        }
        return null;
    }

    public String mostrarCatalogo() {
        for (Filme filme : filmes) {
            System.out.println(filme.getNome());
        }
        return "";
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public Ator buscarAtorPorNome(String nomeAtor) {
        for (Ator ator : atores) {
            if (ator.getNome().equalsIgnoreCase(nomeAtor)) {
                return ator;
            }
        }
        return null;
    }

    public Filme buscarFilmePorNome(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        return null;
    }

    public String mostrarFilme(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                System.out.println(filme.getNome());
                System.out.println(filme.getDescricao());
                System.out.println(filme.getDataLancamento());
                System.out.println(filme.getDiretor().getNome()); // Mostrar o nome do diretor
                System.out.println(filme.getOrcamento());
            }
        }
        return "";
    }
}
