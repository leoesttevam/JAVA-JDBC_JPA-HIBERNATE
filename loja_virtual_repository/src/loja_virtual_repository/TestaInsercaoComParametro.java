package loja_virtual_repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		connection.setAutoCommit(false);
		
		try(PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			) {
					
			adicionarVariavel("SmartTV", "45 Polegadas", stm);
			adicionarVariavel("Radio", "Radio digital", stm);
			
			connection.commit();
			
			stm.close();
			connection.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
		connection.close();
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		if(nome.equals(nome)) {
			throw new RuntimeException("Não foi possivel adicionar o produto");
		}
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		
		rst.close();
	}
}
