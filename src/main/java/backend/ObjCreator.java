package backend;

import java.util.Date;

public class ObjCreator {
    private static Integer idCreator() throws InterruptedException {
        Date time = new Date();
        Integer id = Math.abs(time.hashCode());
        Thread.sleep(10);
        return id;
    }

    public static Integer criaCliente(Agencia agencia, String nome, String cpf, Date nascimento, String endereço,
            String cidade, String estado, String senha) {
                Integer id;
                try {
            id = idCreator();
            Cliente cliente = new Cliente(nome, cpf, nascimento, endereço, cidade, estado, senha);
            agencia.setCliente(id, cliente);
        } catch (Exception e) {
            id = null;
        }
        return id;
    }

    public static Integer criaFuncionario(Agencia agencia, String nome, Integer numero, Integer funçao, String senha) {
        Integer id;
        try {
            id = idCreator();
            Funcionario funcionario = new Funcionario(nome, numero, funçao, senha);
            agencia.setFuncionario(id, funcionario);
        } catch (Exception e) {
            id = null;
        }
        return id;
    }

    public static Integer criaConta(Agencia agencia, Integer clienteID, Integer tipoDeConta) {
        Integer id;
        try {
            id = idCreator();
            agencia.setConta(id, clienteID, tipoDeConta);
        } catch (Exception e) {
            id = null;
        }
        return id;
    }

    public static Integer criaOperaçao(ContaCorrente conta, String tipo, String descrição, Double valor, Date data) {
        Integer id;
        try {
            id = idCreator();
            Operaçao operaçao = new Operaçao(tipo, descrição, valor, data);
            conta.getValor(valor);
            conta.setOperacao(id, operaçao);
            Thread.sleep(10);
            if (valor > 5000) {
                Date validade = new Date();
                Integer idCupom = idCreator();
                validade.setMonth(validade.getMonth() + 1);
                conta.setCupom(idCupom, validade);
            }
        } catch (Exception e) {
            id = null;
        }
        return id;
    }

    public static Integer criaEmprestimo(Agencia agencia, Integer[] clientesID, Double valor, Integer parcelas) {
        Integer id;
        try {
            id = idCreator();
            Emprestimo emprestimo = new Emprestimo(valor, parcelas);
            agencia.setEmprestimo(id, emprestimo);
            for (int i = 0; i < clientesID.length; i++) {
                Cliente cliente = agencia.getCliente(clientesID[i]);
                emprestimo.setCliente(clientesID[i], cliente);
            }
        } catch (Exception e) {
            id = null;
        }
        return id;
    }
}