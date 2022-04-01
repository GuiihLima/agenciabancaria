package backend;

import java.io.IOException;
import java.util.Date;

public class Teste {
    public static void main(String[] args) {
        Banco bbank = new Banco("BBank", "SP", "admin");
        Agencia agc = new Agencia("Uberlândia", "MG");
        bbank.authenticate("admin");
        bbank.setAgencia("Udia", agc);
        ObjCreator.criaCliente(agc, "Guilherme", "0123", new Date(), "endereço", "cidade", "estado");

        try {

            Serializer.serialize(bbank);

        } catch (IOException e) {

            System.out.println("Deu ruim");
            e.printStackTrace();
            
        }

        try {

            Banco banco = Serializer.desserialize();
            System.out.println(banco.getNome());
            Agencia agencia = banco.getAgencia("Udia");
            System.out.println(banco.getAllAgencias());
            Pessoa cliente = agencia.getCliente(1);
            System.out.println(cliente.getNome());

        } catch (ClassNotFoundException e) {

            System.out.println("Deu merda");
            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Deu caca");
            e.printStackTrace();

        }
    }
}
