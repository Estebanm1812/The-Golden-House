package model;

public class Employee {

	protected String name;
	
	protected String lastName;
	
	protected String identificatorNumber;
	
	public Employee(String name, String lastName, String identificatorNumber){
		
		this.name = name;
		
		this.lastName = lastName;
		
		this.identificatorNumber = identificatorNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
		
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
	
		this.lastName = lastName;
	}
	public String getIdentificatorNumber() {
		return identificatorNumber;
	}
	public void setIdentificatorNumber(String identificatorNumber) {
	
		this.identificatorNumber = identificatorNumber;
		
	}
}
