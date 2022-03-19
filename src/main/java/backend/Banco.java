package backend;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import backend.exceptions.*;
import backend.interfaces.Validador;

public class Banco implements Validador {
    private String nome;
    private String sede;
    private Administraçao admin;
    private Vector<Agencia> agencias;
    private Map<Integer, Funcionario> funcionarios = new HashMap<Integer, Funcionario>();

    public Banco(String nome, String sede) {
        this.nome = nome;
        this.sede = sede;
        this.admin = new Administraçao(this);
    }

    public Banco(String nome, String sede, String senhaAdmin) {
        this.nome = nome;
        this.sede = sede;
        this.admin = new Administraçao(this, senhaAdmin);
    }

    // Autenticação

    private void Auth(String senha) {
        if (isAdmin(admin, senha))
            return;
        else
            throw new ArgumentoInvalidoException("Senha incorreta");
    }

    // Métodos Set

    public void setSenhaAdmin(String senha) {
        if(admin.getSenha() != null)
            throw new AdminException("Admin já possui senha definida");
        else
            admin = new Administraçao(this, senha);
    }

    public void setAgencia(Agencia agencia, String senha) {
        this.Auth(senha);
        agencias.add(agencia);
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

    public Vector<Agencia> getAgencias(String senha) {
        this.Auth(senha);
        return this.agencias;
    }

    public Map<Integer, Funcionario> getFuncionarios(String senha) {
        this.Auth(senha);
        return this.funcionarios;
    }
}
