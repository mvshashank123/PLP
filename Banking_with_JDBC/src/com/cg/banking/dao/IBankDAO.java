package com.cg.banking.dao;

import java.sql.SQLException;
import java.util.HashMap;

import com.cg.banking.bean.Bank;
import com.cg.banking.bean.Transaction;
import com.cg.banking.exception.BankingException;

public interface IBankDAO {
	
	public void accountCreate(Bank bank,Transaction tran) ;
	
	public String balCheck(int accountNo) ;
	
	public String addMoney(int accountNumber,long amount,Transaction tran) ;
	
	public String withdrawMoney(int accountNumber,long amount,Transaction tran);
	
	public HashMap<Integer,Transaction> printTransactions(int  accountId)  ;	

	public String moneyTransfer(int accountNumber01, long amount01, int accountNumber02,Transaction tran1,Transaction tran2) ;


	
}
