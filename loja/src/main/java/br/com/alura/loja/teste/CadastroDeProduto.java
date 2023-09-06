package br.com.alura.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		cadastraProduto();
		
		 Long id = 1l;
	     EntityManager em = JPAUtil.getEntityManeger();
	     ProdutoDAO produtoDao = new ProdutoDAO(em);
	     
	     Produto p = produtoDao.buscarPorId(1l);
	     System.out.println(p.getPreco());

	     List<Produto> todos = produtoDao.buscarTodos();
	     todos.forEach(p2 -> System.out.println(p2.getNome()));

	     List<Produto> todo = produtoDao.buscarPorNome("CELULARES");
	     todo.forEach(p2 -> System.out.println(p2.getNome()));
	     
	     List<Produto> tod = produtoDao.buscarPorNomeDaCategoria("CELULARES");
	     tod.forEach(p2 -> System.out.println(p2.getNome()));
	     
	     BigDecimal precoDoProduto = produtoDao.buscarPrecoProdutoComNome("Xiaomi Redmi");
	     System.out.println(precoDoProduto);


	}

	private static void cadastraProduto() {
		Categoria celulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
        
        EntityManager em = JPAUtil.getEntityManeger();
        CategoriaDAO cate = new CategoriaDAO(em);
        ProdutoDAO dao = new ProdutoDAO(em);
        
        em.getTransaction().begin();
        cate.cadastrar(celulares);
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
	}
}
