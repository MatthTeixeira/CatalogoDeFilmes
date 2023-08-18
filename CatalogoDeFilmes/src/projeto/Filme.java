package projeto;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    private String nome;
    private String dataLancamento;
    private String orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Ator> atores;

    public Filme(String nome, String dataLancamento, String orcamento, String descricao, Diretor diretor) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.diretor = diretor;
        this.atores = new ArrayList<>();
    }

    public Filme() {

        atores = new ArrayList<Ator>();

    }
}