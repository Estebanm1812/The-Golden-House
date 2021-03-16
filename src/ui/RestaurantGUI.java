package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import model.Restaurant;

public class RestaurantGUI {
	

		
    @FXML
    private BorderPane firstPane;
	
    @FXML
    private BorderPane pane;
    
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
    public void toLoginPane(ActionEvent event) throws IOException {

		FXMLLoader logInPane = new FXMLLoader(getClass().getResource("userLogin.fxml"));
		
		logInPane.setController(this);
		
		Parent root1 = logInPane.load(); 
		
		
		pane.getChildren().clear();
		pane.setCenter(root1);
		 
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
	
	
}
