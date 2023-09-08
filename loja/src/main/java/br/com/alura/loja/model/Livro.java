package br.com.alura.loja.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Livro extends Produto{

	private String autor;
	
	@Column(name = "numero_pagina")
	private Integer numeroPagina;
	
	public Livro() {
		
	}
	
	public Livro(String autor, Integer numeroPagina) {
		this.autor = autor;
		this.numeroPagina = numeroPagina;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(Integer numeroPagina) {
		this.numeroPagina = numeroPagina;
	}
	
	
}
