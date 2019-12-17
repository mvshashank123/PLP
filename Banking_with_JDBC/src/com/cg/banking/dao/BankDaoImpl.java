package com.cg.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

import com.cg.banking.bean.Bank;
import com.cg.banking.bean.Transaction;
import com.cg.banking.exception.BankingException;

public class BankDaoImpl implements IBankDAO {

	Connection conn;
	Bank bank;

	public BankDaoImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "India123");
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(BankDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void accountCreate(Bank bank,Transaction tran) {
		try {

			PreparedStatement prepareStatement = conn
					.prepareStatement("insert into banking_wallet values(?,?,?,?,?,?)");
			prepareStatement.setInt(1, bank.getAcNo());
			prepareStatement.setString(2, bank.getName());
			prepareStatement.setString(3, bank.getDob());
			prepareStatement.setString(4, bank.getNumber());
			prepareStatement.setInt(5, bank.getPin());
			prepareStatement.setLong(6, bank.getBalance());
			prepareStatement.execute();
		
			prepareStatement = conn
					.prepareStatement("insert into transactions values(?,?,?)");
			prepareStatement.setInt(1,tran.getTranId());
			prepareStatement.setInt(2,tran.getAcno());
			prepareStatement.setString(3,tran.toString());
			prepareStatement.execute();
			
		} catch (SQLException ex ) {
			Logger.getLogger(BankDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public String balCheck(int accountNo) {
		try {
			PreparedStatement prepareStatement = conn
					.prepareStatement("select balance from banking_wallet where accno=?");
			prepareStatement.setInt(1, accountNo);
			ResultSet resultSet = prepareStatement.executeQuery();
			resultSet.next();
			long balance = resultSet.getLong("balance");
			return "Your Account with account-number " + accountNo + " has a balance of " + balance;
		} catch (SQLException ex) {
			Logger.getLogger(BankDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
			return "Error";
		}

	}

	@Override
	public String addMoney(int accountNumber, long amount, Transaction tran){
		try {
			PreparedStatement prepareStatement = conn
					.prepareStatement("update banking_wallet set balance = balance + ? where accno = ?");
			prepareStatement.setLong(1, amount);
			prepareStatement.setInt(2, accountNumber);
			prepareStatement.executeUpdate();
			prepareStatement = conn
					.prepareStatement("insert into transactions values(?,?,?)");
			prepareStatement.setInt(1,tran.getTranId());
			prepareStatement.setInt(2,tran.getAcno());
			prepareStatement.setString(3,tran.toString());
			prepareStatement.execute();
			return "Money Added Successfully";
		} catch (SQLException ex) {
			Logger.getLogger(BankDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
			return "Error";
		}
	}

	@Override
	public String withdrawMoney(int accountNumber, long amount, Transaction tran) {
		try {
			PreparedStatement prepareStatement = conn
					.prepareStatement("update banking_wallet set balance = balance - ? where accno = ?");
			prepareStatement.setLong(1, amount);
			prepareStatement.setInt(2, accountNumber);
			prepareStatement.executeUpdate();
			prepareStatement = conn
					.prepareStatement("insert into transactions values(?,?,?)");
			prepareStatement.setInt(1,tran.getTranId());
			prepareStatement.setInt(2,tran.getAcno());
			prepareStatement.setString(3,tran.toString());
			prepareStatement.execute();
			return "Money withdrawn Successfully";
		} catch (SQLException ex) {
			Logger.getLogger(BankDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
			return "Error";
		}
	}
	
	@Override
	public String moneyTransfer(int accountNumber01, long amount01, int accountNumber02,Transaction tran1,Transaction tran2) {
		try {
			PreparedStatement prepareStatement = conn
					.prepareStatement("update banking_wallet set balance = balance - ? where accno = ?");
			prepareStatement.setLong(1, amount01);
			prepareStatement.setInt(2, accountNumber01);
			prepareStatement.executeUpdate();
			prepareStatement = conn
					.prepareStatement("insert into transactions values(?,?,?)");
			prepareStatement.setInt(1,tran1.getTranId());
			prepareStatement.setInt(2,tran1.getAcno());
			prepareStatement.setString(3,tran1.toString());
			prepareStatement.execute();
			prepareStatement = conn
					.prepareStatement("update banking_wallet set balance = balance + ? where accno = ?");
			prepareStatement.setLong(1, amount01);
			prepareStatement.setInt(2, accountNumber01);
			prepareStatement.executeUpdate();
			prepareStatement = conn
					.prepareStatement("insert into transactions values(?,?,?)");
			prepareStatement.setInt(1,tran2.getTranId());
			prepareStatement.setInt(2,tran2.getAcno());
			prepareStatement.setString(3,tran2.toString());
			prepareStatement.execute();
			return "Money Transfered Successfully";
		} catch (SQLException ex) {
			Logger.getLogger(BankDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
			return "Error";
		}
		
	}

	@Override
	public HashMap<Integer, Transaction> printTransactions(int accountId) {
		HashMap<Integer, Transaction> transactionHash = new HashMap<Integer, Transaction>();
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("select * from transactions where acno = ?");
			prepareStatement.setInt(1, accountId);
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next())
			{
				Transaction transaction=new Transaction();
				int trid=resultSet.getInt("tranid");
				int anco=resultSet.getInt("acno");
				String oper=resultSet.getString("operation");
				
				transaction.setTranId(trid);
				transaction.setAcno(anco);
				transaction.setOpertaion(oper);
				
				transactionHash.put(trid, transaction);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return transactionHash;
		}
		return transactionHash;
	}
/*
 * Validation for account number check
 * 
*/		
	public boolean checkAccountNumber(int accountNo)
	{
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("select * from banking_wallet where accno = ?");
			prepareStatement.setInt(1, accountNo);
			ResultSet resultSet = prepareStatement.executeQuery();
			if(resultSet.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	

		
	}



}
