package com.cg.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.cg.bean.Customer;
import com.cg.dao.BankDaoImpl;
import com.cg.exception.InvalidCustomerNameException;
import com.cg.exception.cellNoException;


public class BankServiceImpl implements IBankService{

	@Override
	public String addCustomerDetails(Customer c) throws InputMismatchException{
		// TODO Auto-generated method stub
		BankDaoImpl bdi=new BankDaoImpl();
		String name=bdi.addCustomerDetails(c);
		
		return name;
	}
	public void validateCustomer(Customer c) throws InputMismatchException, InvalidCustomerNameException, cellNoException
	{
		List<String> validationErrors = new ArrayList<String>();

		
		if(!(isValidCustName(c.getCustName()))) {
			validationErrors.add("\n Customer Name Should Be In Alphabets and minimum 3 characters long ! \n");
		    throw new InvalidCustomerNameException(c.getCustName());
		}
		String cN;
		cN=String.valueOf(c.getCellNo());
		if(!(isValidCellNo(cN))){
			validationErrors.add("\n Cell Number Should be in 10 digit \n");
		}

	}
	
	
	public boolean isValidCustName(String custName) throws InputMismatchException{
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(custName);
		return nameMatcher.matches();
	}
	public boolean isValidCellNo(String cellNo){
		Pattern cellNoPattern=Pattern.compile("^[6-9]{1}[0-9]{9}$");
		Matcher cellNoMatcher=cellNoPattern.matcher(cellNo);
		return cellNoMatcher.matches();
	}

	@Override
	public double accountBalance(long accountNumber) {
		// TODO Auto-generated method stub
		BankDaoImpl bdi=new BankDaoImpl();
		double balance=bdi.accountBalance(accountNumber);
		return balance;
	}

	@Override
	public double accountWithdraw(long accNumber, long withdrawAmt) throws InterruptedException {
		// TODO Auto-generated method stub
		BankDaoImpl bdi=new BankDaoImpl();
		double newBalance=bdi.accountWithdraw(accNumber, withdrawAmt);
		return newBalance;
	}

	@Override
	public double accountTransfer(long fromAccNumber, long toAccNumber, long transferAmount) throws InterruptedException {
		// TODO Auto-generated method stub
		BankDaoImpl bda=new BankDaoImpl();
		double newBalance=bda.accountTransfer(fromAccNumber,toAccNumber,transferAmount);
		return newBalance;
		
	}

	@Override
	public double accountDeposit(long accNum, long depositAmt) throws InterruptedException {
		// TODO Auto-generated method stub
		BankDaoImpl bdi=new BankDaoImpl();
		double newBalance=bdi.accountDeposit(accNum, depositAmt);
		return newBalance;
		
	}

	@Override
	public ArrayBlockingQueue<String> accountTransactions(long accNumber1) throws InterruptedException  {
		// TODO Auto-generated method stub
		BankDaoImpl bdi=new BankDaoImpl();
		return bdi.accountTransactions(accNumber1);
	}
	

}
