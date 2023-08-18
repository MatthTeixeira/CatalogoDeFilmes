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

    public void adicionarAtor(Ator ator) {
        atores.add(ator);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(String orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }
}
