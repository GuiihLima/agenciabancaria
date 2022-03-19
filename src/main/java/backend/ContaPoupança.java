package backend;

import java.util.Date;
import java.util.Vector;

public class ContaPoupança extends Conta {
	public ContaPoupança(Agencia agencia, Integer clienteID) {
		super(agencia, clienteID);
	}

	public void setValor(double valor) {
		super.chgUltimoAcesso(new Date());
		super.setValor(valor);
	}
	
	public void getValor(double valor) {
		super.chgUltimoAcesso(new Date());
		super.getValor(valor);
	}

	public double getSaldo(){
		super.chgUltimoAcesso(new Date());
		return super.getSaldo();
	}

	public void setCliente(Integer clienteID) {
		super.chgUltimoAcesso(new Date());
		super.setCliente(clienteID);
	}

	public Vector<Integer> getClientes() {
		super.chgUltimoAcesso(new Date());
		return super.getClientes();
	}
}
