package com.tcs.jdbc_callable_statement_crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tcs.jdbc_callable_statement_crud.dao.CustomerDao;
import com.tcs.jdbc_callable_statement_crud.entity.Customer;

public class CustomerController {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		CustomerDao customerDao= new CustomerDao();
		
		System.out.println("Enter your choice...");
		System.out.println("1.Create new Customer..\n2.Delete Customer By Id\n3.Display all Customers\n4.Display Customer By Id\n5.UpdateCustomerNameById");
		
		int choice= sc.nextInt();
		
		switch(choice)
		{
			case 1:{
				
				System.out.println("Enter Id ..");
				int id= sc.nextInt();
				sc.nextLine();
				System.out.println("Enter name...");
				String name= sc.nextLine();
				System.out.println("Enter email");
				String email= sc.nextLine();
				System.out.println("Enter Address");
				String address= sc.nextLine();
				
				Customer customer= customerDao.saveCustomerDao(new Customer(id,name,email,address));
				
				System.out.println(customer);
				
			}break;
			case 2:{
				System.out.println("Enter the id...");
				int id= sc.nextInt();
				customerDao.deleteCustomerByIdDao(id);
			}break;
			case 3: {
				System.out.println("All Customers are: ");
				
				List<Customer> l1= new ArrayList<>();
				
				 l1= customerDao.displayAllCustomersDao(l1);
				
				for(Customer x: l1)
				{
					System.out.println(x);
				}
			}break;
			case 4: {
				System.out.println("Enter the Id");
				int id= sc.nextInt();
				
				Customer customer= customerDao.displayCustomerByIdDao(id);
				
				System.out.println(customer);
			}break;
			case 5:{
				System.out.println("Enter the Id");
				int id= sc.nextInt();
				sc.nextLine();
				System.out.println("Enter new name");
				String name= sc.nextLine();
				
				customerDao.updateCustomerNameByIdDao(id,name);
				
				System.out.println("Updated Customer details ->");
				
				System.out.println(customerDao.displayCustomerByIdDao(id));
				
			}
			
			
		}
		
	}

}
