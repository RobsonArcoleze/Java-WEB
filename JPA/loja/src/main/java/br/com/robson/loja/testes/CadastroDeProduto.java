package br.com.robson.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.robson.loja.dao.ProdutoDao;
import br.com.robson.loja.modelo.Categoria;
import br.com.robson.loja.modelo.Produto;
import br.com.robson.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Produto celular = new Produto("Xiaomi  Redmi", "Muito legal", new BigDecimal("800"), Categoria.CELULAR);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin();;
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
		
	}
}
