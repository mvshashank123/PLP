package com.cg.banking.ui;

import java.util.Scanner;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;

import com.cg.banking.bean.Bank;
import com.cg.banking.bean.Transaction;
import com.cg.banking.exception.BankingException;
import com.cg.banking.service.BankServiceImpl;
import com.cg.banking.service.IBankService;
import com.cg.banking.validation.BankValidation;

public class UserInterface {

	public static void main(String args[]) {
		Bank banking;
		Transaction trans = new Transaction();
		IBankService bankService = new BankServiceImpl();
		Scanner scan = new Scanner(System.in);
		int option;
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		while (true) {
			System.out.println("*****************************");
			System.out.println("<<<<<<<<< Welcome to Capgemini bank!! >>>>>>>>>");
			System.out.println("Please Select Your Option...");
			System.out.println("1.Create an Account");
			System.out.println("2.Balance Check");
			System.out.println("3.Money Deposit");
			System.out.println("4.Money Withdrawl");
			System.out.println("5.Money Transfer");
			System.out.println("6.Print Transactions");
			System.out.println("7.Exit");
			option = scan.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter Your Name:");
				String name = scan.next();
				try {
					while(!BankValidation.nameCheck(name))
					{
						System.out.print("Enter Your Name: ");
						name = scan.next();
						name += scan.nextLine();
					}
				} catch (BankingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Enter your date of birth DD/MM/YYYY");
				String dob = scan.next();
				System.out.println("Enter your 10 digit contact no.");
				String phno = scan.next();
				try {
					while(!BankValidation.phoneNumberCheck(phno))
					{
						 System.out.print("Enter your 10 digit contact number : ");
	                	 phno=scan.next();
					}
				} catch (BankingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Enter your 4 digits pin");
				int pin = scan.nextInt();
				try {
					while(!BankValidation.pinCheck(pin))
					{
						 System.out.print("Enter valid pin: ");
	                	 pin=scan.nextInt();
					}
				} catch (BankingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Enter the amount to be deposited");
				long amt = scan.nextLong();
				int acno = (int) ((Math.random()) * 136472);
				int tranid = (int) ((Math.random()) * 1893);
				banking = new Bank(acno, name, dob, phno, pin, amt);
				trans = new Transaction(tranid, acno, "Account is Created. Date : " + date + " Time : " + time
						+ " Rs." + amt + " is deposited successfully.");
				bankService.accountCreate(banking, trans);
				System.out.println("Your account is created.\nYour Acc number is: " + acno);
				break;
			case 2:
				System.out.println("Enter your Account number: ");
				int accountNumber = scan.nextInt();
				while(!BankValidation.accNoCheck(accountNumber))
				{
					 System.out.print("Enter the correct Account number: ");
					 accountNumber=scan.nextInt();
				}
				String message = bankService.balCheck(accountNumber);
				System.out.println(message);
				break;
			case 3:
				System.out.println("Enter your Account number: ");
				int accountNumber1 = scan.nextInt();
				while(!BankValidation.accNoCheck(accountNumber1))
				{
					 System.out.print("Enter the correct Account Number: ");
					 accountNumber1=scan.nextInt();
				}
				System.out.println("Enter the amount to be Deposited:");
				long amount = scan.nextLong();
				int tranidd = (int) ((Math.random()) * 100000);
				trans = new Transaction(tranidd, accountNumber1, "Ammount is Deposited. Date : " + date + " Time : "
						+ time + " Rs." + amount + " is deposited successfully.");
				String message1 = bankService.addMoney(accountNumber1, amount, trans);
				System.out.println(message1);
				break;
			case 4:
				System.out.println("Enter your Account number: ");
				int accountNumberr = scan.nextInt();
				while(!BankValidation.accNoCheck(accountNumberr))
				{
					 System.out.print("Enter correct Account Number: ");
					 accountNumberr=scan.nextInt();
				}
				System.out.println("Enter Amount to be withdrawn: ");
				long amountt = scan.nextLong();
				int tranId = (int) ((Math.random()) * 100000);
				trans = new Transaction(tranId, accountNumberr, "Ammount is Withdrawn. Date : " + date + " Time : "
						+ time + " Rs." + amountt + " is withdrawn successfully.");
				String messagee = bankService.withdrawMoney(accountNumberr, amountt, trans);
				System.out.println(messagee);
				break;
			 case 5:
			 System.out.println("Enter Your Account Number: ");
			 int accountNumber01=scan.nextInt();
			 while(!BankValidation.accNoCheck(accountNumber01))
				{
					 System.out.print("Enter the correct Account Number: ");
					 accountNumber01=scan.nextInt();
				}
			 System.out.println("Enter the Amount to be send: ");
			 long amount01=scan.nextLong();
			 System.out.println("Enter receivers Account Number: ");
			 int accountNumber02=scan.nextInt();
			 while(!BankValidation.accNoCheck(accountNumber02))
				{
					 System.out.print("Enter the correct Account Number: ");
					 accountNumber02=scan.nextInt();
				}
			 int tranid1=(int) ((Math.random()) * 17834);
			 int tranid2=(int) ((Math.random()) * 19822);
			Transaction trans1 = new Transaction(tranid1, accountNumber01, "Ammount is Sent. Date : " + date + " Time : "
						+ time + " Rs." + amount01 + " is set to "+ accountNumber02+" successfully.");
			Transaction trans2 = new Transaction(tranid2, accountNumber02, "Ammount is Received. Date : " + date + " Time : "
					+ time + " Rs." + amount01 + " is received from "+ accountNumber02+" successfully.");
			 String messages=bankService.moneyTransfer(accountNumber01,
			 amount01,accountNumber02,trans1,trans2);
			 System.out.println(messages);
			 break;
			case 6:
				System.out.println("Enter Your Account Nmuber");
				int accountNumbers = scan.nextInt();
				 while(!BankValidation.accNoCheck(accountNumbers))
					{
						 System.out.print("Enter the Correct Account Number: ");
						 accountNumbers=scan.nextInt();
					}
				 System.out.println(bankService.getTransactionDetails(accountNumbers));
				break;
			case 7:
				System.exit(0);
				break;
			default:

			}
		}

	}

}
