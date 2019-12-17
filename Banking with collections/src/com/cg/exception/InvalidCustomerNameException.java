package com.cg.exception;

public class InvalidCustomerNameException extends Exception {
	
	private String custName;
	
	public InvalidCustomerNameException(String name){
		custName=name;
		
	}

	@Override
	public String toString() {
		return ("InvalidCustomerNameException "+custName+" is not a valid name");
	}
	

}
