package br.com.robson.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // Esta anotação serve para mostrar que essa classe é uma entidade da JPA, ou
		// seja, se econtra no banco de dados;
@Table(name = "pedidos") // QUANDO O NOME DA TABELA NÃO É IGUAL O NOME DA CLASSE

public class Pedido {

	@Id // INFORMA QUE É CHAVE PRIMARIA "PRIMARY KEY"
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PARA DIZER COMO O VALOR É GERADO, OU SEJA CONFORME O BANCO
														// COM O AUTO_INCREMENT
	private Long id;
	private BigDecimal valorTotal;
	private LocalDate data = LocalDate.now();

	@ManyToOne // AQUI REPRESENTA A CARDINALIDADE ENTRE ESSE RELACIONAMENTO
	private Cliente cliente;
	
	private List<ItemPedido> produtos;

	public Pedido() {
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
