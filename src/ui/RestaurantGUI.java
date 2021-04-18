package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
//import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
//import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.Customer;
import model.Employee;
import model.Ingredient;
import model.ProductType;
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
    private BorderPane createProductTypePane;

    @FXML
    private TextField productTypeNameTxT;
    
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
    private TableColumn<Employee, String> employeeStateTable;

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
    
    @FXML
    private BorderPane productPane;

    @FXML
    private TextField productNameTxT;

    @FXML
    private TextField productPriceTxT;

    @FXML
    private ComboBox<String> productIngredientComboBox;
    
    @FXML
    private ComboBox<String> productIngredientComboBox2;

    @FXML
    private ComboBox<String> productIngredientComboBox3;

    @FXML
    private ComboBox<String> productIngredientComboBox4;

    @FXML
    private ComboBox<String> productIngredientComboBox5;

    @FXML
    private ComboBox<String> productIngredientComboBox6;

    @FXML
    private ComboBox<String> productIngredientComboBox7;

    @FXML
    private ComboBox<String> productIngredientComboBox8;

    @FXML
    private ComboBox<String> productIngredientComboBox9;

    @FXML
    private ComboBox<String> productIngredientComboBox10;
   
    @FXML
    private ComboBox<String> productProductTypeComboBox;
    
    @FXML
    private BorderPane firstUserCreationPane;
    
    @FXML
    private TextField productSizeTxT;
    
    @FXML
    private BorderPane productTypePane;

    @FXML
    private TableView<ProductType> producTypetList;

    @FXML
    private TableColumn<ProductType,String> productTypeName;

    @FXML
    private TableColumn<ProductType, String> productTypeCreator;

    @FXML
    private TableColumn<ProductType, String> productTypeLastModified;
    
    @FXML
    private ComboBox<String> deliveryCreationCustomerComboBox;
    
    @FXML
    private ComboBox<String> deliveryCreationProductComboBox;

    @FXML
    private TextField deliveryCreationQuanitityTextField;

    @FXML
    private ComboBox<String> deliveryCreationProduct2ComboBox;

    @FXML
    private TextField deliveryCreationQuanitityTextField2;

    @FXML
    private ComboBox<String> deliveryCreationProduct3ComboBox;

    @FXML
    private TextField deliveryCreationQuanitityTextField3;

    @FXML
    private ComboBox<String> deliveryCreationEmployeeComboBox;

    @FXML
    private TextField deliveryCreationObservationsTextFields;

    @FXML
    private BorderPane deliveryCreationPane;
    
    @FXML
    private TextField deliveryCreationID;

    
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
		 
		 int userposition = -1;
		 
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
		 			userposition = restaurant.findUserPosition(userName);
		 			restaurant.setCurrentUser(restaurant.getUserList().get(userposition));
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
	 public void initializeProductTypeList() {
		
		 ObservableList<ProductType> observableList;
		 observableList = FXCollections.observableArrayList(restaurant.getProductTypeList());
		 producTypetList.setItems(observableList);
		 producTypetList.setEditable(true);
		 
		 productTypeName.setCellValueFactory(new PropertyValueFactory<ProductType,String>("name"));
		 productTypeName.setCellFactory(TextFieldTableCell.forTableColumn());
		 productTypeName.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ProductType,String>>() {

			@Override
			public void handle(CellEditEvent<ProductType, String> event) {
				event.getRowValue().setName(event.getNewValue());
				event.getRowValue().setLastModifie(restaurant.getCurrentUser().getNames()+restaurant.getCurrentUser().getLastNames());
				try {
					restaurant.saveData(restaurant.getProductTypeSavePanth());
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		 });
		 productTypeCreator.setCellValueFactory(new PropertyValueFactory<ProductType,String>("creator"));
		 productTypeLastModified.setCellValueFactory(new PropertyValueFactory<ProductType,String>("lastModified"));
	 }
	 public void initializeCustomerList() {
		 
		 restaurant.sortCustomerByNames();
		 ObservableList<Customer> observableList;
		 observableList = FXCollections.observableArrayList(restaurant.getCustomerList());
		 customerList.setItems(observableList);
		 customerList.setEditable(true);
		 
		 customerTableName.setCellValueFactory(new PropertyValueFactory<Customer,String>("names"));
		 customerTableName.setCellFactory(TextFieldTableCell.forTableColumn());
		 customerTableName.setOnEditCommit(new EventHandler<CellEditEvent<Customer,String>>(){

			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				event.getRowValue().setNames(event.getNewValue());
				try {
					restaurant.saveData(restaurant.getCustomersSavepath());
					customerList.refresh();
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			 
		 });
		 
		 customerTableLastnames.setCellValueFactory(new PropertyValueFactory<Customer,String>("lastNames"));
		 customerTableLastnames.setCellFactory(TextFieldTableCell.forTableColumn());
		 customerTableLastnames.setOnEditCommit(new EventHandler<CellEditEvent<Customer, String>>(){

			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				event.getRowValue().setLastNames(event.getNewValue());
				try {
					restaurant.saveData(restaurant.getCustomersSavepath());
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			 
		 });
		 
		 customerTableID.setCellValueFactory(new PropertyValueFactory<Customer,String>("identificatorNumber"));
		 customerTableAddres.setCellValueFactory(new PropertyValueFactory<Customer,String>("addres"));
		 customerTableAddres.setCellFactory(TextFieldTableCell.forTableColumn());
		 customerTableAddres.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer,String>>() {

			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				event.getRowValue().setAddres(event.getNewValue());
				try {
					restaurant.saveData(restaurant.getCustomersSavepath());
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		
		 });
		 customerTablePhone.setCellValueFactory(new PropertyValueFactory<Customer,String>("phoneNumber"));
		 customerTablePhone.setCellFactory(TextFieldTableCell.forTableColumn());
		 customerTablePhone.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer,String>>() {

			@Override
			public void handle(CellEditEvent<Customer, String> event) {
				event.getRowValue().setPhoneNumber(event.getNewValue());
				try {
					restaurant.saveData(restaurant.getCustomersSavepath());
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		
		 });
	 }
	 
	 public void initializeIngredientList(){
		 
	ObservableList<Ingredient> observableList;
	observableList = FXCollections.observableArrayList(restaurant.getIngredientsList());
	
	ingredientsList.setItems(observableList);		
	ingredientsList.setEditable(true);	 
	
	ingredientNameTable.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("IngredintName"));
	ingredientNameTable.setCellFactory(TextFieldTableCell.forTableColumn());
	ingredientNameTable.setOnEditCommit(new EventHandler<CellEditEvent<Ingredient,String>>(){

		@Override
		public void handle(CellEditEvent<Ingredient, String> event) {
			//event.getRowValue().setIngredientName(event.getNewValue());
			//event.getRowValue().setLastModifie(restaurant.getCurrentUser().getNames()+ " "+restaurant.getCurrentUser().getLastNames());
			ingredientsList.refresh();
			restaurant.updateIngredient(event.getRowValue(), event.getNewValue());
		}
			
	 });
	
	ingredientStateTable.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("State") );
	ingredientStateTable.setOnEditCommit(new EventHandler<CellEditEvent<Ingredient,String>>(){

		@Override
		public void handle(CellEditEvent<Ingredient, String> event) {
			event.getRowValue().setState("INACTIVE");
			event.getRowValue().setLastModifie(restaurant.getCurrentUser().getNames()+" "+ restaurant.getCurrentUser().getLastNames());
			try {
				restaurant.saveData(restaurant.getIngredientsSavePath());
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	});
	ingredientCreatorTable.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("creator")); 
	
	ingredientLastModifiedTable.setCellValueFactory(new PropertyValueFactory<Ingredient,String>("LastModifie"));
	
	
	 }
	 @FXML
	 public void loadIngredientsList(ActionEvent event) throws IOException {

		 FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("ingredientListPane.fxml"));
		 fxml1.setController(this);
		 
		 Parent root1 = fxml1.load();
		 
		 mainMenuPane.getChildren().clear();
		 mainMenuPane.getChildren().setAll(root1);
		 initializeIngredientList();
		 
	    }
	 public void initializeEmployeeList() {
		 
		ObservableList<Employee> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getEmployeeList());
		 
		employeeTable.setItems(observableList);
		employeeTable.setEditable(true);
		
		employeeNameTable.setCellValueFactory(new PropertyValueFactory<Employee,String>("names"));
		employeeNameTable.setCellFactory(TextFieldTableCell.forTableColumn());
		employeeNameTable.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>(){

			@Override
			public void handle(CellEditEvent<Employee, String> event) {
				
				event.getRowValue().setNames(event.getNewValue());
				try {
					restaurant.saveData(restaurant.getEmployeeSavePath());
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			
		});
		
		employeeLastNameTable.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastNames"));
		employeeLastNameTable.setCellFactory(TextFieldTableCell.forTableColumn());
		employeeLastNameTable.setOnEditCancel(new EventHandler<CellEditEvent<Employee,String>>(){

			@Override
			public void handle(CellEditEvent<Employee, String> event) {
				event.getRowValue().setNames(event.getNewValue());
				try {
					restaurant.saveData(restaurant.getEmployeeSavePath());
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		
			
		});
		
		employeeIDTable.setCellValueFactory(new PropertyValueFactory<Employee,String>("identificatorNumber"));
		employeeIDTable.setCellFactory(TextFieldTableCell.forTableColumn());
		
		employeeStateTable.setCellValueFactory(new PropertyValueFactory<Employee,String>("state"));
	
		
							
			
	 }
	 public void initializeUserList() {
		 
			ObservableList<User> observableList;
			observableList = FXCollections.observableArrayList(restaurant.getUserList());
			 
			userTable.setItems(observableList);
			userTable.setEditable(true);
			
			userNameTable.setCellValueFactory(new PropertyValueFactory<User,String>("names"));
			userNameTable.setCellFactory(TextFieldTableCell.forTableColumn());
			userNameTable.setOnEditCommit(new EventHandler<CellEditEvent<User,String>>(){

				@Override
				public void handle(CellEditEvent<User, String> event) {
		
					event.getRowValue().setUserName(event.getNewValue());
					try {
						restaurant.saveData(restaurant.getUsersSavePath());
					} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
				
				
			});
			
			userLastNameTable.setCellValueFactory(new PropertyValueFactory<User,String>("lastNames"));
			userLastNameTable.setCellFactory(TextFieldTableCell.forTableColumn());
			userLastNameTable.setOnEditCommit(new EventHandler<CellEditEvent<User,String>>(){

				@Override
				public void handle(CellEditEvent<User, String> event) {
				
					event.getRowValue().setLastNames(event.getNewValue());
					try {
						restaurant.saveData(restaurant.getUsersSavePath());
					} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
				
			});
			
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
					restaurant.addIngredient(name, restaurant.getCurrentUser().getUserName());
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
	  @FXML
	   public void addProductType(ActionEvent event) throws FileNotFoundException, IOException {

		  String name = productTypeNameTxT.getText().trim();
		  boolean found = restaurant.findProductType(name);
		  
		  if(found == true) {
			  Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Ya existe ese tipo de Producto");
				alert.showAndWait();
		  }else {
			  restaurant.addProductType(name);
			  Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Se ha añadido el tipo de Producto");
				alert.showAndWait();
		  }
		  
	    }
	  @FXML
	 public void changeToProductTypePane(ActionEvent event) throws IOException {

		  FXMLLoader fxml = new FXMLLoader(getClass().getResource("addProductTypePane.fxml"));
		  fxml.setController(this);
		  
		  Parent root1 = fxml.load();
		  
		  mainMenuPane.getChildren().clear();
		  mainMenuPane.setCenter(root1);
	    }
	  @FXML
	  public void returnFromAddProductType(ActionEvent event) throws IOException {

		  FXMLLoader fxml = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));
		  fxml.setController(this);
		  
		  Parent root1 = fxml.load();
		  
		  createProductTypePane.getChildren().clear();
		  createProductTypePane.setCenter(root1);
		  
		  
	    }
	  @FXML
	  public  void openProductCreationPane(ActionEvent event) throws IOException {

		  FXMLLoader fxml = new FXMLLoader(getClass().getResource("productCreationPane.fxml"));
		  fxml.setController(this);
		  
		  Parent root1 = fxml.load();
		  
		  mainMenuPane.getChildren().clear();
		  mainMenuPane.setCenter(root1);
		  
	  
		  for(int i=0; i < restaurant.getIngredientsList().size();i++) {
		  String ingredient = restaurant.getIngredientsList().get(i).getIngredintName();
		  productIngredientComboBox.getItems().add(ingredient);
		  productIngredientComboBox2.getItems().add(ingredient);
		  productIngredientComboBox3.getItems().add(ingredient);
		  productIngredientComboBox4.getItems().add(ingredient);
		  productIngredientComboBox5.getItems().add(ingredient);
		  productIngredientComboBox6.getItems().add(ingredient);
		  productIngredientComboBox7.getItems().add(ingredient);
		  productIngredientComboBox8.getItems().add(ingredient);
		  productIngredientComboBox9.getItems().add(ingredient);
		  productIngredientComboBox10.getItems().add(ingredient);
		  }
		  
		  for(int i=0; i< restaurant.getProductTypeList().size();i++) {
		  String type = restaurant.getProductTypeList().get(i).getName();  
		  productProductTypeComboBox.getItems().add(type);
			  
		  }
	}
	  @FXML
	  public  void returnFromProductCreation(ActionEvent event) throws IOException {

		  
		  FXMLLoader fxml = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));
		  fxml.setController(this);
		  
		  Parent root1 = fxml.load();
		  
		  productPane.getChildren().clear();
		  productPane.setCenter(root1);
		  
	    }
	  @FXML
	  public void addProduct(ActionEvent event) throws FileNotFoundException, IOException {

		  String name = productNameTxT.getText().trim();
		  
		  double price = Double.parseDouble(productPriceTxT.getText());
		  
		  String [] ingredients;
		  
		  String size = productSizeTxT.getText().trim();
		  
		  int count = 0;
		  
		  if((productIngredientComboBox.getAccessibleText().equals(""))==false) {
			  count+=1;
			  
		  }
		  if((productIngredientComboBox2.getAccessibleText().equals(""))==false) {
			  count+=1;
			  
		  }
		  if((productIngredientComboBox3.getAccessibleText().equals(""))==false) {
			  count+=1;
			  
		  }
		  if((productIngredientComboBox4.getAccessibleText().equals(""))==false) {
			  count+=1;
			  
		  }
		  if((productIngredientComboBox5.getAccessibleText().equals(""))==false) {
			  count+=1;
			  
		  }
		  if((productIngredientComboBox6.getAccessibleText().equals(""))==false) {
			  count+=1;
			  
		  }
		  if((productIngredientComboBox7.getAccessibleText().equals(""))==false) {
			  count+=1;
			  
		  }
		  if((productIngredientComboBox8.getAccessibleText().equals(""))==false) {
			  count+=1;
			  
		  }
		  if((productIngredientComboBox9.getAccessibleText().equals(""))==false) {
			  count+=1;
			  
		  }
		  if((productIngredientComboBox10.getAccessibleText().equals(""))==false) {
			  count+=1;
			  
		  }
		  int added=0;
		  ingredients = new String[count];
		  for(int i=0; i < count && added!=count;i++) {
		  boolean out = false;
			  
			  if(ingredients[i].isEmpty() && out==false) {
			  
				  if(productIngredientComboBox.getAccessibleText().equals("")!=false) {
				  
					  ingredients[i] = productIngredientComboBox.getAccessibleText();
					  out = true;
					  added+=1;
				  }
				  if(productIngredientComboBox2.getAccessibleText().equals("")!=false) {
					  
					  ingredients[i] = productIngredientComboBox2.getAccessibleText();
					  out = true;
					  added+=1;
				  }
				  if(productIngredientComboBox3.getAccessibleText().equals("")!=false) {
					  
					  ingredients[i] = productIngredientComboBox3.getAccessibleText();
					  out = true;
					  added+=1;
				  }
				  if(productIngredientComboBox4.getAccessibleText().equals("")!=false) {
					  
					  ingredients[i] = productIngredientComboBox4.getAccessibleText();
					  out = true;
					  added+=1;
				  }
				  if(productIngredientComboBox5.getAccessibleText().equals("")!=false) {
					  
					  ingredients[i] = productIngredientComboBox5.getAccessibleText();
					  out = true;
					  added+=1;
				  }
				  if(productIngredientComboBox6.getAccessibleText().equals("")!=false) {
					  
					  ingredients[i] = productIngredientComboBox6.getAccessibleText();
					  out = true;
					  added+=1;
				  }
				  if(productIngredientComboBox7.getAccessibleText().equals("")!=false) {
					  
					  ingredients[i] = productIngredientComboBox7.getAccessibleText();
					  out = true;
					  added+=1;
				  }
				  if(productIngredientComboBox8.getAccessibleText().equals("")!=false) {
					  
					  ingredients[i] = productIngredientComboBox8.getAccessibleText();
					  out = true;
					  added+=1;
				  }
				  if(productIngredientComboBox9.getAccessibleText().equals("")!=false) {
					  
					  ingredients[i] = productIngredientComboBox9.getAccessibleText();
					  out = true;
					  added+=1;
				  }
				  if(productIngredientComboBox10.getAccessibleText().equals("")!=false) {
					  
					  ingredients[i] = productIngredientComboBox10.getAccessibleText();
					  out = true;
					  added+=1;
				  }
			  }
		  }
		  boolean found = restaurant.findProduct(name, ingredients,price);
		  
		  if((productNameTxT.getText().equals(""))||(productPriceTxT.getText().equals(""))||(size.equals(""))||productIngredientComboBox.getAccessibleText().equals("")){
		  
			  Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Debe de completar todos los datos obligatorios");
				alert.showAndWait();
			  
			  
			  
		  if(found==true) {
		  
			  Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("Information Dialog");
				alert2.setHeaderText(null);
				alert2.setContentText("Ya existe ese Producto con el mismo precio");
				alert2.showAndWait();
			  
		  }else {
			  
			  restaurant.addProduct(name, ingredients, size, price);
			  
			  Alert alert3 = new Alert(AlertType.INFORMATION);
				alert3.setTitle("Information Dialog");
				alert3.setHeaderText(null);
				alert3.setContentText("Se ha añadido el Producto");
				alert3.showAndWait();
			  
			  
		  }
		  
	    }
	  }
	  @FXML
	  public void returnFromUserList(ActionEvent event) throws IOException {

		  FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));
		  fxmlloader.setController(this);
		  Parent mainMenu = fxmlloader.load();
		  userListPane.getChildren().clear();
		  userListPane.setCenter(mainMenu);	
	    }
	  @FXML
	  public  void createFirstUser(ActionEvent event) throws FileNotFoundException, IOException {

		  String name = userCreationNameTxT.getText();
			 
			 String lastName = userCreationLastNameTxT.getText();
			 
			 String id = userCreationIdTxT.getText();
			 
			 String userName = userCreationUserNameTxT.getText();
			 
			 String password = userCreationPasswordTxT.getText();
			 
			 
			 if((userCreationNameTxT.getText().equals("")||(userCreationPasswordTxT.getText().equals(""))||(userCreationIdTxT.getText().equals(""))||(userCreationUserNameTxT.getText().equals(""))||(userCreationPasswordTxT.getText().equals("")))) {
			 
				 Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("El Usuario fue creado exitosamente");
				 
			 }else{
			restaurant.addEmployee(name, lastName, id);
			 restaurant.addUser(name, lastName, id, userName, password);
		 		Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("El Usuario fue creado exitosamente");
				alert.showAndWait();
				
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));
			fxmlloader.setController(this);
			Parent mainMenu = fxmlloader.load();
			firstUserCreationPane.getChildren().clear();
			firstUserCreationPane.setCenter(mainMenu);	
			}
	    }
	  @FXML
	  public  void importEmployees(ActionEvent event) {

		  FileChooser fileChooser = new FileChooser();
	    	fileChooser.setTitle("Open Resource File");
	    	File file = fileChooser.showOpenDialog(null);
	    	if(file != null) {
	    		try {
					restaurant.importEmployee(file.getAbsolutePath());
					 Alert alert = new Alert(AlertType.INFORMATION);
					    alert.setTitle("The Golden House");
					    alert.setHeaderText("Annoucement");
					    alert.setContentText("Los empleados se han importado correctamente");
					
					    alert.showAndWait();
				} catch (IOException e) {
					 Alert alert = new Alert(AlertType.INFORMATION);
					    alert.setTitle("The Golden House");
					    alert.setHeaderText("Error");
					    alert.setContentText("Los Empleados no se han importado correctamente ");
					
					    alert.showAndWait();
				}
	    }
	  }
	  @FXML
	  public  void importIngredients(ActionEvent event) {
		  
		  FileChooser fileChooser = new FileChooser();
	    	fileChooser.setTitle("Open Resource File");
	    	File file = fileChooser.showOpenDialog(null);
	    	if(file != null) {
	    		try {
					restaurant.importIngredients(file.getAbsolutePath());
					 Alert alert = new Alert(AlertType.INFORMATION);
					    alert.setTitle("The Golden House");
					    alert.setHeaderText("Annoucement");
					    alert.setContentText("Los Ingredientes se han importado correctamente");
					
					    alert.showAndWait();
				} catch (IOException e) {
					 Alert alert = new Alert(AlertType.INFORMATION);
					    alert.setTitle("The Golden House");
					    alert.setHeaderText("Error");
					    alert.setContentText("Los Ingredientes no se han importado correctamente ");
					
					    alert.showAndWait();
				}
		  
		 
	    }
	  }
	  @FXML
	  public  void importUsers(ActionEvent event) {

		  FileChooser fileChooser = new FileChooser();
	    	fileChooser.setTitle("Open Resource File");
	    	File file = fileChooser.showOpenDialog(null);
	    	if(file != null) {
	    		try {
					restaurant.importUsers(file.getAbsolutePath());
					 Alert alert = new Alert(AlertType.INFORMATION);
					    alert.setTitle("The Golden House");
					    alert.setHeaderText("Annoucement");
					    alert.setContentText("Los Usuarios se han importado correctamente");
					
					    alert.showAndWait();
				} catch (IOException e) {
					 Alert alert = new Alert(AlertType.INFORMATION);
					    alert.setTitle("The Golden House");
					    alert.setHeaderText("Error");
					    alert.setContentText("Los Usuarios no se han importado correctamente ");
					
					    alert.showAndWait();
				}
		  
		 
	    }
		  
	    }
	  @FXML
	  public  void importCustomers(ActionEvent event) {

		  FileChooser fileChooser = new FileChooser();
	    	fileChooser.setTitle("Open Resource File");
	    	File file = fileChooser.showOpenDialog(null);
	    	if(file != null) {
	    		try {
					restaurant.importCustomers(file.getAbsolutePath());
					 Alert alert = new Alert(AlertType.INFORMATION);
					    alert.setTitle("The Golden House");
					    alert.setHeaderText("Annoucement");
					    alert.setContentText("Los Clientes se han importado correctamente");
					
					    alert.showAndWait();
				} catch (IOException e) {
					 Alert alert = new Alert(AlertType.INFORMATION);
					    alert.setTitle("The Golden House");
					    alert.setHeaderText("Error");
					    alert.setContentText("Los Clientes no se han importado correctamente ");
					
					    alert.showAndWait();
				}
		  
		 
	    }
	    	
	    }
	  @FXML
	  public void exportCustomers(ActionEvent event) throws FileNotFoundException {

		  TextInputDialog dialog = new TextInputDialog("");
		  dialog.setTitle("The Golden House");
		  dialog.setHeaderText("");
		  dialog.setContentText("Ingrese el nombre del archivo al que desea exportar la informacion");

		  Optional<String> result = dialog.showAndWait();
		  if (result.isPresent()){
		     restaurant.exportCustomerData(result.get());
		  }
		  
	  }
	    @FXML
	   public void exportEmployees(ActionEvent event) throws FileNotFoundException {

	    	TextInputDialog dialog = new TextInputDialog("");
			  dialog.setTitle("The Golden House");
			  dialog.setHeaderText("");
			  dialog.setContentText("Ingrese el nombre del archivo al que desea exportar la informacion");

			  Optional<String> result = dialog.showAndWait();
			  if (result.isPresent()){
			     restaurant.exportEmployeeData(result.get());
			  }
	    	
	    }

	    @FXML
	   public void exportIngredients(ActionEvent event) throws FileNotFoundException {

	    	TextInputDialog dialog = new TextInputDialog("");
			  dialog.setTitle("The Golden House");
			  dialog.setHeaderText("");
			  dialog.setContentText("Ingrese el nombre del archivo al que desea exportar la informacion");

			  Optional<String> result = dialog.showAndWait();
			  if (result.isPresent()){
			     restaurant.exportIngredientData(result.get());
			  }
	    	
	    }

	    @FXML
	   public void exportProducts(ActionEvent event) throws FileNotFoundException {

	    	TextInputDialog dialog = new TextInputDialog("");
			  dialog.setTitle("The Golden House");
			  dialog.setHeaderText("");
			  dialog.setContentText("Ingrese el nombre del archivo al que desea exportar la informacion");

			  Optional<String> result = dialog.showAndWait();
			  if (result.isPresent()){
			     restaurant.exportProductData(result.get());
			  }
	    	
	    }

	    @FXML
	   public void exportUsers(ActionEvent event) throws FileNotFoundException {

	    	TextInputDialog dialog = new TextInputDialog("");
			  dialog.setTitle("The Golden House");
			  dialog.setHeaderText("");
			  dialog.setContentText("Ingrese el nombre del archivo al que desea exportar la informacion");

			  Optional<String> result = dialog.showAndWait();
			  if (result.isPresent()){
			     restaurant.exportUserData(result.get());
			  }
	    	
	    }
	    @FXML
	  public void loadProductTypeList(ActionEvent event) throws IOException {
	    
	    FXMLLoader fxml = new FXMLLoader(getClass().getResource("productTypeListPane.fxml"));	
	    fxml.setController(this);
		Parent list = fxml.load();
		  mainMenuPane.getChildren().clear();
		  mainMenuPane.setCenter(list);		
	    	initializeProductTypeList();
	    }    
	    @FXML
	  public void returnFromMenuProductTypeList(ActionEvent event) throws IOException {

	    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));	
		    fxml.setController(this);
			Parent menu = fxml.load();
			productTypePane.getChildren().clear();
			productTypePane.setCenter(menu);		
			
	    }
	    @FXML
	  public void returnFromIngredient(ActionEvent event) throws IOException {
	    	
	    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));	
		    fxml.setController(this);
			Parent menu = fxml.load();
			ingredientListPane.getChildren().clear();
			ingredientListPane.setCenter(menu);
	    }
	    @FXML
	  public void loadDeliveryCreationPane(ActionEvent event) throws IOException {

	    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("deliveryCreationPane.fxml"));
	    	fxml.setController(this);
	    	Parent delivery = fxml.load();
	    	mainMenuPane.getChildren().clear();
	    	mainMenuPane.setCenter(delivery);
	    	for(int i=0; i < restaurant.getCustomerList().size();i++) {
	    		
	    		String customerName = restaurant.getCustomerList().get(i).getNames()+" " + restaurant.getCustomerList().get(i).getLastNames();
	    		deliveryCreationCustomerComboBox.getItems().add(customerName);
	    	}
	    	for(int i=0;i < restaurant.getProductList().size();i++) {
	    		
	    		String productName = restaurant.getProductList().get(i).getName();
	    		if(restaurant.getProductList().get(i).getState().equals("ACTIVO")) {
	    			deliveryCreationProduct2ComboBox.getItems().add(productName);
	    			deliveryCreationProduct3ComboBox.getItems().add(productName);
	    			deliveryCreationProductComboBox.getItems().add(productName);
	    		}
	    	}
	    	for(int i=0;i < restaurant.getEmployeeList().size();i++) {
	    		
	    		String employeeName = restaurant.getEmployeeList().get(i).getNames()+" " + restaurant.getEmployeeList().get(i).getLastNames();
	    		if(restaurant.getEmployeeList().get(i).getState().equals("ACTIVO")) {
	    			deliveryCreationEmployeeComboBox.getItems().add(employeeName);
	    		}
	    	}
	    }
	    @FXML
	  public void returnFromDeliveryCreation(ActionEvent event) throws IOException {

	    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("mainMenuPane.fxml"));
	    	fxml.setController(this);
	    	Parent menu = fxml.load();
	    	deliveryCreationPane.getChildren().clear();
	    	deliveryCreationPane.setCenter(menu);
	    	
	    }
	    @FXML
	   public void createDelivery(ActionEvent event) throws FileNotFoundException, IOException {
	    	
	    	String customer = deliveryCreationCustomerComboBox.getAccessibleText();
	    	String product1 = deliveryCreationProductComboBox.getAccessibleText();
	    	String product2 = deliveryCreationProduct2ComboBox.getAccessibleText();
	    	String product3 = deliveryCreationProduct3ComboBox.getAccessibleText();
	    	int quantity1 = Integer.parseInt(deliveryCreationQuanitityTextField.getAccessibleText());
	    	int quantity2 = Integer.parseInt(deliveryCreationQuanitityTextField2.getAccessibleText());
	    	int quantity3 = Integer.parseInt(deliveryCreationQuanitityTextField3.getAccessibleText());
	    	String employee = deliveryCreationEmployeeComboBox.getAccessibleText();
	    	String observations = deliveryCreationObservationsTextFields.getText();
	    	String local = LocalDate.now().toString();
	    	String [] products = new String[3];
	    	int [] quantities = new int[3];
	    	
	    	if(customer.equals("")||product1.equals("")||deliveryCreationQuanitityTextField.equals("")||employee.equals("")) {
	    		
	    		Alert alert = new Alert(AlertType.INFORMATION);
			    alert.setTitle("The Golden House");
			    alert.setHeaderText("Error");
			    alert.setContentText("Los campos obligatorios no pueden estar vacios");
			
			    alert.showAndWait();
	    	}else {
	    		
	    		products[0] = product1;
	    		quantities[0] = quantity1;
	    		if(product2!="" && deliveryCreationQuanitityTextField2.getText()!="") {
	    				products[1] = product2;
	    				quantities[1] = quantity2;
	    		}
	    		if(product3!="" && deliveryCreationQuanitityTextField3.getText()!="") {
	    			products[2] = product3;
	    			quantities[2] = quantity3;
	    		}
	    		restaurant.addDelivery(customer, products, quantities, employee, observations, local);
	    		Alert alert = new Alert(AlertType.INFORMATION);
			    alert.setTitle("The Golden House");
			    alert.setContentText("Se ha añadido exitosamente el Pedido");
	    	}
	    		
	    }
	    @FXML
	   public void searchCustomerByID(ActionEvent event) {
	    	
	    	String id = deliveryCreationID.getText();
	    	
	    	Long [] pos = restaurant.findCustomer(id);
	    	
	    	int pos2 = (int)(long)pos[0];
	    	
	    	if(pos2!=-1) {
	    	
	    	deliveryCreationCustomerComboBox.setAccessibleText(restaurant.getCustomerList().get(pos2).getNames()+ " " + restaurant.getCustomerList().get(pos2).getLastNames()); 
	    	Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("The Golden House");
		    alert.setContentText("Se ha encontrado el cliente usando el id\n" + restaurant.getCustomerList().get(pos2).getNames()+ " " + restaurant.getCustomerList().get(pos2).getLastNames() + " en " + pos[1]);
	    	}else {
	    		Alert alert = new Alert(AlertType.INFORMATION);
			    alert.setTitle("The Golden House");
			    alert.setHeaderText("Error");
			    alert.setContentText("No se ha encontrado el cliente, tiempo de busqueda: " + pos[1]);
			    
	    	}
	    }

}
