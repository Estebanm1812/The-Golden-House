package model;

public class Product {

	private String name;
	
	private double [] prices;
	
	private String [] sizes;
	
	public Product(String name, double [] prices, String [] sizes) {
	
		this.name = name;
		
		this.prices = prices;
		
		this.sizes = sizes;
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
}
