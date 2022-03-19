package backend;

import java.util.ArrayList;

public class Banco {
    String nome;
    String sede;
    ArrayList<Agencia> agencias;

    public Banco(String nome, String sede) {
        this.nome = nome;
        this.sede = sede;
    }

    public void setAgencia(Agencia agencia) {
        agencias.add(agencia);
    }
}
