package model;

public class Ingredient {

	private String ingredientName;
	
	private boolean able;
	
	private String creator;
	
	private String lastModifie;
	
	public Ingredient(String ingredientName, String creator) {
	
		this.ingredientName = ingredientName;
		able = true;
		this.creator = creator;
		lastModifie = creator;
	}
	public String getIngredintName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
		
	}
	public boolean isAble() {
		return able;
	}
	public void setAble(boolean able) {
		this.able = able;
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
	
}
