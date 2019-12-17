package com.cg.banking.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.cg.banking.bean.Bank;
import com.cg.banking.bean.Transaction;
import com.cg.banking.dao.BankDaoImpl;
import com.cg.banking.dao.IBankDAO;
import com.cg.banking.exception.BankingException;

public class BankServiceImpl implements IBankService{

	IBankDAO dao = new BankDaoImpl();
	
	@Override
	public void accountCreate(Bank bank,Transaction tran) {
		dao.accountCreate(bank,tran);
	}

	@Override
	public String balCheck(int accNo) {
		return  dao.balCheck(accNo);
	}

	@Override
	public String addMoney(int accNumber, long amt, Transaction tran) {
		return  dao.addMoney(accNumber, amt, tran);
	}

	@Override
	public String withdrawMoney(int accNumber, long amt, Transaction tran) {
		return  dao.withdrawMoney(accNumber, amt, tran);
	}


	@Override
	public String moneyTransfer(int accNumber1, long amt1, int accNumber2,Transaction tran1,Transaction tran2) {
		return dao.moneyTransfer(accNumber1,amt1,accNumber2,tran1,tran2);
	}

	@Override
	public String getTransactionDetails(int accNumber) {
		
		HashMap<Integer,Transaction> hm = dao.printTransactions(accNumber);
		Set set = hm.entrySet();
		Iterator iterator = set.iterator();
		String trans = "" ;
		while(iterator.hasNext())
		{
			Map.Entry pair = (Map.Entry)iterator.next();
			int transid=(int) pair.getKey();
			Transaction transaction=(Transaction) pair.getValue();
			trans=trans+"\n"+"Transaction ID :"+transid+"|| Account number :"+transaction.getAcno()+"|| Transaction Type :"+transaction.getOpertaion();
		}
		return trans;
	}
}
