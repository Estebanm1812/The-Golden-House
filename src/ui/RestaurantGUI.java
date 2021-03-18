package ui;

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
import model.Employee;
import model.Ingredient;
import model.Restaurant;


public class RestaurantGUI {
	

    @FXML
    private BorderPane loginPane;
		
    @FXML
    private BorderPane firstPane;
    
    @FXML
    private BorderPane ingredientListPane;
	
    @FXML
    private BorderPane pane;
    
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
    private PasswordField passwordLoginTxT;

	
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
	 public void createUser(ActionEvent event) {
		 
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
	    	boolean result = restaurant.addUser(name, lastName, id, userName, password);
			 
			 if(result==false) {
			 
				 Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Los datos no concuerdon con un empleado activo");
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
		 			Parent mainMenu = fxmlloader.load();
		 			fxmlloader.setController(this);
		 			pane.getChildren().clear();
		 			pane.setCenter(mainMenu);	
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
		
		employeeNameTable.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
		employeeLastNameTable.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
		employeeIDTable.setCellValueFactory(new PropertyValueFactory<Employee,String>("identificatorNumber"));
	 
	 }
	 @FXML
	 public void loadEmployeeList(ActionEvent event) throws IOException {

		 FXMLLoader fxml1 = new FXMLLoader(getClass().getResource("employeeListPane.fxml"));
		 fxml1.setController(this);
		 
		 Parent root1 = fxml1.load();
		 
		 employeeListPane.getChildren().clear();
		 employeeListPane.getChildren().setAll(root1);
		 initializeEmployeeList();
		 
	    }
	 
	 	
}
