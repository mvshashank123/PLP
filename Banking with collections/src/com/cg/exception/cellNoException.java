package com.cg.exception;

public class cellNoException extends Exception{
	
	private String cellNo;
	
	

	
	public cellNoException(String cN) {
		// TODO Auto-generated constructor stub
	    cellNo=cN;
	}


	@Override
	public String toString() {
		return ("cellNoException "+cellNo+" is not a 10 digit number");
	}
	

}
