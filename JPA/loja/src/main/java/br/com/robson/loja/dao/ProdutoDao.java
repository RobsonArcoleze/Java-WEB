package br.com.robson.loja.dao;

import javax.persistence.EntityManager;

import br.com.robson.loja.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
	this.em.persist(produto); 	
	}
	
}
