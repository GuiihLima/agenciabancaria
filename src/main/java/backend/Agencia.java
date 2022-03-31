package backend;

import backend.exceptions.*;
import backend.interfaces.Validador;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Agencia implements Validador {
    private String cidade;
    private String estado;
    private Map<Integer, Pessoa> clientes;
    private Map<Integer, Conta> contas;

    public Agencia(String cidade, String estado) {
        this.cidade = cidade;
        this.estado = estado;
        clientes = new HashMap<Integer, Pessoa>();
        contas = new HashMap<Integer, Conta>();
    }

    // Métodos Set

    public void setCliente(Integer id, Pessoa cliente) {
        clientes.put(id, cliente);
    }

    public void setConta(Integer clienteID, Integer contaID, int contaType) {
        if (isCliente(clienteID, clientes)) {
            switch (contaType) {
                case 1:
                    contas.put(contaID, new ContaPoupança(this, clienteID));
                    break;

                case 2:
                    contas.put(contaID, new ContaCorrente(this, clienteID));
                    break;

                default:
                    throw new ArgumentoInvalidoException(
                            "Tipo de conta inválido; Deve ser 1 para Conta Poupança ou 2 para Conta Corrente");
            }
        } else
            throw new ClienteInvalidoException("ID de Cliente inválido");
    }

    // Métodos Get

    public String getCidade() {
        return this.cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public Pessoa getCliente(Integer clienteID) throws ClienteInvalidoException {
        Pessoa cliente = clientes.get(clienteID);
        if (cliente == null)
            throw new ClienteInvalidoException("Cliente inexistente ou ID incorreto");
        else
            return cliente;
    }

    public Vector<Integer> getAllClientes() {
        Vector<Integer> allClientes = new Vector<Integer>();
        this.clientes.forEach((key, value) -> allClientes.add(key));
        return allClientes;
    }

    public Conta getConta(Integer contaID) throws ContaInvalidaException {
        Conta conta = contas.get(contaID);
        if (conta == null)
            throw new ContaInvalidaException("Conta inexistente ou ID incorreta");
        else
            return conta;
    }

    public Vector<Integer> getAllContas() {
        Vector<Integer> allContas = new Vector<Integer>();
        this.contas.forEach((key, value) -> allContas.add(key));
        return allContas;
    }

    // Métodos Make

    public void makeTransferencia(Integer contaRemetente, Integer contaDestino, double valor)
            throws TransferenciaInvalidaException {
        if (!isConta(contaRemetente, contas))
            throw new TransferenciaInvalidaException("ID da conta remetente inválido");
        else if (!isConta(contaDestino, contas))
            throw new TransferenciaInvalidaException("ID da conta destino inválido");

        Conta remetente = contas.get(contaRemetente);
        Conta destino = contas.get(contaDestino);
        remetente.getValor(valor);
        destino.setValor(valor);
    }
}
