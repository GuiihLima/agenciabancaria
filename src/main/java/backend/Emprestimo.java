package backend;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import backend.exceptions.IDInvalidoException;

public class Emprestimo implements Serializable {
    private Double valorTotal;
    private Double valorParcela;
    private Integer parcelas;
    private Map<Integer, Cliente> clientes;

    public Emprestimo(Double valor, Integer parcelas) {
        this.valorTotal = valor;
        this.parcelas = parcelas;
        this.valorParcela = valor / parcelas;
        this.clientes = new HashMap<Integer, Cliente>();
    }

    // Métodos Set

    public void setCliente(Integer id, Cliente cliente) {
        clientes.put(id, cliente);
    }

    // Métodos Get

    public Double getValorTotal() {
        return this.valorTotal;
    }

    public Double getValorRestante() {
        return this.valorParcela * this.parcelas;
    }

    public Integer getParcelas() {
        return this.parcelas;
    }

    public Cliente getCliente(Integer clienteID) {
        Cliente cliente = clientes.get(clienteID);
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

    // Método Pay

    public Boolean payParcela(Conta conta) {
        if (parcelas == 0)
            return false;

        conta.getValor(this.valorParcela);
        this.parcelas--;
        return true;
    }
}
