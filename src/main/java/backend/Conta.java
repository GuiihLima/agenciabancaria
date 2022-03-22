package backend;

import backend.exceptions.*;
import backend.interfaces.Validador;

import java.util.Vector;
import java.util.Date;

public abstract class Conta implements Validador {
    private Agencia agencia;
    private double saldo;
    private Date criaçao;
    private Date ultAcesso;
    private Vector<Integer> clientes;

    public Conta(Agencia agencia, Integer clienteID) {
        this.saldo = 0;
        this.criaçao = new Date();
        this.ultAcesso = null;
        this.agencia = agencia;
        clientes = new Vector<Integer>();
        clientes.add(clienteID);
    }

    // Métodos Make

    public void makeTransferencia(Integer contaID, double valor) {
        if (valor > this.saldo)
            throw new ArgumentoInvalidoException("Saldo insuficiente");

        boolean transferido = agencia.makeTransferencia(contaID, valor);
        if (transferido)
            this.saldo -= valor;
        else
            throw new ArgumentoInvalidoException("ID de Conta inválido");
    }

    // Métodos Set

    public void setValor(double valor) {
        this.saldo += valor;
    }

    public void setCliente(Integer clienteID) {
        this.clientes.add(clienteID);
    }

    // Métodos Get

    public void getValor(double valor) {
        if (valor > this.saldo)
            throw new ArgumentoInvalidoException("Saldo insuficiente");
        else
            this.saldo -= valor;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public Vector<Integer> getClientes() {
        return this.clientes;
    }

    public Date getCriaçao() {
        return this.criaçao;
    }

    public Date getUltimoAcesso(){
        return this.ultAcesso;
    }

    public void chgUltimoAcesso(Date data) {
        this.ultAcesso = data;
    }
}