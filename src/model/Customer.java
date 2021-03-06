package model;

public class Customer {

	private String names;
	
	private String lastNames;
	
	private String identificatorNumber;
	
	private String addres;
	
	private String phoneNumber;
	
	private String comment;
	
		public Customer(String names,String lastNames,String identificatorNumber, String addres, String phoneNumber, String comment ) {
	
		this.setNames(names);
		
		this.setLastNames(lastNames);
		
		this.setIdentificatorNumber(identificatorNumber);
		
		this.setAddres(addres);
		
		this.setPhoneNumber(phoneNumber);
		
		this.setComment(comment);
	
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

		public String getAddres() {
			return addres;
		}

		public void setAddres(String addres) {
			this.addres = addres;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}
	}
