package backend;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import backend.interfaces.Tributos;

public class ContaCorrente extends Conta implements Tributos {
	private Date vencimentoTarifa;
	private Map<Integer, Date> cupons;
	private Map<Integer, Operaçao> operaçoes;

	public ContaCorrente(Agencia agencia, Integer clienteID) {
		super(agencia, clienteID);
		this.vencimentoTarifa = new Date();
		this.vencimentoTarifa.setMonth(super.getCriaçao().getMonth() + 1);
		this.operaçoes = new HashMap<>();
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

	public Date getVencimentoTarifa() {
		return this.vencimentoTarifa;
	}

	public double getValorTributo() {
		Date atual = new Date();
		if (this.vencimentoTarifa.after(atual))
			return 20;

		Integer diasVencidos = 0;
		Date aux = (Date) this.vencimentoTarifa.clone();
		while (aux.before(atual)) {
			aux.setDate(aux.getDate() + 1);
			diasVencidos++;
		}

		return 20 * (1 + (diasVencidos * 0.02));
	}

	public Map<Integer, Date> getCupons() {
		return this.cupons;
	}

	// Método Pay

	public void payTributo() {
		double valorTributo = getValorTributo();
		super.getValor(valorTributo);
		this.vencimentoTarifa.setMonth(this.vencimentoTarifa.getMonth() + 1);
	}
}
