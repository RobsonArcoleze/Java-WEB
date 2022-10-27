import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException{
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement stm = connection.createStatement();
		Boolean resultado = stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		System.out.println(resultado);
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.print(id + " ");
			String nome = rst.getNString("NOME");
			System.out.print(nome + " ");
			String descricao = rst.getString("DESCRICAO");
			System.out.print(descricao + " ");
			System.out.println();
		}
		System.out.println("Fechando conexão");

		connection.close();

	}

}
