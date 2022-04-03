package backend;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import backend.interfaces.Tributos;

public class ContaCorrente extends Conta implements Tributos {
	private Map<Integer, Date> cupons;
	private Map<Integer, Operaçao> operaçoes;

	public ContaCorrente(Agencia agencia, Integer clienteID) {
		super(agencia, clienteID);
		operaçoes = new HashMap<Integer, Operaçao>();
	}

	// Métodos Set

	public void setOperacao(Integer operaçaoID, Operaçao operaçao) {
		super.getValor(operaçao.getValor());
		operaçoes.put(operaçaoID, operaçao);
	}
	
	public void setCupom(Integer id, Date validade) {
		cupons.put(id, validade);
	}

	// Métodos Get

	public Vector<Integer> getOperaçoes() {
		Vector<Integer> operaçoes = new Vector<Integer>();
		this.operaçoes.forEach((key, value) -> operaçoes.add(key));
		return operaçoes;
	}

	public double getValorTributo() {
		return 45;
	}

	public Map<Integer, Date> getCupons() {
		return this.cupons;
	}
}
