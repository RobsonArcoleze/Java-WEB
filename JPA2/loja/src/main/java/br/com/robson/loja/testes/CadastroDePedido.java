package br.com.robson.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.robson.loja.dao.CategoriaDao;
import br.com.robson.loja.dao.ClienteDao;
import br.com.robson.loja.dao.PedidoDao;
import br.com.robson.loja.dao.ProdutoDao;
import br.com.robson.loja.modelo.Categoria;
import br.com.robson.loja.modelo.Cliente;
import br.com.robson.loja.modelo.ItemPedido;
import br.com.robson.loja.modelo.Pedido;
import br.com.robson.loja.modelo.Produto;
import br.com.robson.loja.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		Produto produto = produtoDao.buscarPorId(1l);
		Cliente cliente = clienteDao.buscarPorId(1l);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, produto, pedido));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		
		em.getTransaction().commit();
	}
	
	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );
		
		Cliente cliente = new Cliente("Rodrigo", "123456");
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		clienteDao.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();
	}

}