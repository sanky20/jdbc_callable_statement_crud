package com.tcs.jdbc_callable_statement_crud.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.tcs.jdbc_callable_statement_crud.connection.CustomerConnection;
import com.tcs.jdbc_callable_statement_crud.entity.Customer;

public class CustomerDao {

	Connection connection = CustomerConnection.getCustomerConnection();

	public Customer saveCustomerDao(Customer customer) {
		try {
			CallableStatement call = connection.prepareCall("call saveCustomerDetails(?,?,?,?)");
			call.setInt(1, customer.getId());
			call.setString(2, customer.getName());
			call.setString(3, customer.getEmail());
			call.setString(4, customer.getAddress());

			int a = call.executeUpdate();

			System.out.println(".....");

			System.out.println("No of row affected " + a);

			return customer;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public int deleteCustomerByIdDao(int id) {
		try {
			CallableStatement call = connection.prepareCall("call deleteCustomerById(?)");
			call.setInt(1, id);

			int a = call.executeUpdate();

			System.out.println("No of rows affected " + a);

			return a;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	public List<Customer> displayAllCustomersDao(List<Customer> l1) {
		try {
			CallableStatement call = connection.prepareCall("call displayAllCustomers()");
			ResultSet st = call.executeQuery();

			while (st.next()) {

				int id = st.getInt(1);
				String name = st.getString(2);
				String email = st.getString(3);
				String address = st.getString(4);
				l1.add(new Customer(id, name, email, address));
			}

			return l1;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Customer displayCustomerByIdDao(int customerId) {	
		try {
			CallableStatement call= connection.prepareCall("call displayCustomerById(?)");
			call.setInt(1, customerId);
			ResultSet st= call.executeQuery();
			st.next();	
			int id= st.getInt(1);
			String name= st.getString(2);
			String email= st.getString(3);
			String address= st.getString(4);
			
			return new Customer(id,name,email,address);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	public void updateCustomerNameByIdDao(int id, String name)
	{
		try {
			CallableStatement call= connection.prepareCall("call updateCustomerNameById(?,?)");
			call.setInt(1, id);
			call.setString(2, name);
			
			int a= call.executeUpdate();
			
			System.out.println("No of rows affected "+a);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	
}
