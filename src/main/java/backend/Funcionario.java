package backend;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import backend.exceptions.ArgumentoInvalidoException;
import backend.exceptions.AutenticaçaoInvalidaException;

public class Funcionario implements Serializable {
	private String nome;
	private Integer numero;
	private Integer funçao;
	private Date admissao;
	private Funcionario supervisor;
	private Vector<String> dependentes;
	private String senha;
	private Boolean authenticated = false;

	public Funcionario(String nome, Integer numero, Integer funçao, String senha) {
		this.nome = nome;
		this.numero = numero;
		this.funçao = funçao;
		this.admissao = new Date();
		this.dependentes = new Vector<>();
		this.senha = senha;
	}

	// Autenticação

	public void authenticate(String senha) { // Autentica o usuário
		if (senha.equals(this.senha))
			this.authenticated = true;
		else
			throw new ArgumentoInvalidoException("Senha incorreta");
	}

	public void deauthenticate() { // Desautentica o usuário
		this.authenticated = false;
	}

	// Métodos Set

	public void setSupervisor(Funcionario supervisor) {
		if (!this.authenticated)
			throw new AutenticaçaoInvalidaException("Acesso negado; Funcionário não autenticado");
		this.supervisor = supervisor;
	}

	public void setDependente(String funcionario) {
		if (!this.authenticated)
			throw new AutenticaçaoInvalidaException("Acesso negado; Funcionário não autenticado");
		dependentes.add(funcionario);
	}

	// Métodos Get

	public String getNome() {
		if (!this.authenticated)
			throw new AutenticaçaoInvalidaException("Acesso negado; Funcionário não autenticado");
		return this.nome;
	}

	public Integer getNumero() {
		if (!this.authenticated)
			throw new AutenticaçaoInvalidaException("Acesso negado; Funcionário não autenticado");
		return this.numero;
	}

	public Integer getFunçao() {
		return this.funçao;
	}

	public Date getAdmissao() {
		if (!this.authenticated)
			throw new AutenticaçaoInvalidaException("Acesso negado; Funcionário não autenticado");
		return this.admissao;
	}

	public Funcionario getSupervisor() {
		if (!this.authenticated)
			throw new AutenticaçaoInvalidaException("Acesso negado; Funcionário não autenticado");
		return this.supervisor;
	}

	public Vector<String> getDependentes() {
		if (!this.authenticated)
			throw new AutenticaçaoInvalidaException("Acesso negado; Funcionário não autenticado");
		return this.dependentes;
	}
}
