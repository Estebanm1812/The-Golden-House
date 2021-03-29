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
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	public final static String CUSTOMERS_SAVE_PATH_FILE = "data/customers.decade";
	
	public final static String USERS_SAVE_PATH_FILE = "data/users.decade";
	
	public final static String EMPLOYEERS_SAVE_PATH_FILE = "data/employers.decade";
	
	public final static String DELIVERS_SAVE_PATH_FILE = "data/delivers.decade";
	
	public final static String INGREDIENTS_SAVE_PATH_FILE = "data/ingredients.decade";
	
	public final static String PRODUCTS_SAVE_PATH_FILE = "data/products.decade";
	
	public final static String PRODUCT_TYPE_SAVE_PATH_FILE = "data/productType.decade";
	
	private List<Customer> customersList;
	
	private List<Employee> employersList;
	
	private List<Ingredient> ingredientsList;
	
	private List<User> userList;
	
	private List<Delivery> deliveriesList;
	
	private List<Product> productList;
	
	private List<ProductType> productTypeList;
	
	private User currentUser;
	
	
	public Restaurant() throws ClassNotFoundException, IOException{
		
		customersList = new ArrayList<Customer>();
		
		employersList = new ArrayList<Employee>();
		
		ingredientsList = new ArrayList<Ingredient>();
		
		userList = new ArrayList<User>();
		
		deliveriesList = new ArrayList<Delivery>();
		
		productList = new ArrayList<Product>();
		
		productTypeList = new ArrayList<ProductType>();
		
	
		
	}
	public String getUsersSavePath() {
		return USERS_SAVE_PATH_FILE;
	}
	public String getCustomersSavepath() {
		return CUSTOMERS_SAVE_PATH_FILE;
	}
	public String getEmployeeSavePath() {
		return EMPLOYEERS_SAVE_PATH_FILE;
	}
	public String getProductSavePath() {
		return PRODUCTS_SAVE_PATH_FILE;
	}
	public String getIngredientsSavePath() {
		return INGREDIENTS_SAVE_PATH_FILE;
	}
	public String getDeliverySavePath() {
		return DELIVERS_SAVE_PATH_FILE;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User name) {
		currentUser = name;
	}
	
	
	public void addCustomer(String name, String lastName, String id, String addres, String phone, String comment) throws FileNotFoundException, IOException {
		
		Customer customer1 = new Customer(name, lastName, id, addres, phone,comment);
		
		customersList.add(customer1);
			
		saveData(CUSTOMERS_SAVE_PATH_FILE);
		
		
	}
	public void addEmployee(String name, String lastName, String identificatorNumber) throws FileNotFoundException, IOException {
		
		Employee em1 = new Employee(name, lastName, identificatorNumber);
		
		employersList.add(em1);
		
		saveData(EMPLOYEERS_SAVE_PATH_FILE);
		
	}
	public void addUser(String name, String lastName, String identificatorNumber, String userName, String password) throws FileNotFoundException, IOException {
		
		User user1 = new User(name, lastName, identificatorNumber, userName, password);
	
		userList.add(user1);
		saveData(USERS_SAVE_PATH_FILE);
		
		
	}
	public void addIngredient(String name, String creator) throws FileNotFoundException, IOException {
		
			
		Ingredient ingredient = new Ingredient(name, creator);
		
		ingredientsList.add(ingredient);
		
		for(int i=0; i < ingredientsList.size();i++) {
		
			
			for(int j=0; j < ingredientsList.size()-1;j++) {
			
				if(ingredientsList.get(j).getCode()>ingredientsList.get(j+1).getCode()) {
				
					Ingredient temp = ingredientsList.get(i);
					ingredientsList.set(j,ingredientsList.get(j+1));
					ingredientsList.set(j+1, temp);
				}
			}	
		}	
		
		saveData(INGREDIENTS_SAVE_PATH_FILE);
		
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
	public List<Product> getProductList(){
		return productList;
	}
	public void setProductList(List<Product> list) {
		productList = list;
	}
	public List<Customer> getCustomerList(){
		return customersList;
	}
	public void setCustomerList(List<Customer> list) {
		customersList = list;
	}
	public List<User> getUserList(){
		return userList;
	}
	public List<ProductType> getProductTypeList(){
		return productTypeList;
	}
	
	public void setEmployeeList(ArrayList<Employee> employersList) {
		this.employersList = employersList;
	}
	public void saveData(String path) throws FileNotFoundException, IOException {
		
		ObjectOutputStream oos;
		
		if(path.equals(CUSTOMERS_SAVE_PATH_FILE)) {
		
		oos = new ObjectOutputStream(new FileOutputStream(CUSTOMERS_SAVE_PATH_FILE));
			
			oos.writeObject(customersList);
			oos.close();	
		}else if(path.equals(INGREDIENTS_SAVE_PATH_FILE)) {
			
		oos = new ObjectOutputStream(new FileOutputStream(INGREDIENTS_SAVE_PATH_FILE));
		
		oos.writeObject(ingredientsList);
		oos.close();
			
		}else if(path.equals(EMPLOYEERS_SAVE_PATH_FILE)) {
			
			oos = new ObjectOutputStream(new FileOutputStream(EMPLOYEERS_SAVE_PATH_FILE));
			
			oos.writeObject(employersList);
			oos.close();
		}else if(path.equals(USERS_SAVE_PATH_FILE)) {
			
		oos = new ObjectOutputStream(new FileOutputStream(USERS_SAVE_PATH_FILE));
		
		oos.writeObject(userList);
		oos.close();
			
		}else if(path.equals(DELIVERS_SAVE_PATH_FILE)) {
			
			oos = new ObjectOutputStream(new FileOutputStream(DELIVERS_SAVE_PATH_FILE));
			
			oos.writeObject(deliveriesList);
			oos.close();
		}else if(path.equals(PRODUCTS_SAVE_PATH_FILE)) {
			
			oos = new ObjectOutputStream(new FileOutputStream(PRODUCTS_SAVE_PATH_FILE));
			oos.writeObject(productList);
			oos.close();
		}else if(path.equals(PRODUCT_TYPE_SAVE_PATH_FILE)) {
			
			oos = new ObjectOutputStream(new FileOutputStream(PRODUCT_TYPE_SAVE_PATH_FILE));
			oos.writeObject(productTypeList);
			oos.close();
		}	
	}
	
	
	public void importEmployee(String file) throws IOException{
		    BufferedReader br = new BufferedReader(new FileReader(file));
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
	public void importDeliver(String file) throws IOException{
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    String line = br.readLine();
	    while(line!=null){
	      String[] parts = line.split(";");
	      addDelivery(parts[0],parts[1],parts[2]);
	      line = br.readLine();
	    }
	    br.close();
	  }
	public void addDelivery(String string, String string2, String string3) {
	
		
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
	@SuppressWarnings("unchecked")
	public void loadData(String path) throws IOException, ClassNotFoundException{
		
		File f;
		
		if(path.equals(CUSTOMERS_SAVE_PATH_FILE)) {
		
		f = new File(CUSTOMERS_SAVE_PATH_FILE);
			
			if(f.exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CUSTOMERS_SAVE_PATH_FILE));
				customersList = (List<Customer>)ois.readObject();
				ois.close();
			}else {
				
			}
		}else if(path.equals(EMPLOYEERS_SAVE_PATH_FILE)) {
			
			f = new File(EMPLOYEERS_SAVE_PATH_FILE);
			
			if(f.exists()) {
				
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				employersList = (List<Employee>)ois.readObject();
				ois.close(); 
			}
			
		}else if(path.equals(USERS_SAVE_PATH_FILE)) {
			
			f = new File(USERS_SAVE_PATH_FILE);
			
			if(f.exists()) {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				userList = (List<User>)ois.readObject();
				ois.close();
			}
		}else if(path.equals(DELIVERS_SAVE_PATH_FILE)) {
		
		f = new File(DELIVERS_SAVE_PATH_FILE);	
			
			if(f.exists()) {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DELIVERS_SAVE_PATH_FILE));
				deliveriesList = (List<Delivery>)ois.readObject();
				ois.close();
			}
		}else if(path.equals(INGREDIENTS_SAVE_PATH_FILE)) {
			
			f = new File(INGREDIENTS_SAVE_PATH_FILE);
				
			if(f.exists()) {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(INGREDIENTS_SAVE_PATH_FILE));
				ingredientsList = (List<Ingredient>)ois.readObject();
				ois.close();
			}	
			
		}else if(path.equals(PRODUCTS_SAVE_PATH_FILE)) {
			
			f = new File(PRODUCTS_SAVE_PATH_FILE);
				
				if(f.exists()) {
					
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCTS_SAVE_PATH_FILE));
					productList = (List<Product>)ois.readObject();
					ois.close();
				}	
				
		}else if(path.equals(PRODUCT_TYPE_SAVE_PATH_FILE)) {	
		
			f = new File(PRODUCT_TYPE_SAVE_PATH_FILE);
			
			if(f.exists()) {
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCT_TYPE_SAVE_PATH_FILE));
				productTypeList = (List<ProductType>)ois.readObject();
				ois.close();
			}	
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
	public void exportProductData(String fileName) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(fileName);
		
		for(int i=0; i < productList.size();i++) {
		Product myProduct = productList.get(i);
		pw.println(myProduct.getName()+";"+myProduct.getPrices()+";"+myProduct.getSize()+";"+myProduct.getAllIngredients());
			
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
	public boolean findIngredient(String name) {
		
		boolean found = false;
		
		String name2 = name.trim();
		
		for(int i=0; i < ingredientsList.size();i++) {
		
			if(ingredientsList.get(i).getIngredintName().equals(name2)) {
			
				found = true;
			}	
		}
		return found;
	}
	public boolean findEmployee(String id) {
		
		boolean found = false;
		
		for(int i=0; i < employersList.size() && found==true;i++) {
		
			if((employersList.get(i).getIdentificatorNumber().equals(id))&&(employersList.get(i).getState().equals("ACTIVO"))) {
			
				found = true;
				
				}
			}	
		return found;
		
	}
	public boolean findEmployee(String name, String lastname, String id) {
		
		boolean found = false;
		
		
		for(int i=0; i < employersList.size() && found==false;i++) {	
		
		if( (employersList.get(i).getNames().equals(name))&&(employersList.get(i).getLastNames().equals(lastname))&&(employersList.get(i).getIdentificatorNumber().equals(id))) {
					
			
			found = true;	
			}
		}	
		return found;
	}
	public boolean findProductType(String name) {
		
		boolean found = false;
		
			if(productTypeList.size()!=0) {
		
		for(int i=0; i < productTypeList.size() && (found==false);i++) {
		
			if(productTypeList.get(i).getName().equals(name)) {
		
				found = true;
			}
		}
			}
		return found;
	}
	public String getProductTypeSavePanth() {
		return PRODUCT_TYPE_SAVE_PATH_FILE;

	}
	public void addProductType(String name) throws FileNotFoundException, IOException {
		
		ProductType pt1 = new ProductType(name,getCurrentUser().getNames());
		
		productTypeList.add(pt1);
		saveData(PRODUCT_TYPE_SAVE_PATH_FILE);
	}
	public boolean findProduct(String name,String [] ingredients, double price) {
		
		boolean found = false;
		
			if(productList.size()!=0) {
		
		for(int i=0; i < productList.size() && found==false;i++) {
		
			if((productList.get(i).getIngredients().equals(ingredients))  && (productList.get(i).getPrices()==price)) {
			
				found = true;
			
			}
		}
			}
		return found;
	}
	public void addProduct(String name, String [] ingredients,String size, double price) throws FileNotFoundException, IOException {
		
		Product product1 = new Product(name,price,size,ingredients);
		productList.add(product1);
		saveData(PRODUCTS_SAVE_PATH_FILE);
	}
	public int findUserPosition(String user1) {
		
		int pos = 0;
		
		boolean found = false;
		
		for(int i=0; i < userList.size() && found==false;i++) {
		
			if(userList.get(i).getUserName().equals(user1)) {
			
				pos = i;
				found = true;
			}
		}
		return pos;
	}
}
