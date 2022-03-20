package backend;

import java.util.HashMap;
import java.util.Map;

import backend.exceptions.*;
import backend.interfaces.Validador;

public class Banco implements Validador {
    private String nome;
    private String sede;
    private Administraçao admin;
    private Map<String, Agencia> agencias;
    private Map<Integer, Funcionario> funcionarios;

    public Banco(String nome, String sede) {
        this.nome = nome;
        this.sede = sede;
        this.admin = new Administraçao(this);
        this.agencias = new HashMap<String, Agencia>();
        this.funcionarios = new HashMap<Integer, Funcionario>();
    }

    public Banco(String nome, String sede, String senhaAdmin) {
        this.nome = nome;
        this.sede = sede;
        this.admin = new Administraçao(this, senhaAdmin);
        this.agencias = new HashMap<String, Agencia>();
        this.funcionarios = new HashMap<Integer, Funcionario>();
    }

    // Autenticação

    private void Auth(String senha) {
        if (isAdmin(admin, senha))
            return;
        else
            throw new ArgumentoInvalidoException("Senha incorreta");
    }

    // Manage

    public Agencia manageAgencia(String nome, String senha) {
        this.Auth(senha);
        Agencia agencia = agencias.get(nome);
        if (agencia == null)
            throw new ArgumentoInvalidoException("Agencia inexistente ou nome incorreto");
        else
            return agencia;
    }

    public Funcionario manageFuncionario(Integer numFuncional, String senha) {
        this.Auth(senha);
        Funcionario funcionario = funcionarios.get(numFuncional);
        if (funcionario == null)
            throw new ArgumentoInvalidoException("Funcionario inexistente ou número funcional incorreto");
        else
            return funcionario;
    }

    // Métodos Set

    public void setSenhaAdmin(String senha) {
        if (admin.getSenha() != null)
            throw new AdminException("Admin já possui senha definida");
        else
            admin = new Administraçao(this, senha);
    }

    public void setAgencia(String nome, Agencia agencia, String senha) {
        this.Auth(senha);
        agencias.put(nome, agencia);
    }

    public void setFuncionario(Integer numFuncional, Funcionario funcionario, String senha) {
        this.Auth(senha);
        funcionarios.put(numFuncional, funcionario);
    }

    // Métodos Get

    public String getNome() {
        return this.nome;
    }

    public String getSede() {
        return this.sede;
    }

    public Administraçao getAdmin(String senha) {
        this.Auth(senha);
        return this.admin;
    }

    public Map<String, Agencia> getAgencias(String senha) {
        this.Auth(senha);
        return this.agencias;
    }

    public Map<Integer, Funcionario> getFuncionarios(String senha) {
        this.Auth(senha);
        return this.funcionarios;
    }
}
