package backend;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import backend.exceptions.*;

public class Banco implements Serializable {
    private String nome;
    private String sede;
    private String senha;
    private Boolean authenticated = false;
    private Map<String, Agencia> agencias;

    public Banco(String nome, String sede) {
        this.senha = null;
        this.nome = nome;
        this.sede = sede;
        this.agencias = new HashMap<String, Agencia>();
    }

    public Banco(String nome, String sede, String password) {
        this.senha = password;
        this.nome = nome;
        this.sede = sede;
        this.agencias = new HashMap<String, Agencia>();
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

    // Métodos Set

    public void setSenhaAdmin(String senha) {
        if (this.senha != null)
            throw new AutenticaçaoInvalidaException("Já existe senha para autenticação");
        else
            this.senha = senha;
    }

    public void setAgencia(String nome, Agencia agencia) {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");

        agencias.put(nome, agencia);
    }

    // Métodos Get

    public String getNome() {
        return this.nome;
    }

    public String getSede() {
        return this.sede;
    }

    public Agencia getAgencia(String nome) {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");

        Agencia agencia = agencias.get(nome);
        if (agencia == null)
            throw new ArgumentoInvalidoException("Agencia inexistente ou nome incorreto");
        else
            return agencia;
    }

    public Vector<String> getAllAgencias() {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");

        Vector<String> allAgencias = new Vector<String>();
        this.agencias.forEach((key, value) -> allAgencias.add(key));

        return allAgencias;
    }
}
