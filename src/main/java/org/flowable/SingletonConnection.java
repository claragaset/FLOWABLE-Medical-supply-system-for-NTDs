package org.flowable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonConnection {
	
	private static SingletonConnection instance = new SingletonConnection();
	
	private Connection connection;
	private String url;
	private String user;
	private String password;
	
	private SingletonConnection() {
		url = "jdbc:postgresql://localhost:5432/data";
		user = "postgres";
		password = "postgres";	
	}
	
	public static SingletonConnection getInstance() {
		return instance;
	}

	public ResultSet executeQuery (String query) throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, password);
			Statement st = connection.createStatement();
			return st.executeQuery(query);
		}
		catch (SQLException ex) { return null; }
		finally {
			connection.close();
		}
	}
}
