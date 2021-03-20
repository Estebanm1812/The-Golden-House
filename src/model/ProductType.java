package model;

import java.io.Serializable;

public class ProductType implements Serializable {

	private static final long serialVersionUID = 5L;
	private String name;
	
	public ProductType(String name) {
	
		this.name = name;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
