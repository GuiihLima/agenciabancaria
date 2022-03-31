package backend;

import backend.exceptions.*;
import backend.interfaces.Validador;

import java.util.Vector;
import java.util.Date;

public abstract class Conta implements Validador {
    private double saldo;
    private Date criaçao;
    private Date ultAcesso;
    private Vector<Integer> clientes;

    public Conta(Agencia agencia, Integer clienteID) {
        this.saldo = 0;
        this.criaçao = new Date();
        this.ultAcesso = null;
        this.clientes = new Vector<Integer>();
        clientes.add(clienteID);
    }

    // Métodos Set

    public void setValor(double valor) {
        this.saldo += valor;
        this.chgUltimoAcesso();
    }

    public void setCliente(Integer clienteID) {
        this.clientes.add(clienteID);
        this.chgUltimoAcesso();
    }

    // Métodos Get

    public void getValor(double valor) {
        if (valor > this.saldo)
            throw new ArgumentoInvalidoException("Saldo insuficiente");
        else
            this.saldo -= valor;
        this.chgUltimoAcesso();
    }
    
    public double getSaldo() {
        this.chgUltimoAcesso();
        return this.saldo;
    }
    
    public Vector<Integer> getClientes() {
        this.chgUltimoAcesso();
        return this.clientes;
    }
    
    public Date getCriaçao() {
        this.chgUltimoAcesso();
        return this.criaçao;
    }
    
    public Date getUltimoAcesso() {
        Date ultimoAcesso = this.ultAcesso;
        this.chgUltimoAcesso();
        return ultimoAcesso;
    }

    public void chgUltimoAcesso() {
        this.ultAcesso = new Date();
    }
}