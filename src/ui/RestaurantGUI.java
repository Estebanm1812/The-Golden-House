package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import model.Customer;
import model.Employee;
import model.Ingredient;
import model.Restaurant;
import model.User;


public class RestaurantGUI {
	
	 @FXML
	private BorderPane mainMenuPane;
	 
	 @FXML
	private BorderPane customersPane;
 
    @FXML
    private BorderPane loginPane;
    
    @FXML
    private BorderPane userCreationPane;
		
    @FXML
    private BorderPane employeeCreationPane;
    
    @FXML
    private BorderPane firstPane;
    
    @FXML
    private BorderPane ingredientListPane;
	
    @FXML
    private BorderPane pane;
    
    @FXML
    private BorderPane CreateIngredientPane;
    
    @FXML
    private BorderPane userCreationMainPane;
    
    @FXML
    private TableView<Ingredient> ingredientsList;
    
    @FXML
    private BorderPane employeeListPane;

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> employeeNameTable;

    @FXML
    private TableColumn<Employee, String> employeeLastNameTable;

    @FXML
    private TableColumn<Employee, String> employeeIDTable;
    
    @FXML
    private BorderPane customerCreationPane;
    
	private Restaurant restaurant;
	
	@FXML
    private TextField userCreationNameTxT;

    @FXML
    private TextField userCreationLastNameTxT;

    @FXML
    private TextField userCreationIdTxT;

    @FXML
    private TextField userCreationUserNameTxT;

    @FXML
    private TextField userCreationPasswordTxT;
    
    @FXML
    private TextField userLoginTxT;
    
    @FXML
    private TableColumn<Ingredient, String> ingredientNameTable;

    @FXML
    private TableColumn<Ingredient, String> ingredientStateTable;

    @FXML
    private TableColumn<Ingredient, String> ingredientCreatorTable;

    @FXML
    private TableColumn<Ingredient, String> ingredientLastModifiedTable;
    
    @FXML
    private TextField nameClientTxT;

    @FXML
    private TextField lastNameClientTxT;

    @FXML
    private TextField idClientTxT;

    @FXML
    private TextField addressClientTxT;

    @FXML
    private TextField phoneClientTxT;

    @FXML
    private TextField commentClientTxT;

    @FXML
    private TextField ingredientNameTxT;

    @FXML
    private PasswordField passwordLoginTxT;
    
    @FXML
    private TextField nameEmployeeCreationTxT;

    @FXML
    private TextField lastnameEmployeeCreationTxT;

    @FXML
    private TextField idEmployeeCreationTxT;
    
    @FXML
    private TableColumn<Customer, String> customerTableName;

    @FXML
    private TableColumn<Customer, String> customerTableLastnames;

    @FXML
    private TableColumn<Customer, String> customerTableID;

    @FXML
    private TableColumn<Customer, String> customerTableAddres;

    @FXML
    private TableColumn<Customer, String> customerTablePhone;
    
    @FXML
    private TableView<Customer> customerList;
    
    @FXML
    private BorderPane userListPane;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> userNameTable;

    @FXML
    private TableColumn<User, String> userLastNameTable;

    @FXML
    private TableColumn<User, String> userIDTable;

    @FXML
    private TableColumn<User, String> userUsernameTable;

   
	public RestaurantGUI(Restaurant restaurant) {
	
		this.restaurant = restaurant;
		
		
	}
	public BorderPane getPane() {
		return pane;
	}
	public void SetPane(BorderPane pane) {
		this.pane = pane;
	}
	@FXML
    public void login(ActionEvent event) throws IOException {
		
		FXMLLoader logInPane = new FXMLLoader(getClass().getResource("userLogin.fxml"));
		
		logInPane.setController(this);
		
		Parent root1 = logInPane.load(); 
		
		
		firstPane.getChildren().clear();
		firstPane.setCenter(root1);
	 
    }
	 @FXML
	 public void openUserCreationPane(ActionEvent event) throws IOException {

		 FXMLLoader createUserPane = new FXMLLoader(getClass().getResource("userCreationPane.fxml"));
			
			createUserPane.setController(this);
			
			Parent root1 = createUserPane.load(); 
			
			
			pane.getChildren().clear();
			pane.setCenter(root1);
		 
	    }
	 
