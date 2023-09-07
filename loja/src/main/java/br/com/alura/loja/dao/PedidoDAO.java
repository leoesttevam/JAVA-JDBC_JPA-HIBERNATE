package br.com.alura.loja.dao;

import javax.persistence.EntityManager;
import br.com.alura.loja.model.Pedido;

public class PedidoDAO {

	private EntityManager em;
	
	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
}
