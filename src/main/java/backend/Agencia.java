package backend;

import backend.exceptions.*;
import backend.interfaces.Validador;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Agencia implements Validador, Serializable {
    private String cidade;
    private String estado;
    private Map<Integer, Conta> contas;
    private Map<Integer, Pessoa> clientes;
    private Map<Integer, Emprestimo> emprestimos;
    private Map<Integer, Funcionario> funcionarios;

    public Agencia(String cidade, String estado) {
        this.cidade = cidade;
        this.estado = estado;
        this.contas = new HashMap<>();
        this.clientes = new HashMap<>();
        this.emprestimos = new HashMap<>();
        this.funcionarios = new HashMap<>();
    }

    // Métodos Set

    public void setCliente(Integer id, Pessoa cliente) {
        clientes.put(id, cliente);
    }

    public void setConta(Integer contaID, Integer clienteID, Integer contaType) {
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
            throw new IDInvalidoException("ID de Cliente inválido");
    }

    public void setFuncionario(Integer numFuncional, Funcionario funcionario) {
        funcionarios.put(numFuncional, funcionario);
    }

    public void setEmprestimo(Integer id, Emprestimo emprestimo) {
        this.emprestimos.put(id, emprestimo);
    }

    // Métodos Get

    public String getCidade() {
        return this.cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public Pessoa getCliente(Integer clienteID) throws IDInvalidoException {
        Pessoa cliente = clientes.get(clienteID);
        if (cliente == null)
            throw new IDInvalidoException("Cliente inexistente ou ID incorreto");
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

    public Funcionario getFuncionario(Integer numFuncional) {
        Funcionario funcionario = funcionarios.get(numFuncional);
        if (funcionario == null)
            throw new ArgumentoInvalidoException("Funcionario inexistente ou número funcional incorreto");
        else
            return funcionario;
    }

    public Vector<Integer> getAllFuncionarios() {
        Vector<Integer> allFuncionarios = new Vector<Integer>();
        this.funcionarios.forEach((key, value) -> allFuncionarios.add(key));

        return allFuncionarios;
    }

    // Métodos Make

    public void makeTransferencia(Conta remetente, Conta destino, double valor)
            throws TransferenciaInvalidaException {
        boolean isRemetente = false;
        boolean isDestino = false;
        for (Map.Entry<Integer, Conta> conta : contas.entrySet()) {
            if (conta.getValue().equals(remetente))
                isRemetente = true;
            else if (conta.getValue().equals(destino))
                isDestino = true;
        }

        if (!isRemetente || !isDestino)
            throw new TransferenciaInvalidaException("Remetente ou Destinatário inválido");

        remetente.getValor(valor);
        destino.setValor(valor);
    }
}
