package br.com.alura.loja.teste;

import java.math.BigDecimal;

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

public class PerformanceConsultas {

	public static void main(String[] args) {
		popularBancoDeDados();
		
	    EntityManager em = JPAUtil.getEntityManeger();
	    PedidoDAO pedidoDAO = new PedidoDAO(em);
	    Pedido pedido = pedidoDAO.buscarPedidoComCliente(1l);
	    
	    em.close();
	    System.out.println(pedido.getCliente().getNome());
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
        Produto videogame = new Produto("PS5", "PlayStation 5", new BigDecimal("4500"), videogames);
        Produto macbook = new Produto("Macbook", "Macbook Pro", new BigDecimal("7500"), informatica);
        
        Cliente cliente = new Cliente("José", "12345678");
        
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, celular));
        pedido.adicionarItem(new ItemPedido(10, pedido, macbook));
        
        Pedido pedido2 = new Pedido(cliente);
        pedido2.adicionarItem(new ItemPedido(2, pedido, videogame));
        
        EntityManager em = JPAUtil.getEntityManeger();
        CategoriaDAO cate = new CategoriaDAO(em);
        ProdutoDAO dao = new ProdutoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);
        PedidoDAO pedidoDAO = new PedidoDAO(em);
        
        
        em.getTransaction().begin();
        
        cate.cadastrar(celulares);
        cate.cadastrar(videogames);
        cate.cadastrar(informatica);
        
        dao.cadastrar(celular);
        dao.cadastrar(videogame);
        dao.cadastrar(macbook);
        
        pedidoDAO.cadastrar(pedido);
        pedidoDAO.cadastrar(pedido2);
        
        clienteDAO.cadastrar(cliente);
        
        em.getTransaction().commit();
        em.close();
	}
}
