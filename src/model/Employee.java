package model;

import java.io.Serializable;

public class Employee extends Person implements Serializable{

	private String state;
	
	private static final long serialVersionUID = 4L;
	
	private double code;

	public Employee(String name, String lastName, String identificatorNumber){
		
		super(name, lastName, identificatorNumber);
		
		code = (Math.random()*((1000000-00000001)+1)+0000001);
		
		state = "ACTIVO";
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getCode() {
		return code;
	}
	public void setCode(double code) {
		this.code = code;
	}
	
}
