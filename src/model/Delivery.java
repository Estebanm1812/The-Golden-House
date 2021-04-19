package model;

import java.io.Serializable;


public class Delivery implements Serializable{

	private static final long serialVersionUID = 2L;

	private double code;
	
	private String state;
	
	private String [] productList;
	
	private double [] productPrices;
	
	private int [] amount;
	
	private double totalPrice;
	
	private String customer;
	
	private String employee;
	
	private String date;
	
	public Delivery(String customer,String[] productList,int [] amount,String employee, String date, double [] productPrices) {
		
		code = (Math.random()*((1000000-00000001)+1)+0000001);
		state = "SOLICITADO";
		this.productList = productList;
		this.customer = customer;
		this.date = date;
		this.employee = employee;
		totalPrice = calculateTotalPrice();
		this.amount = amount;
		this.productPrices = productPrices;
	}

	public double getCode() {
		return code;
	}

	public void setCode(double code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String [] getProductList() {
		return productList;
	}

	public void setProductList(String [] productList) {
		this.productList = productList;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
		
	}
	public double [] productPrices() {
		return productPrices;
	}
	public void setProductPrices(double [] prices) {
		productPrices = prices;
	}
	
	public int[] getAmount() {
		return amount;
	}
	public void setAmount(int[] amount) {
		this.amount = amount;
	}
	public double calculateTotalPrice() {
		
		double total = 0;
		System.out.println("aqui1");
		for(int i=0; i < productList.length;i++) {
			System.out.println("aqui1.5");
			total+= productPrices[i]*amount[i];
			
			System.out.println("aqui2");
		}
		System.out.println("aqui3");
		return total;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getProductsList() {
		
		String products = "";
		
		for(int i=0; i < productList.length;i++) {
			
			products+= productList[i] + ", ";
		}
		
		return products;
	}
	public String getQuanty() {
		
		String quantity = "";
		
		for(int i=0; i < amount.length;i++) {
			
			quantity+= amount[i] + ", "; 
		}
		
		return quantity;
	}
	public String getPrices() {
		
		String prices = "";
		
		for(int i=0; i < productPrices.length;i++) {
			prices += productPrices[i] + " ,";
			
		}	
		return prices;
	}
	
}
