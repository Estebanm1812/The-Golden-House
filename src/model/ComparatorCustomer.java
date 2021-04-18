package model;

import java.util.Comparator;

public class ComparatorCustomer implements Comparator<Customer>{

	@Override
	public int compare(Customer customer1, Customer customer2) {
		

		
		
		return customer1.getNames().compareToIgnoreCase(customer2.getNames());
	}
	

}
