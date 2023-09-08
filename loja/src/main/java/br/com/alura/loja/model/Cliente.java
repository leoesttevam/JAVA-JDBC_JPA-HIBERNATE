package br.com.alura.loja.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private DadosPessoais dadosPessoais;
	
	@OneToMany
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente(String nome, String CPF) {
		this.dadosPessoais = new DadosPessoais(nome, CPF);
	}
	
	public Cliente() {
		
	}

	public Long getId() {
		return id;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}
	
	public String getNome() {
		return this.dadosPessoais.getNome();
	}
	
	public String getCPF() {
		return this.dadosPessoais.getCPF();
	}
}
