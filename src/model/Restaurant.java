package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	public final static String CUSTOMERS_SAVE_PATH_FILE = "data/customers.csv";
	
	public final static String USERS_SAVE_PATH_FILE = "data/users.csv";
	
	public final static String EMPLOYEERS_SAVE_PATH_FILE = "data/employers.csv";
	
	public final static String DELIVERS_SAVE_PATH_FILE = "data/delivers.csv";
	
	private List<Customer> customersList;
	
	private List<Employee> employersList;
	
	private List<Ingredient> ingredientsList;
	
	private List<User> userList;
	
	private List<Delivery> deliveriesList;
	
	
	public Restaurant() {
		
		customersList = new ArrayList<Customer>();
		
		employersList = new ArrayList<Employee>();
		
		setIngredientsList(new ArrayList<Ingredient>());
		
		userList = new ArrayList<User>();
		
		deliveriesList = new ArrayList<Delivery>();
		
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
	public List<Ingredient> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(ArrayList<Ingredient> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
	public List<Employee> getEmployeeList() {
		return employersList;
	}
	public void setEmployeeList(ArrayList<Employee> employersList) {
		this.employersList = employersList;
	}
	public void saveCustomerData() throws FileNotFoundException, IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CUSTOMERS_SAVE_PATH_FILE));
		
		oos.writeObject(customersList);
		oos.close();
	}
	public void saveEmployeeData() throws FileNotFoundException, IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EMPLOYEERS_SAVE_PATH_FILE));
		
		oos.writeObject(employersList);
		oos.close();
	}
	public void saveUsersData() throws FileNotFoundException, IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_SAVE_PATH_FILE));
		
		oos.writeObject(userList);
		oos.close();
	}
	public void saveDeliversData() throws FileNotFoundException, IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DELIVERS_SAVE_PATH_FILE));
		
		oos.writeObject(deliveriesList);
		oos.close();
	}
	public void importEmployee(String fileName) throws IOException{
		    BufferedReader br = new BufferedReader(new FileReader(fileName));
		    String line = br.readLine();
		    while(line!=null){
		      String[] parts = line.split(";");
		      addEmployee(parts[0],parts[1],parts[2]);
		      line = br.readLine();
		    }
		    br.close();
		  }
	public void importDelivery(String fileName) throws IOException{
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line = br.readLine();
	    while(line!=null){
	      String[] parts = line.split(";");
	      addDelivery(parts[0],parts[1],parts[2]);
	      line = br.readLine();
	    }
	    br.close();
	  }
	private void addDelivery(String string, String string2, String string3) {
	
		
	}
	public void importUsers(String fileName) throws IOException{
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line = br.readLine();
	    while(line!=null){
	      String[] parts = line.split(";");
	      addUser(parts[0],parts[1],parts[2], parts[3], parts[4]);
	      line = br.readLine();
	    }
	    br.close();
	  }
	public void importCustomers(String fileName) throws IOException{
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line = br.readLine();
	    while(line!=null){
	      String[] parts = line.split(";");
	      addCustomer(parts[0],parts[1],parts[2], parts[3], parts[4], parts[5]);
	      line = br.readLine();
	    }
	    br.close();
	  }

	public void loadEmployeeData() throws IOException, ClassNotFoundException{
	    File f = new File(EMPLOYEERS_SAVE_PATH_FILE);
	    if(f.exists()){
	      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
	      employersList = (List<Employee>)ois.readObject();
	      ois.close();
	    }
	  }
	public void loadUserData() throws IOException, ClassNotFoundException{
	    File f = new File(USERS_SAVE_PATH_FILE);
	    if(f.exists()){
	      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
	      userList = (List<User>)ois.readObject();
	      ois.close();
	    }
	  }
	public void loadDeliveryData() throws IOException, ClassNotFoundException{
	    File f = new File(DELIVERS_SAVE_PATH_FILE);
	    if(f.exists()){
	      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
	      deliveriesList = (List<Delivery>)ois.readObject();
	      ois.close();
	    }
	  }
	public void loadCustomersData() throws IOException, ClassNotFoundException{
	    File f = new File(CUSTOMERS_SAVE_PATH_FILE);
	    if(f.exists()){
	      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
	      customersList = (List<Customer>)ois.readObject();
	      ois.close();
	    }
	  }
	
}
