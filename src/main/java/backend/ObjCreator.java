package backend;

import java.util.Date;

public class ObjCreator {
    private static Integer contasID = 0;
    private static Integer clientesID = 0;
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
        try{
        agencia.setConta(++contasID, clienteID, tipoDeConta);
        } catch (Exception e) {
            state = false;
        }
        return state;
    }
}