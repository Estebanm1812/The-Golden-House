package ui;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import model.Restaurant;

public class RestaurantGUI {
	

    @FXML
    private BorderPane firstPane;
	
    @FXML
    private BorderPane pane;
    
	private Restaurant restaurant;
	
	public RestaurantGUI(Restaurant restaurant) {
	
		this.restaurant = restaurant;
		
		
	}
	public BorderPane getPane() {
		return pane;
	}
	public void SetPane(BorderPane pane) {
		this.pane = pane;
	}
	
	
}
