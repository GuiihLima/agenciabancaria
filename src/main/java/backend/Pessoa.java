package backend;

import java.util.Date;

public class Pessoa {
    private String nome;
    private String cpf;
    private Date nascimento;
    private String endereço;
    private String cidade;
    private String estado;

    public Pessoa(String nome, String cpf, Date nascimento, String endereço, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereço = endereço;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCPF() {
        return this.cpf;
    }

    public Date getNascimento() {
        return this.nascimento;
    }

    public String getEndereço() {
        return this.endereço;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getEstado() {
        return this.estado;
    }
}