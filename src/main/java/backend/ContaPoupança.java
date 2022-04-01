package backend;

import backend.interfaces.Tributos;

public class ContaPoupança extends Conta implements Tributos {
	public ContaPoupança(Agencia agencia, Integer clienteID) {
		super(agencia, clienteID);
	}

	public double getValorTributo(){
		return 0.1;
	}
}
