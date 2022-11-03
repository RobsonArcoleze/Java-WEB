package br.com.robson.loja.testes;

import java.math.BigDecimal;

import br.com.robson.loja.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi  Redmi");
		celular.setDescricao("Muito legal");
		celular.setPreco(new BigDecimal("800"));
		
		//ENTITYMANAGEFACTORY É O SUBSTITUTO DA CONNECTION USADA NA JDBC
		// CREATEENTITYMANAGERFACTORY ESPERA COMO ARGUMENTO A PERSISTENCE UNIT NAME = "COPIAR O NOME"
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();
	}
}
