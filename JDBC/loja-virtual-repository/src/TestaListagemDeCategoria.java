import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;

public class TestaListagemDeCategoria {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> categoria = categoriaDAO.listar(); 
			
			categoria.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				try {
					for(Produto produto : new ProdutoDAO(connection).buscar(ct)) {
						System.out.println(ct.getNome() + " - " + produto.getNome());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}

	}

}
