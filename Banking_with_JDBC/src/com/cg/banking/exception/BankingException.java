package com.cg.banking.exception;

@SuppressWarnings("serial")

public class BankingException extends Exception {
	String s1;

	public BankingException(String s) {
		s1 = s;

	}

	public String toString() {
		return (s1);
	}
}
