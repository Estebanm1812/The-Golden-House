package model;

import java.io.Serializable;
import java.util.Date;

public class Delivery implements Serializable{

	private static final long serialVersionUID = 2L;

	private String code;
	
	private String state;
	
	private Product [] productList;
	
	private Customer customer;
	
	private Employee employee;
	
	private Date date;
	
	public Delivery(String code, String state, Product[] productList, Customer customer,Employee employee, Date date) {
		
		this.code = code;
		this.state = state;
		this.productList = productList;
		this.customer = customer;
		this.date = date;
		this.employee = employee;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Product [] getProductList() {
		return productList;
	}

	public void setProductList(Product [] productList) {
		this.productList = productList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
		
	}
	
	
}
