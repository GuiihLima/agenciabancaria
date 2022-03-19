package backend;

import backend.exceptions.*;
import backend.interfaces.Validador;

import java.util.HashMap;
import java.util.Map;

public class Agencia implements Validador {
    private String nome;
    private String cidade;
    private String estado;
    private Map<Integer, Pessoa> clientes = new HashMap<Integer, Pessoa>();
    private Map<Integer, Conta> contas = new HashMap<Integer, Conta>();

    public Agencia(String nome, String cidade, String estado) {
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getEstado() {
        return this.estado;
    }

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
            throw new ClienteInexistenteException("ID de Cliente inválido");
    }

    public boolean makeTransferencia(Integer contaID, double valor) {
        if(isConta(contaID, contas)){
            Conta destino = contas.get(contaID);
            destino.setValor(valor);
            return true;
        }
            return false;
    }
}
