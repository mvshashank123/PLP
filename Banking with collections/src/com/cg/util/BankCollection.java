package com.cg.util;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.lang.InterruptedException;

import com.cg.bean.Customer;

public class BankCollection {
	
	static ArrayList<Customer> l=new ArrayList<Customer>();
	//String name;
//	long accno;
	
	static public void oldUsers(){
		Customer[] cs=new Customer[2];
		cs[0]=new Customer();
		cs[0].setAccountNumber();
		cs[0].setBalance(1545420);
		cs[0].setCustName("Ravi");
		cs[0].setCellNo(9887582462L);
		l.add(cs[0]);
		
		cs[1]=new Customer();
		cs[1].setAccountNumber();
		cs[1].setBalance(8545412);
		cs[1].setCustName("Avinash");
		cs[1].setCellNo(7447582462L);
		l.add(cs[1]);
	}
	
	
	
	public String addCustomer(Customer c) {
		// TODO Auto-generated method stub
		l.add(c);
		oldUsers();
		
		Iterator<Customer> itr=l.iterator(); {
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		}
		String name=c.getCustName();
		return name;
		
		
	}
	public double accountBalance(long accountNumber){
		double balance=0;
		for(Customer c:l){
				if(accountNumber==c.getAccountNumber()){
					balance=c.getBalance();
					
				}
			}
		return balance;
		}
	
	public double depositAmount(long accNum,long depositAmt) throws InterruptedException{
		double newBalance=0;
		for(Customer c:l){
			if(accNum==c.getAccountNumber()){
				newBalance=c.getBalance();
				newBalance=newBalance+depositAmt;
				
				c.setBalance(newBalance);
			}
			
		}
		accountTransactions(accNum,depositAmt);
		return newBalance;
	}



	public double withdrawAmount(long accNumber, long withdrawAmt) throws InterruptedException {
		double newBalance=0;
		for(Customer c:l){
			if(accNumber==c.getAccountNumber()){
				newBalance=c.getBalance();
				newBalance-=withdrawAmt;
				
				c.setBalance(newBalance);
			}
		}
		accountTransactions(accNumber,withdrawAmt);
		return newBalance;
				
	}



	public double accountTransfer(long fromAccNumber, long toAccNumber, long transferAmount) throws InterruptedException {
		// TODO Auto-generated method stub
		double newBalance = 0;

		
		for(Customer c1:l){
			if(fromAccNumber==c1.getAccountNumber()){
				double balance1=c1.getBalance();
				newBalance=balance1-transferAmount;
				c1.setBalance(newBalance);
			}
			
		for(Customer c2:l){
			if(toAccNumber==c2.getAccountNumber()){
				double balance2=c2.getBalance();
				balance2=balance2+transferAmount;
				c2.setBalance(balance2);
			}
		}
		}
		accountTransactions(fromAccNumber,transferAmount);
		return newBalance;
	}




	public void accountTransactions(long accNumber1,long amount) throws InterruptedException{
		ArrayBlockingQueue<String> q=new ArrayBlockingQueue<String>(5);
	
		
		for(Customer ct:l){
			if(accNumber1==ct.getAccountNumber()){
				Date d = new Date();
				
				q.addAll(ct.getQ());
				q.add(accNumber1+" was transacted on "+d + amount);
				ct.setQ(q);
				if(q.remainingCapacity()==0){
					q.take();
				}}}
				
			}
	

	public ArrayBlockingQueue<String> accountTransactions(long accNumber1) throws InterruptedException{
		ArrayBlockingQueue<String> q=new ArrayBlockingQueue<String>(5);
	
		
		for(Customer ct:l){
			if(accNumber1==ct.getAccountNumber()){
				Date d = new Date();
				
				q.addAll(ct.getQ());
				
			
			
		}}
		return q;
		
		
	}
	
		
	}
	
	
	



