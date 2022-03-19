package backend;

import backend.exceptions.*;
import backend.interfaces.Validador;

import java.util.Vector;
import java.util.Date;

public abstract class Conta implements Validador {
    protected Agencia agencia;
    protected double saldo;
    protected Date criaçao;
    protected Date ultAcesso;
    protected Vector<Integer> clientes = new Vector<Integer>();

    protected Conta(Agencia agencia, Integer clienteID) {
        this.saldo = 0;
        this.criaçao = new Date();
        this.ultAcesso = null;
        this.agencia = agencia;
        clientes.add(clienteID);
    }

    protected void setValor(double valor) {
        this.saldo += valor;
    }

    protected void getValor(double valor) {
        if (valor > this.saldo)
            throw new ArgumentoInvalidoException("Saldo insuficiente");
        else
            this.saldo -= valor;
    }

    protected void makeTransferencia(Integer contaID, double valor) {
        if (valor > this.saldo)
            throw new ArgumentoInvalidoException("Saldo insuficiente");

        boolean transferido = agencia.makeTransferencia(contaID, valor);
        if (transferido)
            this.saldo -= valor;
        else
            throw new ArgumentoInvalidoException("ID de Conta inválido");
    }

    protected double getSaldo() {
        return this.saldo;
    }

    protected void setCliente(Integer clienteID) {
        this.clientes.add(clienteID);
    }

    protected Vector<Integer> getClientes() {
        return this.clientes;
    }

    protected void chgUltimoAcesso(Date data){
        this.ultAcesso = data;
    }
}