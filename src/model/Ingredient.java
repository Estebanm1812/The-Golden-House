package model;

import java.io.Serializable;

public class Ingredient implements Serializable{


	private static final long serialVersionUID = 3L;

	private String ingredientName;
	
	private String state;
	
	private String creator;
	
	private String lastModifie;
	
	private double code;
	
	public Ingredient(String ingredientName, String creator) {
	
		this.ingredientName = ingredientName;
		state = "ACTIVO";
		this.creator = creator;
		lastModifie = creator;
		code = (Math.random()*((1000000-00000001)+1)+0000001);
	}
	public String getIngredintName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
		
	}
	public String getState() {
		return state;
	}
	public void setState(String able) {
		state = able;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getLastModifie() {
		return lastModifie;
	}
	public void setLastModifie(String lastModifie) {
		this.lastModifie = lastModifie;
	}
	public double getCode() {
		return code;
	}
	
}
