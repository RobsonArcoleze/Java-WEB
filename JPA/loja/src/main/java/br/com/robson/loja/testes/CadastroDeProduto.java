package br.com.robson.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.robson.loja.dao.CategoriaDao;
import br.com.robson.loja.dao.ProdutoDao;
import br.com.robson.loja.modelo.Categoria;
import br.com.robson.loja.modelo.Produto;
import br.com.robson.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		cadastarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarTodos();
		
		todos.forEach(p2 -> System.out.println(p2.getNome()));
			
	}

	private static void cadastarProduto() {
		Categoria celulares = new Categoria("CELULAR");
		
		Produto celular = new Produto("Xiaomi  Redmi", "Muito legal", new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		em.persist(celulares);
		celulares.setNome("XPTO");
		
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares);
		celulares.setNome("Sansumg");
		em.flush();
		
		em.remove(celulares);
		em.flush();
	}
}
