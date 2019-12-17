package com.cg.banking.bean;

public class Bank {

	private int acNo;

	private String name;

	private String dob;

	private String number;

	private int pin;

	private long balance;

	public Bank(int acNo, String name, String dob, String number, int pin, long balance) {
		super();
		this.acNo = acNo;
		this.name = name;
		this.number = number;
		this.dob = dob;
		this.pin = pin;
		this.balance = balance;

	}

	public Bank() {

	}

	public int getAcNo() {
		return acNo;
	}

	public void setAcNo(int acNo) {
		this.acNo = acNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Bank acNo=" + acNo + ", name=" + name + ", number=" + number + ", dob=" + dob + ", pin=" + pin
				+ ", balance=" + balance;
	}

}
