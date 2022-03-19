package backend;

import backend.exceptions.*;
import java.util.HashMap;
import java.util.Map;

public class Agencia {
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
        boolean clienteExiste = false;
        for (Map.Entry<Integer, Pessoa> cliente : clientes.entrySet()) {
            if (cliente.getKey() == clienteID)
                clienteExiste = true;
        }
        if (clienteExiste)
            if (contaType == 1)
                contas.put(contaID, new ContaPoupança(clienteID));
            else if (contaType == 2)
                contas.put(contaID, new ContaCorrente(clienteID));
            else
                throw new ArgumentoIndefinidoException(
                        "Tipo de conta inválido; Deve ser 1 para Conta Poupança ou 2 para Conta Corrente");
        else
            throw new ClienteInexistenteException("ID de Cliente inválido");
    }
}
