package br.com.alura.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.Cliente;
import br.com.alura.loja.model.ItemPedido;
import br.com.alura.loja.model.Pedido;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		
		EntityManager em = JPAUtil.getEntityManeger();
		ProdutoDAO dao = new ProdutoDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		Produto produto = dao.buscarPorId(1l);
		Cliente cliente = clienteDAO.buscarPorId(1l);
				
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		PedidoDAO pedidoDAO = new PedidoDAO(em);
		pedidoDAO.cadastrar(pedido);
		
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("Valor total " + totalVendido);
		
		List<Object[]> objects = pedidoDAO.relatorioDeVendas();
		for(Object[] obj : objects) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
		}
	}
	
	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		Cliente cliente = new Cliente("José", "12345678");
		
        EntityManager em = JPAUtil.getEntityManeger();
        CategoriaDAO cate = new CategoriaDAO(em);
        ProdutoDAO dao = new ProdutoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);
        
        em.getTransaction().begin();
        clienteDAO.cadastrar(cliente);
        cate.cadastrar(celulares);
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
	}
}
