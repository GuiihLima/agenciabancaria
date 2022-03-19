package backend;

import backend.exceptions.*;

public class ContaCorrente extends Conta {

	public ContaCorrente(Integer clienteID) {
		super(clienteID);
	}
	
	@Override
	public void saca(double valor) throws ArgumentoIndefinidoException {
		double valorASacar = 1.2 * valor ;
		super.saca(valorASacar);
	}

	@Override
	public void deposita(double valor) {
        super.saldo += valor;
    }

	@Override
	public double getValorImposto() {	
		return super.saldo * 0.01;
	}
	
}
