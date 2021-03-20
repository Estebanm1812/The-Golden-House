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
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	public final static String CUSTOMERS_SAVE_PATH_FILE = "data/customers.txt";
	
	public final static String USERS_SAVE_PATH_FILE = "data/users.txt";
	
	public final static String EMPLOYEERS_SAVE_PATH_FILE = "data/employers.txt";
	
	public final static String DELIVERS_SAVE_PATH_FILE = "data/delivers.txt";
	
	public final static String INGREDIENTS_SAVE_PATH_FILE = "data/ingredients.txt";
	
	public final static String PRODUCTS_SAVE_PATH_FILE = "data/products.txt";
	
	private List<Customer> customersList;
	
	private List<Employee> employersList;
	
	private List<Ingredient> ingredientsList;
	
	private List<User> userList;
	
	private List<Delivery> deliveriesList;
	
	private List<Product> productList;
	
	
	public Restaurant(){
		
		customersList = new ArrayList<Customer>();
		
		employersList = new ArrayList<Employee>();
		
		ingredientsList = new ArrayList<Ingredient>();
		
		userList = new ArrayList<User>();
		
		deliveriesList = new ArrayList<Delivery>();
		
		productList = new ArrayList<Product>();
	}
	public void addCustomer(String name, String lastName, String id, String addres, String phone, String comment) throws FileNotFoundException, IOException {
		
		Customer customer1 = new Customer(name, lastName, id, addres, phone,comment);
		
		customersList.add(customer1);
			
		saveCustomerData();
	}
	public void addEmployee(String name, String lastName, String identificatorNumber) throws FileNotFoundException, IOException {
		
		Employee em1 = new Employee(name, lastName, identificatorNumber);
		
		employersList.add(em1);
		
		saveEmployeeData();
		
	}
	public boolean addUser(String name, String lastName, String identificatorNumber, String userName, String password) throws FileNotFoundException, IOException {
		
		User user1 = new User(name, lastName, identificatorNumber, userName, password);
		
		boolean found = false;
		
		for(int i=0; i < userList.size() && (found==false);i++) {
		
			if((userList.get(i).getNames().equals(name))&&(userList.get(i).getLastNames().equals(lastName))&&(userList.get(i).getIdentificatorNumber().equals(identificatorNumber))) {
			
				found = true;
				
			}
			
			
		}
		if(found==true) {
		
		userList.add(user1);
		saveUsersData();
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
	public void saveIngredientsData() throws FileNotFoundException, IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INGREDIENTS_SAVE_PATH_FILE));
		
		oos.writeObject(ingredientsList);
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
	public void importEmployee() throws IOException{
		    BufferedReader br = new BufferedReader(new FileReader(EMPLOYEERS_SAVE_PATH_FILE));
		    String line = br.readLine();
		    while(line!=null){
		      String[] parts = line.split(";");
		      addEmployee(parts[0],parts[1],parts[2]);
		      line = br.readLine();
		    }
		    br.close();
		  }
	public void importIngredients(String fileName) throws IOException{
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line = br.readLine();
	    while(line!=null){
	      String[] parts = line.split(";");
	      addIngredient(parts[0],parts[1]);
	      line = br.readLine();
	    }
	    br.close();
	  }
	public void importDeliver() throws IOException{
	    BufferedReader br = new BufferedReader(new FileReader(DELIVERS_SAVE_PATH_FILE));
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
	public void loadData(String path) throws IOException, ClassNotFoundException{
		
		File f;
		
		if(path.equals(CUSTOMERS_SAVE_PATH_FILE)) {
		
		f = new File(CUSTOMERS_SAVE_PATH_FILE);
			
			if(f.exists()) {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				customersList = (List)ois.readObject();
				ois.close();
			}
		}else if(path.equals(EMPLOYEERS_SAVE_PATH_FILE)) {
			
			f = new File(EMPLOYEERS_SAVE_PATH_FILE);
			
			if(f.exists()) {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				employersList = (List)ois.readObject();
				ois.close();
			}
		}else if(path.equals(USERS_SAVE_PATH_FILE)) {
			
			f = new File(USERS_SAVE_PATH_FILE);
			
			if(f.exists()) {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				userList = (List)ois.readObject();
				ois.close();
			}
		}else if(path.equals(DELIVERS_SAVE_PATH_FILE)) {
		
		f = new File(DELIVERS_SAVE_PATH_FILE);	
			
			if(f.exists()) {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				deliveriesList = (List)ois.readObject();
				ois.close();
			}
		}else if(path.equals(INGREDIENTS_SAVE_PATH_FILE)) {
			
			f = new File(INGREDIENTS_SAVE_PATH_FILE);
				
			if(f.exists()) {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				ingredientsList = (List)ois.readObject();
				ois.close();
			}	
			
		}else if(path.equals(PRODUCTS_SAVE_PATH_FILE)) {
			
			f = new File(PRODUCTS_SAVE_PATH_FILE);
				
				if(f.exists()) {
					
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
					productList = (List)ois.readObject();
					ois.close();
				}	
				
		}	
	}
	
	public void loadIngredientsData() throws IOException, ClassNotFoundException{
	    File f = new File(INGREDIENTS_SAVE_PATH_FILE);
	    if(f.exists()){
	      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
	      ingredientsList = (List<Ingredient>)ois.readObject();
	      ois.close();
	    }
	  }
	public void exportCustomerData(String fileName) throws FileNotFoundException{
	    PrintWriter pw = new PrintWriter(fileName);

	    for(int i=0;i<customersList.size();i++){
	      Customer myCustomer = customersList.get(i);
	      pw.println(myCustomer.getNames()+";"+myCustomer.getLastNames()+";"+myCustomer.getIdentificatorNumber()+";"+myCustomer.getAddres()+";"+myCustomer.getPhoneNumber()+";"+myCustomer.getComment());
	    }

	    pw.close();
	  }
	public void exportEmployeeData(String fileName) throws FileNotFoundException{
	    PrintWriter pw = new PrintWriter(fileName);

	    for(int i=0;i<employersList.size();i++){
	      Employee myEmployee = employersList.get(i);
	      pw.println(myEmployee.getNames()+";"+myEmployee.getLastNames()+";"+myEmployee.getIdentificatorNumber());
	    }

	    pw.close();
	  }
	public void exportUserData(String fileName) throws FileNotFoundException{
	    PrintWriter pw = new PrintWriter(fileName);

	    for(int i=0;i<userList.size();i++){
	      User myUser = userList.get(i);
	      pw.println(myUser.getNames()+";"+myUser.getLastNames()+";"+myUser.getIdentificatorNumber()+";"+myUser.getUserName()+";"+myUser.getPassword());
	    }

	    pw.close();
	  }
	public void exportIngredientData(String fileName) throws FileNotFoundException{
	    PrintWriter pw = new PrintWriter(fileName);

	    for(int i=0;i<ingredientsList.size();i++){
	      Ingredient myIngredient = ingredientsList.get(i);
	      pw.println(myIngredient.getIngredintName()+";"+myIngredient.getCreator()+";"+myIngredient.getLastModifie());
	    }

	    pw.close();
	  }
	public boolean findCustomer(String id, String phone) {
		
		boolean found = false;
		
		for(int i=0; i < customersList.size() && (found==false);i++) {
		
			if(((customersList.get(i).getIdentificatorNumber().equals(id))&&(customersList.get(i).getPhoneNumber().equals(phone)))){
			
				found = true;
				
				}
			}
		return found;
	}
	public boolean foundIngredient(String name) {
		
		boolean found = false;
		
		for(int i=0; i < ingredientsList.size();i++) {
		
			if(ingredientsList.get(i).getIngredintName().equals(name)) {
			
			}	
		}
		return found;
	}
	
}
