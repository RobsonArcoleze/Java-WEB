package br.com.robson.loja.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

	public Long getId() {
		return id;
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
