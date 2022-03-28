package backend.interfaces;

import java.util.Map;
import backend.*;

public interface Validador {
    default boolean isCliente(Integer clienteID, Map<Integer, Pessoa> clientes) {
        boolean iscliente = false;
        for (Map.Entry<Integer, Pessoa> cliente : clientes.entrySet()) {
            if (cliente.getKey() == clienteID)
                iscliente = true;
        }
        return iscliente;
    }

    default boolean isConta(Integer contaID, Map<Integer, Conta> contas) {
        boolean isconta = false;
        for (Map.Entry<Integer, Conta> conta : contas.entrySet()) {
            if (conta.getKey() == contaID)
                isconta = true;
        }
        return isconta;
    }
}
