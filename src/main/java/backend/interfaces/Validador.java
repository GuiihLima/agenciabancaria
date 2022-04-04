package backend.interfaces;

import java.util.Map;
import backend.*;

public interface Validador {
    default boolean isCliente(Integer clienteID, Map<Integer, Cliente> clientes) {
        boolean iscliente = false;
        if (clientes.containsKey(clienteID))
            iscliente = true;
        return iscliente;
    }

    default boolean isConta(Integer contaID, Map<Integer, Conta> contas) {
        boolean isconta = false;
        if (contas.containsKey(contaID))
            isconta = true;
        return isconta;
    }
}
