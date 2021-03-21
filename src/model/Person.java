package model;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = 7L;

	protected String names;
	
	protected String lastNames;
	
	protected String identificatorNumber;
	
	public Person(String names, String lastNames, String id) {
		
		this.names = names;
		
		this.lastNames = lastNames;
		
		identificatorNumber = id;
				
		
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getIdentificatorNumber() {
		return identificatorNumber;
	}

	public void setIdentificatorNumber(String identificatorNumber) {
		this.identificatorNumber = identificatorNumber;
	}
}
