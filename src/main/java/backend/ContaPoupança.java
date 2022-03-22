package backend;

import java.util.Date;
import java.util.Vector;

import backend.interfaces.Tributos;

public class ContaPoupança extends Conta implements Tributos {
	public ContaPoupança(Agencia agencia, Integer clienteID) {
		super(agencia, clienteID);
	}

	// Métodos Set

	public void setValor(double valor) {
		super.chgUltimoAcesso(new Date());
		super.setValor(valor);
	}

	public void setCliente(Integer clienteID) {
		super.chgUltimoAcesso(new Date());
		super.setCliente(clienteID);
	}

	// Métodos Get

	public void getValor(double valor) {
		super.chgUltimoAcesso(new Date());
		super.getValor(valor);
	}

	public double getSaldo() {
		super.chgUltimoAcesso(new Date());
		return super.getSaldo();
	}

	public Vector<Integer> getClientes() {
		super.chgUltimoAcesso(new Date());
		return super.getClientes();
	}

	public double getValorTributo(){
		return 0.1;
	}
}
