package com.cg.banking.validation;

import com.cg.banking.dao.BankDaoImpl;
import com.cg.banking.exception.BankingException;

public class BankValidation {

	static BankDaoImpl bankDAOImpl=new BankDaoImpl();
	
	public static boolean nameCheck(String name) throws BankingException {
		int n = name.length();
		char[] ch = name.toCharArray();
		for (int i = 0; i < n; i++) {
			try {
				if (ch[i] > 64 && ch[i] < 122 && ch[0] > 63 && ch[0] < 90) {
					return true;
				} else {
					throw new BankingException("Invalid Name");
				}
			} catch (BankingException E) {
				System.out.println(E);
				return false;
			}
		}
		return false;
	}

	public static boolean pinCheck(int pin) throws BankingException {
		try {
			String g=Integer.toString(pin);
			if (g.matches("[0-9]+") && g.length() == 4) {
				return true;
			} else {
				throw new BankingException("Invalid PIN");

			}
		} catch (BankingException e) {
			return false;
		}
	}

	public static boolean phoneNumberCheck(String number) throws BankingException {
		try {
			if (number.matches("[0-9]+") && number.length() == 10) {
				return true;
			} else {
				throw new BankingException("Invalid PhoneNumber");
			}
		} catch (BankingException e) {
			return false;
		}
	}
	
	public static boolean accNoCheck(int accountNumber)
	{
		if(bankDAOImpl.checkAccountNumber(accountNumber))
		return true;
		
		System.out.println("Invalid AccountNumber");
		return false;
		
     }
}