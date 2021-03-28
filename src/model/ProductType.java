package model;

import java.io.Serializable;

public class ProductType implements Serializable {

	private static final long serialVersionUID = 5L;
	private String name;
	private String state;
	private String creator;
	private String lastModifie;
	private double code;
	
	public ProductType(String name, String currentUser) {
	
		this.name = name;
		state = "ACTIVO";
		creator = currentUser;
		code = (Math.random()*((1000000-00000001)+1)+0000001);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String name) {
		creator = name;
	}
	public String getLastModifie() {
		return lastModifie;
	}
	public void setLastModifie(String name) {
		lastModifie = name;
	}
	public double getCode() {
		return code;
	}
	public void setCode(double code) {
		this.code = code;
	}
	
}
