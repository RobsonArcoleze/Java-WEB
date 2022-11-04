package br.com.robson.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.robson.loja.dao.CategoriaDao;
import br.com.robson.loja.dao.ProdutoDao;
import br.com.robson.loja.modelo.Categoria;
import br.com.robson.loja.modelo.Produto;
import br.com.robson.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULAR");
		
		Produto celular = new Produto("Xiaomi  Redmi", "Muito legal", new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
		
	}
}
