package com.tcs.jdbc_callable_statement_crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;



public class CustomerConnection {
	
	public static Connection getCustomerConnection()
	{
		try {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-a5","root","mypets@3");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
