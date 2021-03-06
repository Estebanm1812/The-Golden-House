package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Restaurant;

public class Main extends Application{

	private Restaurant restaurant;
	private RestaurantGUI restaurantGUI;
	
	public Main(){
		
		try {
			restaurant = new Restaurant();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		restaurantGUI = new RestaurantGUI(restaurant);
		
		
		try{
		restaurant.loadData(restaurant.getEmployeeSavePath());
		
		restaurant.loadData(restaurant.getCustomersSavepath());
		
		restaurant.loadData(restaurant.getIngredientsSavePath());
		
		restaurant.loadData(restaurant.getUsersSavePath());
		
		restaurant.loadData(restaurant.getDeliverySavePath());
		
		restaurant.loadData(restaurant.getProductSavePath());
		
		restaurant.loadData(restaurant.getProductTypeSavePanth());
		}catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("The Golden House");
			alert.setContentText("Error al cargar la informacion de los archivos");
			alert.showAndWait();
			}
	}
	public static void main(String[]args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pane.fxml"));
		FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("LoginPane.fxml"));
		FXMLLoader fxmlLoader3 = new FXMLLoader(getClass().getResource("firstUserCreationPane.fxml"));
		
		fxmlLoader.setController(restaurantGUI);
		
		fxmlLoader2.setController(restaurantGUI);
		
		fxmlLoader3.setController(restaurantGUI);
		
		Parent root2 = fxmlLoader2.load();
		
		Parent root3 = fxmlLoader3.load();
		
		if(restaurant.getEmployeeList().isEmpty()) {
			Scene scene2 = new Scene(root3);
			
			primaryStage.setTitle("The Golden House");
			primaryStage.setScene(scene2);
			primaryStage.show();
			
		}else {
		Scene scene2 = new Scene(root2);
		
		primaryStage.setTitle("The Golden House");
		primaryStage.setScene(scene2);
		primaryStage.show();
		}
		
		
	}


		
	}

	
	
	
