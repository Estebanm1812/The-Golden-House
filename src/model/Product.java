package model;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 6L;

	private String name;
	
	private double [] prices;
	
	private String [] sizes;
	
	private String [] ingredients;
	
	public Product(String name, double [] prices, String [] sizes, String [] ingredients) {
	
		this.name = name;
		
		this.prices = prices;
		
		this.sizes = sizes;
		
		this.ingredients = ingredients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double [] getPrices() {
		return prices;
	}
	public void setPrice(double [] prices) {
		
		this.prices = prices;
		
	}
	public String [] getSize() {
		return sizes;
	}
	public void setSize(String [] sizes) {
		this.sizes = sizes;
	}
	public String [] getIngredients() {
		return ingredients;
	}
	public void setIngredients(String [] ingredients) {
		this.ingredients = ingredients;
	}
}
