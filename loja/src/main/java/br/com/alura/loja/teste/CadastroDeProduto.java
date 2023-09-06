package br.com.alura.loja.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
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