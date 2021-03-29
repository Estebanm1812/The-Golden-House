package model;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 6L;

	private String name;
	
	private double prices;
	
	private String sizes;
	
	private String [] ingredients;
	
	private double code;
	
	public Product(String name, double prices, String sizes, String [] ingredients) {
	
		this.name = name;
		
		this.prices = prices;
		
		this.sizes = sizes;
		
		this.ingredients = ingredients;
		
		code = (Math.random()*((1000000-00000001)+1)+0000001);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrices() {
		return prices;
	}
	public void setPrice(double  prices) {
		
		this.prices = prices;
		
	}
	public String  getSize() {
		return sizes;
	}
	public void setSize(String sizes) {
		this.sizes = sizes;
	}
	public String [] getIngredients() {
		return ingredients;
	}
	public void setIngredients(String [] ingredients) {
		this.ingredients = ingredients;
	}
	public double getCode() {
		return code;
	}
	public void setCode(Double code) {
		this.code = code;
	}
	public String getAllIngredients() {
		
		String all = "";
		
		for(int i=0; i < ingredients.length;i++) {
		
			all+= ingredients[i] + ";";
		}
		return all;
	}
}
