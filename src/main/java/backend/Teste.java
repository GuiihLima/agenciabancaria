package backend;

import java.io.IOException;

public class Teste {
    public static void main(String[] args) {
        Banco bbank = new Banco("BBank", "SP");

        try {
            Serializer.serialize(bbank);
        } catch (IOException e) {
            System.out.println("Deu ruim");
            e.printStackTrace();
        }

        try {
            Banco banco = Serializer.desserialize();
            System.out.println(banco.getNome());
        } catch (ClassNotFoundException e) {
            System.out.println("Deu merda");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Deu caca");
            e.printStackTrace();
        }
    }
}
