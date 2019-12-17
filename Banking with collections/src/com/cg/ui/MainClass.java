package com.cg.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import com.cg.bean.Customer;
import com.cg.exception.InvalidCustomerNameException;
import com.cg.exception.cellNoException;
import com.cg.service.BankServiceImpl;

public class MainClass{
		
	

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws InterruptedException, cellNoException, InputMismatchException, InvalidCustomerNameException {
		// TODO Auto-generated method stub
		int opt;
		BankServiceImpl bsi=new BankServiceImpl();
  while(true){
		
		System.out.println("Welcome to Axis Bank");
		System.out.println("Enter the service required");
		System.out.println("1.Create an Account");
		System.out.println("2.Show Balance");
		System.out.println("3.Deposit");
		System.out.println("4.Withdraw");
		System.out.println("5.Fund Transfer");
		System.out.println("6.Print Transactions");
		
		
		opt=sc.nextInt();
		
		switch(opt){
		
		case 1:

			
			Customer c=new Customer();
			
			System.out.println("enter the details");
			
			System.out.println("Enter Customer Name");
			c.setCustName(sc.next());
			
			System.out.println("Enter Mobile Number");
			String cN=sc.next();
			long cellNo;
			if(cN.length()!=10){
				throw new cellNoException(cN);
			}
			cellNo=Long.parseLong(cN);
			
			c.setCellNo(cellNo);
			
			
		
			c.setBalance(0);
		
			
			c.setAccountNumber();
			
			String name;
			
			
		    name=bsi.addCustomerDetails(c);
		    System.out.println("Dear "+name+" your account has been created sucessfully");
		    bsi.validateCustomer(c);
		    break;
			
		case 2:
			double balance;
			
			//Customer bal=new Customer();
			try{
			System.out.println("enter the account number");
			long accountNumber;
			accountNumber=sc.nextLong();
			balance=bsi.accountBalance(accountNumber);
			System.out.println("The balance is "+balance);
			}
			catch(InputMismatchException e){
			System.out.println("Enter a valid Account Number");
				
			}
			Customer c1=new Customer();
			break;
		case 3:
			long depositAmt;
			
			try{
			System.out.println("enter the account number");
			long accNum;
			accNum=sc.nextLong();
			System.out.println("enter the deposit amount");
			depositAmt=sc.nextLong();
			balance=bsi.accountDeposit(accNum,depositAmt);
			System.out.println("The new balance is "+balance);
			}
			catch(InputMismatchException e){
				System.out.println("Enter a valid Account Number");
					
				}
			break;
			
		case 4:
			long withdrawAmt;
			try{
			System.out.println("Enter the Account Number");
			long accNumber;
			accNumber=sc.nextLong();
			System.out.println("Enter the Withdraw Amount");
			withdrawAmt=sc.nextLong();
			balance=bsi.accountWithdraw(accNumber,withdrawAmt);
			System.out.println("The new balance is "+balance);
			}
			catch(InputMismatchException e){
				System.out.println("Enter a valid Account Number");
					
				}
			break;
			
		 case 5:
			 long fromAccNumber;
			 long toAccNumber;
			 long transferAmount;
			 try{
			 System.out.println("Enter your account number");
			 fromAccNumber=sc.nextLong();
			 System.out.println("Enter credit account number");
			 toAccNumber=sc.nextLong();
			 System.out.println("Enter the transfer amount");
			 transferAmount=sc.nextLong();
			 balance=bsi.accountTransfer(fromAccNumber,toAccNumber,transferAmount);
			 System.out.println("Your new balance is"+balance);
			 }
			 catch(InputMismatchException e){
					System.out.println("Enter a valid Account Number");
						
					}
			 break;
			 
		 case 6:
			 long accNumber1;
			 try{
			 System.out.println("Enter the account number");
			 accNumber1=sc.nextLong();
			 
			 ArrayBlockingQueue<String> q=new ArrayBlockingQueue<String>(5);
			 
			 q = bsi.accountTransactions(accNumber1);
			 System.out.println(q);
			 }
			 catch(InputMismatchException e){
					System.out.println("Enter a valid Account Number");
						
					}
			 break;
			
		
		default:
		{
			System.out.println("Please enter a valid input");
		}
  }
		
		
		
			
		
		


	}
	}
}
