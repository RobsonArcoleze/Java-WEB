package br.com.robson.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity // Esta anotação serve para mostrar que essa classe é uma entidade da JPA, ou
		// seja, se econtra no banco de dados;
@Table(name = "produtos") // QUANDO O NOME DA TABELA NÃO É IGUAL O NOME DA CLASSE

public class Produto {

	@Id // INFORMA QUE É CHAVE PRIMARIA "PRIMARY KEY"
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PARA DIZER COMO O VALOR É GERADO, OU SEJA CONFORME O BANCO
														// COM O AUTO_INCREMENT
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();
	
	@ManyToOne // AQUI REPRESENTA A CARDINALIDADE ENTRE ESSE RELACIONAMENTO
	private Categoria categoria;
	
		public Produto() {}

	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
