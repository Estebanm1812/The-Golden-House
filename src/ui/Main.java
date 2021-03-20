package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Restaurant;

public class Main extends Application{

	private Restaurant restaurant;
	private RestaurantGUI restaurantGUI;
	
	public Main() throws ClassNotFoundException, IOException {
		
		restaurant = new Restaurant();
		restaurantGUI = new RestaurantGUI(restaurant);
		
	}
	public static void main(String[]args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pane.fxml"));
		FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("LoginPane.fxml"));
		
		fxmlLoader.setController(restaurantGUI);
		
		fxmlLoader2.setController(restaurantGUI);
		
	    Parent loginPane = fxmlLoader.load();
		
		Parent root2 = fxmlLoader2.load();
		
		
		Scene scene2 = new Scene(root2);
		
		primaryStage.setTitle("The Golden House");
		primaryStage.setScene(scene2);
		primaryStage.show();
		
		
		
	}


		
	}

	
	
	
