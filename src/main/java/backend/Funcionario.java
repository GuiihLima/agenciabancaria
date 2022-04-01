package backend;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

public class Funcionario implements Serializable {
	private String nome;
	private Integer numero;
	private Date admissao;
	private Funcionario supervisor;
	private Vector<Funcionario> dependentes;

	public Funcionario(String nome, Integer numero) {
		this.nome = nome;
		this.numero = numero;
		this.admissao = new Date();
		this.dependentes = new Vector<Funcionario>();
	}

	// Métodos Set

	public void setSupervisor(Funcionario supervisor) {
		this.supervisor = supervisor;
	}

	public void setDependente(Funcionario funcionario) {
		dependentes.add(funcionario);
	}

	// Métodos Get

	public String getNome() {
		return this.nome;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public Date getAdmissao() {
		return this.admissao;
	}

	public Funcionario getSupervisor() {
		return this.supervisor;
	}

	public Vector<Funcionario> getDependentes() {
		return this.dependentes;
	}
}
