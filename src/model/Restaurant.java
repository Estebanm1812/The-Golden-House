package model;

import java.util.ArrayList;

public class Restaurant {
	
	private ArrayList<Customer> customersList;
	
	private ArrayList<Employee> employersList;
	
	private ArrayList<Ingredient> ingredientsList;
	
	private ArrayList<User> userList;
	
	
	public Restaurant() {
		
		customersList = new ArrayList<Customer>();
		
		employersList = new ArrayList<Employee>();
		
		ingredientsList = new ArrayList<Ingredient>();
		
		userList = new ArrayList<User>();
		
	}
	public void addCustomer(String name, String lastName, String id, String addres, String phone, String comment) {
		
		Customer customer1 = new Customer(name, lastName, id, addres, phone,comment);
		
		
		
		customersList.add(customer1);
		
		
	}
	public void addEmployee(String name, String lastName, String identificatorNumber) {
		
		Employee em1 = new Employee(name, lastName, identificatorNumber);
		
		employersList.add(em1);
		
	}
	public void addUser(String name, String lastName, String identificatorNumber, String userName, String password) {
		
		User user1 = new User(name, lastName, identificatorNumber, userName, password);
		
		userList.add(user1);
		
	}
	
	
	
}
