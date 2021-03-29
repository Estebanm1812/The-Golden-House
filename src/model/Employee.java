package model;

import java.io.Serializable;

public class Employee extends Person implements Serializable{

	private String state;
	
	private static final long serialVersionUID = 4L;
	

	public Employee(String name, String lastName, String identificatorNumber){
		
		super(name, lastName, identificatorNumber);	
		
		state = "ACTIVO";
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
