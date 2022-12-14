import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {

			PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");

			stm.execute();

			ResultSet rst = stm.getResultSet();

			while (rst.next()) {
				Integer id = rst.getInt("ID");
				System.out.print(id + " ");
				String nome = rst.getNString("NOME");
				System.out.print(nome + " ");
				String descricao = rst.getString("DESCRICAO");
				System.out.print(descricao + " ");
				System.out.println();
			}

		}

	}

}