	 @FXML
	 public void createUser(ActionEvent event) throws FileNotFoundException, IOException {
		 
		 String name = userCreationNameTxT.getText();
		 
		 String lastName = userCreationLastNameTxT.getText();
		 
		 String id = userCreationIdTxT.getText();
		 
		 String userName = userCreationUserNameTxT.getText();
		 
		 String password = userCreationPasswordTxT.getText();
		 
		 if((userCreationNameTxT.getText().equals("")||(userCreationPasswordTxT.getText().equals(""))||(userCreationIdTxT.getText().equals(""))||(userCreationUserNameTxT.getText().equals(""))||(userCreationPasswordTxT.getText().equals("")))) {
		 
			 Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Debe de llenar todos los datos");
				alert.showAndWait();
	    }else {
	    	boolean result = restaurant.findEmployee(name, lastName, id);
			 
			 if(result==false) {
			 
				 Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Los datos no concuerdon con un empleado activo");
					alert.showAndWait();
		    		
				 
				 
			 	}else {
			 		restaurant.addUser(name, lastName, id, userName, password);
			 		Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("El Usuario fue creado exitosamente");
					alert.showAndWait();	
			 	}
	    }
	 } 

	 @FXML
	 public void LogIn(ActionEvent event) throws IOException {

		 String userName = userLoginTxT.getText().trim();
		 
		 String password = passwordLoginTxT.getText().trim();
		 
		 
		 if((userName.equals(""))||(password.equals(""))) {
		 
			 Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Debe de llenar todos los datos");
				alert.showAndWait();
			 
			 
		 	}else {
		 		
		 		boolean enters = restaurant.findUser(userName, password);
		 		
		 			if(enters==true) {
		 		
		 			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));
		 			fxmlloader.setController(this);
		 			Parent mainMenu = fxmlloader.load();
		 			loginPane.getChildren().clear();
		 			loginPane.setCenter(mainMenu);
		 			restaurant.setCurrentUser(userName);
		 			}else {
		 				
		 				 Alert alert = new Alert(AlertType.INFORMATION);
		 				alert.setTitle("Information Dialog");
		 				alert.setHeaderText(null);
		 				alert.setContentText("El usuario y/o contraseña estan errones, por favor verificar");
		 				alert.showAndWait();
		 			 
		 				
		 			}	
		 	}
	    }
	 @FXML
	 public void createUserAccount(ActionEvent event) throws IOException {

		 FXMLLoader creationPane = new FXMLLoader(getClass().getResource("userCreationPane.fxml"));
			
			creationPane.setController(this);
			
			Parent root1 = creationPane.load(); 
			
			
			loginPane.getChildren().clear();
			loginPane.setCenter(root1);
		 
	    }
	 public void initializeCustomerList() {
		 
		 ObservableList<Customer> observableList;
		 observableList = FXCollections.observableArrayList(restaurant.getCustomerList());
		 customerList.setItems(observableList);
		 
		 customerTableName.setCellValueFactory(new PropertyValueFactory<Customer,String>("names"));
		 customerTableLastnames.setCellValueFactory(new PropertyValueFactory<Customer,String>("lastNames"));
		 customerTableID.setCellValueFactory(new PropertyValueFactory<Customer,String>("identificatorNumber"));
		 customerTableAddres.setCellValueFactory(new PropertyValueFactory<Customer,String>("addres"));
		 customerTablePhone.setCellValueFactory(new PropertyValueFactory<Customer,String>("phoneNumber"));
	 }
	 
	 public void initializeIngredientList(){
		 
	ObservableList<Ingredient> observableList;
	observableList = FXCollections.observableArrayList(restaurant.getIngredientsList());
		 
	ingredientsList.setItems(observableList);		
		 
	ingredientNameTable.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("name"));
	ingredientStateTable.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("state") );
	ingredientCreatorTable.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("creator")); 
	ingredientLastModifiedTable.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("lastModifie"));
	
	 }
	 @FXML
	 public void loadIngredientsList(ActionEvent event) throws IOException {

		 FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("ingredientListPane.fxml"));
		 fxml1.setController(this);
		 
		 Parent root1 = fxml1.load();
		 
		 ingredientListPane.getChildren().clear();
		 ingredientListPane.getChildren().setAll(root1);
		 initializeIngredientList();
		 
	    }
	 public void initializeEmployeeList() {
		 
		ObservableList<Employee> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getEmployeeList());
		 
		employeeTable.setItems(observableList);
		
		employeeNameTable.setCellValueFactory(new PropertyValueFactory<Employee,String>("names"));
		employeeLastNameTable.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastNames"));
		employeeIDTable.setCellValueFactory(new PropertyValueFactory<Employee,String>("identificatorNumber"));
	 
	 }
	 public void initializeUserList() {
		 
			ObservableList<User> observableList;
			observableList = FXCollections.observableArrayList(restaurant.getUserList());
			 
			userTable.setItems(observableList);
			
			userNameTable.setCellValueFactory(new PropertyValueFactory<User,String>("names"));
			userLastNameTable.setCellValueFactory(new PropertyValueFactory<User,String>("lastNames"));
			userIDTable.setCellValueFactory(new PropertyValueFactory<User,String>("identificatorNumber"));
			userUsernameTable.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));
		 }
	 @FXML
	 public void loadEmployeeList(ActionEvent event) throws IOException {

		 FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("employeeListPane.fxml"));
		 fxml1.setController(this);
		 
		 Parent root1 = fxml1.load();
		 
		 mainMenuPane.getChildren().clear();
		 mainMenuPane.getChildren().setAll(root1);
		 initializeEmployeeList();
		 
	    }
	 @FXML
	 public void addCustomer(ActionEvent event) throws FileNotFoundException, IOException {

		 String name = nameClientTxT.getText().trim();
		 
		 String lastName = lastNameClientTxT.getText().trim();
		 
		 String id = idClientTxT.getText().trim();
		 
		 String addres = addressClientTxT.getText().trim();
		 
		 String phone = phoneClientTxT.getText().trim();
		 
		 String comments = commentClientTxT.getText().trim();
		 
		 boolean found = restaurant.findCustomer(id, phone);
		 
		 if( (name.equals(""))||(lastName.equals("")) || (id.equals("")) ||	(addres.equals(""))||(phone.equals(""))) {
			 
			 Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Debe de llenar todos los campos obligatorios");
				alert.showAndWait();
			  
		 }else {
			 
			 if(found==true) {
				 
				 Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Ya existe un cliente con el mismo id y telefono");
					alert.showAndWait();
				 
				 
			 }else {
				 
				 restaurant.addCustomer(name, lastName, id, addres, phone, comments);
				 Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Cliente añadido exitosamente");
					alert.showAndWait();
			 }
			 
		 }
	 }
	  @FXML
	 public void returnToMainPane(ActionEvent event) throws IOException {

		  FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));
		  fxmlloader.setController(this);
			Parent mainMenu = fxmlloader.load();
			customerCreationPane.getChildren().clear();
			customerCreationPane.setCenter(mainMenu);	
		  
	    }
	  @FXML
	  public void returnToMainPane2(ActionEvent event) throws IOException {

			  FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));
			  fxmlloader.setController(this);
				Parent mainMenu = fxmlloader.load();
				
				userCreationPane.getChildren().clear();
				userCreationPane.setCenter(mainMenu);	
			  
		    }
	  @FXML
	  public void addIngredient(ActionEvent event) {

		 String name = ingredientNameTxT.getText().trim(); 
		  
		 boolean found = restaurant.findIngredient(name);
		 
	
		 	if(found == false) {
		 		
		 		
		 		try {
					restaurant.addIngredient(name, restaurant.getCurrentUser());
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		 		Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Ingrediente añadido exitosamente");
				alert.showAndWait();
		 	}else {
		 		Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("El ingrediente ya existe");
				alert.showAndWait();
		 	}
		 
	    }
	  @FXML
	 public void loadIngredientCreationPane(ActionEvent event) throws IOException {

		  FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("addIngredientPane.fxml"));
		  fxmlloader.setController(this);
		  Parent addIngredientPane = fxmlloader.load();
		  
		mainMenuPane.getChildren().clear();
		mainMenuPane.getChildren().setAll(addIngredientPane);	
		  
		  
	    }
	  @FXML
	  public void returnFromAddIngredient(ActionEvent event) throws IOException {


		  FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));
		  fxmlloader.setController(this);
			Parent mainMenu = fxmlloader.load();
			CreateIngredientPane.getChildren().clear();
			CreateIngredientPane.setCenter(mainMenu);	
	    }
	  @FXML
	  public void loadEmployeeCreationPane(ActionEvent event) throws IOException {

		  FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("employeeCreationPane.fxml"));
		  fxmlloader.setController(this);
			Parent mainMenu = fxmlloader.load();
			mainMenuPane.getChildren().clear();
			mainMenuPane.setCenter(mainMenu);
		  
		  
	    }
	  @FXML
	  public void createEmployee(ActionEvent event) throws FileNotFoundException, IOException {

		  String names = nameEmployeeCreationTxT.getText().trim();
		  
		  String lastNames = lastnameEmployeeCreationTxT.getText().trim();
		  
		  String id = idEmployeeCreationTxT.getText().trim();
		  
		  boolean found = restaurant.findEmployee(id);
		  
		  if(found==false) {
		  
			  restaurant.addEmployee(names, lastNames, id);
			  Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Empleado añadido exitosamente");
				alert.showAndWait();
		  }else {
			  Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("El empleado ya existe");
				alert.showAndWait();
		  }
	    }
	  @FXML
	  public void returnFromEmployeeCreation(ActionEvent event) throws IOException {

		  FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));
		  fxmlloader.setController(this);
			Parent employeeCreation = fxmlloader.load();
			employeeCreationPane.getChildren().clear();
			employeeCreationPane.setCenter(employeeCreation);	
		  
	    }
	  @FXML
	  public void createUserAccountFromMenu(ActionEvent event) throws IOException {

		  FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("userCreationPane2.fxml"));
		  fxmlloader.setController(this);
			Parent mainMenu = fxmlloader.load();
			mainMenuPane.getChildren().clear();
			mainMenuPane.setCenter(mainMenu);
		  
	    }
	  @FXML
	   public void returnToLoginPane(ActionEvent event) throws IOException {

		  FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("userLogin.fxml"));
		  fxmlloader.setController(this);
			Parent mainMenu = fxmlloader.load();
			userCreationPane.getChildren().clear();
			userCreationPane.setCenter(mainMenu);
		  
	    }
	  @FXML
	    void returnToFirstPane(ActionEvent event) throws IOException {

		  FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("LoginPane.fxml"));
		  fxmlloader.setController(this);
			Parent mainMenu = fxmlloader.load();
			loginPane.getChildren().clear();
			loginPane.setCenter(mainMenu);
		  
		  
	    }
	  @FXML
	  public void returnToMainPageFromEmployee(ActionEvent event) throws IOException {


		  FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));
		  fxmlloader.setController(this);
		Parent mainMenu = fxmlloader.load();
		employeeListPane.getChildren().clear();
			employeeListPane.setCenter(mainMenu);
		  
	    }
	  @FXML
	   public void openCustomerCreationPane(ActionEvent event) throws IOException {

		  FXMLLoader fxml = new FXMLLoader(getClass().getResource("customerCreationPane.fxml"));
		  fxml.setController(this);
		  Parent customerCreation = fxml.load();
		  mainMenuPane.getChildren().clear();
		  mainMenuPane.setCenter(customerCreation);
		  
		  
	    }
	  @FXML
	  public void openCustomerList(ActionEvent event) throws IOException {

		  FXMLLoader fxml = new FXMLLoader(getClass().getResource("customerListPane.fxml"));
		  fxml.setController(this);
		  Parent customerCreation = fxml.load();
		  mainMenuPane.getChildren().clear();
		  mainMenuPane.setCenter(customerCreation);
		  initializeCustomerList();
		  
	    } 
	  @FXML
	  public void returnFromCustomerList(ActionEvent event) throws IOException {
		  
		  FXMLLoader fxml = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));
		  fxml.setController(this);
		  Parent customerCreation = fxml.load();
		  customersPane.getChildren().clear();
		  customersPane.setCenter(customerCreation);
		  
	    }
	  @FXML
	  public void openUsersList(ActionEvent event) throws IOException {

		  FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("userListPane.fxml"));
		  fxml1.setController(this);
			 
			 Parent root1 = fxml1.load();
			 
			 mainMenuPane.getChildren().clear();
			 mainMenuPane.getChildren().setAll(root1);
			initializeUserList();
		  
	    }
}
