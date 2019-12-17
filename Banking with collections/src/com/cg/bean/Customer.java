package com.cg.bean;

import java.util.concurrent.ArrayBlockingQueue;

public class Customer {
	

	private long accountNumber;
	private long cellNo;
	private int balance;
	private String custName;
	private double newBalance;
	private ArrayBlockingQueue<String> q=new ArrayBlockingQueue<String>(5);
	
	public ArrayBlockingQueue<String> getQ() {
		return q;
	}
	public void setQ(ArrayBlockingQueue<String> q) {
		this.q = q;
	}
	public double getNewBalance() {
		return newBalance;
	}
	public void setNewBalance(double newBalance) {
		this.newBalance = newBalance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber() {
		long num;
		num=(long)(Math.random()*10000000);
		accountNumber=num;
	}
	public long getCellNo() {
		return cellNo;
	}
	public void setCellNo(long cellNo) {
		this.cellNo = cellNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = (int) balance;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", cellNo=" + cellNo + ", balance=" + balance
				+ ", custName=" + custName + "]";
	}
	
	
	
       

}
