package backend;

import java.io.Serializable;
import java.util.Date;

public class Operaçao implements Serializable {
    private String tipo;
    private String descriçao;
    private double valor;
    private Date data;

    public Operaçao(String tipo, String descriçao, double valor, Date data) {
        this.tipo = tipo;
        this.descriçao = descriçao;
        this.valor = valor;
        this.data = data;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getDescriçao() {
        return this.descriçao;
    }

    public double getValor(){
        return this.valor;
    }

    public Date getData(){
        return this.data;
    }
}
