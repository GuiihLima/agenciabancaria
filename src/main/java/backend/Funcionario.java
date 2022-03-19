package backend;

import java.util.Date;
import java.util.Vector;

public abstract class Funcionario {
	private String nome;
	private Integer numero;
	private Date admissao;
	private Funcionario supervisor;
	private Vector<Funcionario> dependentes = new Vector<Funcionario>();

	public Funcionario(String nome, Integer numero, Funcionario supervisor) {
		this.nome = nome;
		this.numero = numero;
		this.supervisor = supervisor;
		this.admissao = new Date();
	}

	// Métodos Set

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
