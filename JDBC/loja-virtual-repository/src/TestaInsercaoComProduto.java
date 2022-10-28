import java.sql.Connection;
import java.sql.SQLException;

import modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		
		Produto comoda = new Produto("comoda", "comoda vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(comoda);
		}
		System.out.println(comoda.toString());
	}

}
