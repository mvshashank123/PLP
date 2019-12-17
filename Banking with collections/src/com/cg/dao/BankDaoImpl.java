package com.cg.dao;

import java.util.concurrent.ArrayBlockingQueue;

import com.cg.bean.Customer;
import com.cg.util.BankCollection;

public class BankDaoImpl implements IBankDao {

	@Override
	public String addCustomerDetails(Customer c) {
		// TODO Auto-generated method stub
		BankCollection bc=new BankCollection();
		bc.addCustomer(c);
		String name= c.getCustName();
		return name;
	}

	@Override
	public double accountBalance(long accountNumber) {
		// TODO Auto-generated method stub
		BankCollection bc=new BankCollection();
		double balance=bc.accountBalance(accountNumber);
		return balance;
	}

	@Override
	public double accountWithdraw(long accNumber, long withdrawAmt) throws InterruptedException {
		BankCollection bc=new BankCollection();
		double newBalance=bc.withdrawAmount(accNumber,withdrawAmt);
		return newBalance;
		

	}

	@Override
	public double accountTransfer(long fromAccNumber, long toAccNumber, long transferAmount) throws InterruptedException {
		// TODO Auto-generated method stub
		BankCollection bc=new BankCollection();
		double newBalance=bc.accountTransfer(fromAccNumber,toAccNumber,transferAmount);
		return newBalance;
		

	}

	@Override
	public double accountDeposit(long accNum,long depositAmt) throws InterruptedException {
		// TODO Auto-generated method stub
		BankCollection bc=new BankCollection();
		double newBalance=bc.depositAmount(accNum,depositAmt);
		return newBalance;
		

	}

	@Override
	public ArrayBlockingQueue<String> accountTransactions(long accNumber1) throws InterruptedException {
		// TODO Auto-generated method stub
		BankCollection bc=new BankCollection();
		
			return bc.accountTransactions(accNumber1);
	
}}
