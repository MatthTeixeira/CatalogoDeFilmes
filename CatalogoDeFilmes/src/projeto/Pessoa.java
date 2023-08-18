package projeto;

public class Pessoa {
    private String nome;
    private String idade;

    public Pessoa(String nome, String idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa() {
    }

    public String getNome() {
        return this.nome;
    }

    public String getIdade() {
        return this.idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}