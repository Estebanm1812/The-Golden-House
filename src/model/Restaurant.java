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
		
		setIngredientsList(new ArrayList<Ingredient>());
		
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
	public boolean addUser(String name, String lastName, String identificatorNumber, String userName, String password) {
		
		User user1 = new User(name, lastName, identificatorNumber, userName, password);
		
		boolean found = false;
		
		for(int i=0; i < userList.size() && (found==false);i++) {
		
			if((userList.get(i).getNames().equals(name))&&(userList.get(i).getLastNames().equals(lastName))&&(userList.get(i).getIdentificatorNumber().equals(identificatorNumber))) {
			
				found = true;
				
			}
			
			
		}
		if(found==true) {
		
		userList.add(user1);
		}
		return found;
		
	}
	public boolean addIngredient(String name, String creator) {
		
		boolean avaible = true; 
		
		for(int i=0; i <ingredientsList.size()&& (avaible==true);i++) {
		
			if(ingredientsList.get(i).getIngredintName().equals(name)) {
			
				avaible = false;
			}
			
		}
		if(avaible == true){
			
			Ingredient ingredient = new Ingredient(name, creator);
			
			ingredientsList.add(ingredient);
		}
		return avaible;
	}
	public boolean findUser(String userName, String password) {
		
		boolean answer = false;
		
		for(int i=0; i < userList.size() && (answer==false);i++) {
		
			if((userList.get(i).getUserName().equals(userName)) && (userList.get(i).getPassword().equals(password))) {
				
				answer = true;
			}
	
		}
		return answer;
	}
	public ArrayList<Ingredient> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(ArrayList<Ingredient> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
	
	
	
}
