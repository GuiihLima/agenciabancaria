package backend;

import java.util.Map;

import backend.interfaces.Validador;

public class Administraçao implements Validador {
    private Banco banco;
    private String senhaAdmin = null;

    public Administraçao(Banco banco) {
        this.banco = banco;
    }

    public Administraçao(Banco banco, String senhaAdmin) {
        this.banco = banco;
        this.senhaAdmin = senhaAdmin;
    }

    // Métodos Manage

    public Agencia manageAgencia(String nome) {
        return banco.manageAgencia(nome, senhaAdmin);
    }

    public Funcionario manageFuncionario(Integer numFuncional) {
        return banco.manageFuncionario(numFuncional, senhaAdmin);
    }

    // Métodos Set

    public void setAgencia(String nome, Agencia agencia) {
        banco.setAgencia(nome, agencia, senhaAdmin);
    }

    public void setFuncionario(Integer numFuncional, Funcionario funcionario) {
        banco.setFuncionario(numFuncional, funcionario, senhaAdmin);
    }

    // Métodos Get

    public String getSenha() {
        return this.senhaAdmin;
    }

    public Map<String, Agencia> getAgencias() {
        return banco.getAgencias(senhaAdmin);
    }

    public Map<Integer, Funcionario> getFuncionarios() {
        return banco.getFuncionarios(senhaAdmin);
    }
}
