package model;

public class Ingredient {

	private String ingredientName;
	
	private boolean able;
	
	public Ingredient(String ingredientName, boolean able) {
	
		this.ingredientName = ingredientName;
		this.setAble(able);
		
		
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
	
}
