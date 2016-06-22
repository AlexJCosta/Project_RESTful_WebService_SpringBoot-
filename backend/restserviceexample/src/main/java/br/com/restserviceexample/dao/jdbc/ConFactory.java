package br.com.restserviceexample.dao.jdbc;

import java.sql.*;

public class ConFactory {
	
	public Connection getConnection() throws RuntimeException {
		
		try {
			return DriverManager.getConnection("jdbc:mysql://50.40.55.6/", "root", "53nh4615243");
		
		}catch (SQLException e) {
			throw new RuntimeException(e);
			
		}
	}
	
}
