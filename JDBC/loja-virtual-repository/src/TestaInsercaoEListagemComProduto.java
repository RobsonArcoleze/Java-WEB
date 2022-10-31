import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.ProdutoDAO;
import modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("comoda", "comoda vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(comoda);
			List<Produto> listaDeProduto = produtoDAO.lista();
			listaDeProduto.stream().forEach(lp -> System.out.println(lp));
		}
		System.out.println(comoda.toString());
	}

}
