package com.zee.zee5app.utils;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import java.sql.SQLException;
import java.util.Properties;

import org.springframework.stereotype.Component;
@Component
public class DBUtils {
	Connection connection = null;
	private DBUtils() throws IOException {
		// TODO Auto-generated constructor stub
		properties = loadProperties();
	}
//	Properties properties;
	private static DBUtils dbutils;
	public static DBUtils getInstance() throws IOException {
		if(dbutils ==null)
			//but we refer using interface only i.e.
			//repository = new UserRepository()
			// we can only access interface methods
			
			// this will use functionalities of the interface and both class only
			dbutils = new DBUtils();
		return dbutils;
	}
	
	public Connection	getConnection() {
		// the connection with Database
		Connection connection = null;
		
		try {
			properties = loadProperties();
			if (connection == null || connection.isClosed()) {
		     connection =	DriverManager.getConnection(properties.getProperty("jdbc.url"),properties.getProperty("jdbc.username"),
					properties.getProperty("jdbc.password"));
			

			connection.setAutoCommit(false);}
//			System.out.println(properties);
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Properties properties ;
	private Properties loadProperties() throws IOException {
		// read the properties file
		
	InputStream inputStream =	
			DBUtils.class.getClassLoader()
			.getResourceAsStream("application.properties");
	
	Properties properties = new Properties();
	properties.load(inputStream);
	// it will read the properties internally.
	
	return properties;
	
	}
}
