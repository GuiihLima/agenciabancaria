package backend;

import java.io.Serializable;
import java.util.Date;

import backend.exceptions.ArgumentoInvalidoException;
import backend.exceptions.AutenticaçaoInvalidaException;

public class Cliente implements Serializable {
    private String nome;
    private String cpf;
    private Date nascimento;
    private String endereço;
    private String cidade;
    private String estado;
    private Funcionario gerente;
    private String senha;
    private Boolean authenticated = false;

    public Cliente(String nome, String cpf, Date nascimento, String endereço, String cidade, String estado,
            String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereço = endereço;
        this.cidade = cidade;
        this.estado = estado;
        this.senha = senha;
    }

    // Autenticação

    public void authenticate(String senha) { // Autentica o usuário
        if (senha.equals(this.senha))
            this.authenticated = true;
        else
            throw new ArgumentoInvalidoException("Senha incorreta");
    }

    public void deauthenticate() { // Desautentica o usuário
        this.authenticated = false;
    }

    // Métodos Get

    public String getNome() {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");
        return this.nome;
    }

    public String getCPF() {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");
        return this.cpf;
    }

    public Date getNascimento() {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");
        return this.nascimento;
    }

    public String getEndereço() {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");
        return this.endereço;
    }

    public String getCidade() {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");
        return this.cidade;
    }

    public String getEstado() {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");
        return this.estado;
    }

    public String getNomeGerente() {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");
        return this.gerente.getNome();
    }

    public Funcionario getGerente() {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");
        return this.gerente;
    }

    // Métodos Set

    public void setGerente(Funcionario gerente) {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");
        this.gerente = gerente;
    }
}