package backend;

import java.util.Date;

public class ObjCreator {
    private static Integer cuponsID = 0;
    private static Integer contasID = 0;
    private static Integer clientesID = 0;
    private static Integer operaçoesID = 0;
    private static Integer emprestimosID = 0;
    private static Integer funcionariosID = 0;

    public static boolean criaCliente(Agencia agencia, String nome, String cpf, Date nascimento, String endereço,
            String cidade, String estado) {
        boolean state = true;
        try {
            Pessoa cliente = new Pessoa(nome, cpf, nascimento, endereço, cidade, estado);
            agencia.setCliente(++clientesID, cliente);
        } catch (Exception e) {
            state = false;
        }
        return state;
    }

    public static boolean criaFuncionario(Agencia agencia, String nome, Integer numero) {
        boolean state = true;
        try {
            Funcionario funcionario = new Funcionario(nome, numero);
            agencia.setFuncionario(++funcionariosID, funcionario);
        } catch (Exception e) {
            state = false;
        }
        return state;
    }

    public static boolean criaConta(Agencia agencia, Integer clienteID, Integer tipoDeConta) {
        boolean state = true;
        try {
            agencia.setConta(++contasID, clienteID, tipoDeConta);
        } catch (Exception e) {
            state = false;
        }
        return state;
    }

    public static boolean criaOperaçao(ContaCorrente conta, String tipo, String descrição, Double valor, Date data) {
        boolean state = true;
        try {
            Operaçao operaçao = new Operaçao(tipo, descrição, valor, data);
            conta.getValor(valor);
            conta.setOperacao(++operaçoesID, operaçao);
            if (valor > 5000) {
                Date validade = new Date();
                validade.setMonth(validade.getMonth() + 1);
                conta.setCupom(++cuponsID, validade);
            }
        } catch (Exception e) {
            state = false;
        }
        return state;
    }

    public static boolean criaEmprestimo(Agencia agencia, Integer[] clientesID, Double valor, Integer parcelas) {
        boolean state = true;
        try {
            Emprestimo emprestimo = new Emprestimo(valor, parcelas);
            agencia.setEmprestimo(++emprestimosID, emprestimo);
            for (int i = 0; i < clientesID.length; i++) {
                Pessoa cliente = agencia.getCliente(clientesID[i]);
                emprestimo.setCliente(clientesID[i], cliente);
            }
        } catch (Exception e) {
            state = false;
        }
        return state;
    }
}