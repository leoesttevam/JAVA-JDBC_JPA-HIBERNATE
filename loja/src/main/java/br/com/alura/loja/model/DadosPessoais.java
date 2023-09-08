package br.com.alura.loja.model;

import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {

	private String nome;
	private String CPF;
	
	public DadosPessoais() {
		
	}
	
	public DadosPessoais(String nome, String CPF) {
		this.nome = nome;
		this.CPF = CPF;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
}
