package com.cg.dao;

import java.util.concurrent.ArrayBlockingQueue;

import com.cg.bean.Customer;

public interface IBankDao {
	
	public String addCustomerDetails(Customer c);
	public double accountBalance(long accountNumber);
	public double accountWithdraw(long accNumber, long withdrawAmt) throws InterruptedException;
	public double accountTransfer(long fromAccNumber, long toAccNumber, long transferAmount) throws InterruptedException;
	public double accountDeposit(long accNum,long depositAmt) throws InterruptedException;
	public ArrayBlockingQueue<String> accountTransactions(long accNumber1) throws InterruptedException;

}
