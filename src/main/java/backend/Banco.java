package backend;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import backend.exceptions.*;

public class Banco {
    private String nome;
    private String sede;
    private String pwd;
    private Boolean authenticated = false;
    private Map<String, Agencia> agencias;
    private Map<Integer, Funcionario> funcionarios;

    public Banco(String nome, String sede) {
        this.pwd = null;
        this.nome = nome;
        this.sede = sede;
        this.agencias = new HashMap<String, Agencia>();
        this.funcionarios = new HashMap<Integer, Funcionario>();
    }

    public Banco(String nome, String sede, String password) {
        this.pwd = password;
        this.nome = nome;
        this.sede = sede;
        this.agencias = new HashMap<String, Agencia>();
        this.funcionarios = new HashMap<Integer, Funcionario>();
    }

    // Autenticação

    public void authenticate(String senha) { // Autentica o usuário
        if (senha.equals(this.pwd))
            this.authenticated = true;
        else
            throw new ArgumentoInvalidoException("Senha incorreta");
    }

    public void deauthenticate() { // Desautentica o usuário
        this.authenticated = false;
    }

    // Métodos Set

    public void setSenhaAdmin(String senha) {
        if (this.pwd != null)
            throw new AutenticaçaoInvalidaException("Já existe senha para autenticação");
        else
            pwd = senha;
    }

    public void setAgencia(String nome, Agencia agencia) {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");

        agencias.put(nome, agencia);
    }

    public void setFuncionario(Integer numFuncional, Funcionario funcionario) {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");

        funcionarios.put(numFuncional, funcionario);
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

    public Funcionario getFuncionario(Integer numFuncional) {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");

        Funcionario funcionario = funcionarios.get(numFuncional);
        if (funcionario == null)
            throw new ArgumentoInvalidoException("Funcionario inexistente ou número funcional incorreto");
        else
            return funcionario;
    }

    public Vector<Integer> getAllFuncionarios() {
        if (!this.authenticated)
            throw new AutenticaçaoInvalidaException("Acesso negado; Usuário não autenticado");

        Vector<Integer> allFuncionarios = new Vector<Integer>();
        this.funcionarios.forEach((key, value) -> allFuncionarios.add(key));

        return allFuncionarios;
    }
}
