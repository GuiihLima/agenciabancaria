package backend;

import backend.exceptions.*;
import java.util.ArrayList;
import java.util.Date;

public abstract class Conta {
    protected double saldo;
    protected Date criaçao;
    protected Date ultAcesso;
    protected ArrayList<Integer> clientes = new ArrayList<Integer>();

    protected Conta(Integer clienteID) {
        this.saldo = 0;
        this.criaçao = new Date();
        this.ultAcesso = null;
        clientes.add(clienteID);
    }

    public void setDeposito(double valor) {
        this.saldo += valor;
    }

    public void saca(double valor) throws ArgumentoIndefinidoException {

        if (this.saldo < valor) {
            throw new ArgumentoIndefinidoException(
                    "Saldo de: " + this.saldo + ", é insufiencie para realizar este saque: ");
        }

        this.saldo -= valor;
    }

    public void transferencia(double valor, Conta destino) throws ArgumentoIndefinidoException {
        this.saca(valor);
        destino.deposita(valor);
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setCliente(Integer clienteID) {
        this.clientes.add(clienteID);
    }

    public ArrayList<Integer> getClientes() {
        return this.clientes;
    }
}