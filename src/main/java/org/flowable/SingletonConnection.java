package org.flowable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingletonConnection {
	
	private static SingletonConnection instance = null;
	
	private Connection connection;
	Statement st;
    ResultSet rs;
	private String url;
	private String user;
	private String password;
	
	private SingletonConnection() {
		url = "jdbc:postgresql://localhost:5432/data";
		user = "postgres";
		password = "postgres";	
	}
	
	public static SingletonConnection getInstance() {
		if (instance == null) { instance = new SingletonConnection(); }
		return instance;
	}

	public ResultSet executeQuery (String query) throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, password);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			return rs;
		}
		catch (SQLException ex) { return null; }
		finally {
			rs.close();
			st.close();
			connection.close();
		}
	}
}
