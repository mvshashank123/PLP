package com.cg.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.bean.Customer;
import com.cg.service.BankServiceImpl;
import com.cg.util.BankCollection;

public class TestCases {

	Customer ct=null;
	Customer ct1=null;
	BankServiceImpl b=new BankServiceImpl();
	@Before
	public void setUp() throws Exception {
		ct=new Customer();
		ct1=new Customer();
		ct.setAccountNumber();
		ct.setCustName("Karthik");
		ct.setCellNo(8722333803l);
		ct.setBalance(2000);
		ct1.setAccountNumber();
		ct1.setCustName("Suraj");
		ct1.setCellNo(9483398752l);
		ct1.setBalance(3000);
        
		b.addCustomerDetails(ct);
	    b.addCustomerDetails(ct1);
	}

	@After
	public void tearDown() throws Exception {
		ct=null;
	    b=null;
	}

	@Test
	public void testAddCustomerDetails() {
		b.addCustomerDetails(ct);
		String s=ct.getCustName();
		System.out.println(s);
	    assertEquals("Karthik",s);
	    System.out.println(ct.getAccountNumber());
		assertEquals(8722333803l,ct.getCellNo());
	}


	@Test
	public void testIsValidCustName() {
		assertEquals(true,b.isValidCustName("Shashank"));
	}

	@Test
	public void testIsValidCellNo() {
		assertEquals(true,b.isValidCellNo("9886803797"));
	}

	@Test
	public void testAccountBalance() {
		assertEquals(2000,ct.getBalance());
	}

	@Test
	public void testAccountWithdraw() throws InterruptedException {
		
		assertEquals(1600.0,b.accountWithdraw(ct.getAccountNumber(),400),1);
		
		
	}

	@Test
	public void testAccountDeposit() throws InterruptedException {
		
		assertEquals(2400.0,b.accountDeposit(ct.getAccountNumber(),400),1);
	}
	
	@Test
	public void testAccountTransfer() throws InterruptedException{
		
		assertEquals(1600.0,b.accountTransfer(ct.getAccountNumber(),ct1.getAccountNumber(),400),1);
		
	}
	


}
