package backend;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import backend.exceptions.IDInvalidoException;

public class Emprestimo implements Serializable {
    private Double valor;
    private Integer parcelas;
    private Map<Integer, Pessoa> clientes;

    public Emprestimo(Double valor, Integer parcelas) {
        this.valor = valor;
        this.parcelas = parcelas;
        this.clientes = new HashMap<Integer, Pessoa>();
    }

    // Métodos Set

    public void setCliente(Integer id, Pessoa cliente) {
         clientes.put(id, cliente);
    }

    // Métodos Get

    public Double getValor() {
        return this.valor;
    }

    public Integer getParcelas() {
        return this.parcelas;
    }

    public Pessoa getCliente(Integer clienteID) {
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
}
