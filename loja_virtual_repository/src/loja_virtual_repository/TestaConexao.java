package loja_virtual_repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost/loja_virtual?createDatabaseIfNotExist=true&serverTimezone=UTC", "root", "N@do1709");
		
		System.out.println("Fechando conexão!!");
		connection.close();
	}
}
