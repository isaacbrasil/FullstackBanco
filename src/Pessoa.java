package Banco.bancofullstack.src;

public class Pessoa {
    private int id;
    private String nome;
    private String Endereco;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.Endereco;
    }

    public Pessoa(int id, String nome, String Endereco) {
        this.id = id;
        this.nome = nome;
        this.Endereco = Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }
}