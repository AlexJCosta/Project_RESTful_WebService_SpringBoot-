package br.com.restserviceexample.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.restserviceexample.model.Product;

public class ProductDAO {
	
private Connection connection;
	
	public ProductDAO() throws RuntimeException {
		this.connection = new ConFactory().getConnection();
	}
	
	public void addProduct(Product product) throws RuntimeException{
		String sql = "insert into product " + " values (?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
