package loja_virtual_repository;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource data;
	
	public ConnectionFactory() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?createDatabaseIfNotExist=true&serverTimezone=UTC");
		dataSource.setUser("root");
		dataSource.setPassword("N@do1709");
		
		dataSource.setMaxPoolSize(15);
		
		this.data = dataSource;
	}

	public Connection recuperarConexao() throws SQLException {
		return this.data.getConnection();
	}
}
