package br.com.alura.bytebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
	public Connection recuperarConexao() {
		
		 try {
	            return createDataSource().getConnection();

	        } catch (SQLException e) {
	            System.out.println(e);
	            throw new RuntimeException(e);
	        }
	}
	
    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/byte_bank?createDatabaseIfNotExist=true&serverTimezone=America/Sao_Paulo&useSSl=false");
        config.setUsername("root");
        config.setPassword("N@do1709");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
	 
}
